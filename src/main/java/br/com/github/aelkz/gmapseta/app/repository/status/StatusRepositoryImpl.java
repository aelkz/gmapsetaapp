package br.com.github.aelkz.gmapseta.app.repository.status;

import br.com.github.aelkz.gmapseta.app.model.Info;
import br.com.github.aelkz.gmapseta.app.model.Status;
import br.com.github.aelkz.gmapseta.app.repository.Point;
import br.com.github.aelkz.gmapseta.app.repository.Route;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ScriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StatusRepositoryImpl implements StatusRepositoryCustom {

    private final Logger LOGGER = Logger.getLogger(StatusRepositoryImpl.class.getName());

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public Status findStatus(@RequestParam String id) {
        Route route = Route.getRoute(id);

        // /------------------------------------------------\
        // | 2- Selenium HtmlUnit Driver method             |
        // |------------------------------------------------|
        // | Acquire html with browser rendering            |
        // \------------------------------------------------/
        HtmlUnitDriver driver = null;

        try {
            LOGGER.info("trying to get information for route #" + route.getId());
            Wait<WebDriver> wait;

            driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_45);
            driver.setJavascriptEnabled(false);
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);

            driver.get(route.getRouteUrl());

            wait = new WebDriverWait(driver, 5);

            // /------------------------------------------------\
            // | 1-acquire traffic data from gmaps html source  |
            // \------------------------------------------------/

            String content = driver.getPageSource();
            int start = content.indexOf(route.getKilometersAsText());
            int end = start + 350;
            content = content.substring(start, end);

            // use the info builder (to not replicate code)
            Info info = new Info.Builder(content, route).build();

            Status status = Status.from(info);

            // /------------------------------------------------\
            // | 2-calculate fill percent value + color         |
            // \------------------------------------------------/

            // 2.1 get the arrival time (to get the best traffic time scenario)
            // 2.2 calculate the traffic scenarios (best <= (arrivalTime + 2min), good <= (best + 3 min), average <= (good + 10 min), worst >= ( average + 1 min))
            // 2.3 sets the color based on traffic scenarios above (best = #B2C831, good = #FFC90E, average = #FF7F27, worst = #FA1D2D)


            return status;
        } catch(WebDriverException e) {
            LOGGER.severe("driver.exception: trying to get information for route #"+route.getId());
            LOGGER.severe("driver.exception.message: "+e.getMessage());
        } catch(ScriptException e) {
            // trying to get rid off scripting exceptions
            LOGGER.severe("script.exception: trying to get information for route #"+route.getId());
            LOGGER.severe("script.exception.message: "+e.getMessage());
        } catch(Exception e) {
            LOGGER.severe("exception: trying to get information for route #"+route.getId());
            LOGGER.severe("exception.message: "+e.getMessage());
            // needed for debugging purposes.
            e.printStackTrace();
        } finally {
            if (driver != null)
                driver.close();
        }

        return null;
    }

    @Override
    // /------------------------------------------------\
    // | findAll method                                 |
    // |------------------------------------------------|
    // | Try to acquire the best route with better      |
    // | traffic and distance conditions plus all other |
    // | routes with the same origin                    |
    // \------------------------------------------------/
    public List<Status> findAll(Integer origin) {
        Status bestStatus = Status.from(new Info.Builder(null,null).empty());
        Status currentStatus = null;

        int comparison = 0;

        List<Status> all = new ArrayList<>();
        List<Status> allFiltered = new ArrayList<>();

        for (Route route: Route.getRoutesBy(Point.getPoint(origin))) {
            currentStatus = findStatus(String.valueOf(route.getId()));
            comparison = bestStatus.getTraffic().compareTo(currentStatus.getTraffic());
            if (comparison == 1) {
                bestStatus = currentStatus;
            }
            all.add(currentStatus);
        }

        final Long bestId = bestStatus.getId();
        bestStatus.setSelected(true);

        allFiltered = all.stream().filter(e -> !e.getId().equals(bestId)).collect(Collectors.toList());
        allFiltered.add(bestStatus); // add the best route to the return list

        return allFiltered;
    }

}
