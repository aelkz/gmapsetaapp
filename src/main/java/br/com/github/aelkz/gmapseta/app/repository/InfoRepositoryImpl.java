package br.com.github.aelkz.gmapseta.app.repository;

import br.com.github.aelkz.gmapseta.app.model.Info;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ScriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class InfoRepositoryImpl implements InfoRepositoryCustom {

    private final Logger LOGGER = Logger.getLogger(InfoRepositoryImpl.class.getName());

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public Info findTraffic(@RequestParam String id) {
        Route route = Route.getRoute(id);

        // /------------------------------------------------\
        // | 1- Jsoup method                                |
        // |------------------------------------------------|
        // | Acquire html without browser rendering (raw)   |
        // \------------------------------------------------/
        //Document doc = null;
        //try {
            //doc = Jsoup.connect(route.getRouteUrl()).userAgent("Mozilla/5.0").timeout(30000).get();
            //System.out.println("url: "+route.getRouteUrl());
            //System.out.println(doc.body().outerHtml());
            //System.out.println(doc.body().html());
        //} catch (IOException e) {
            //e.printStackTrace();
        //}

        // /------------------------------------------------\
        // | 2- Selenium HtmlUnit Driver method             |
        // |------------------------------------------------|
        // | Acquire html with browser rendering            |
        // \------------------------------------------------/
        HtmlUnitDriver driver = null;

        // http://www.seleniumhq.org/docs/04_webdriver_advanced.jsp
        // At first this method will not be used, because the page will not be fully loaded.
        ExpectedCondition<Boolean> javascriptLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                // javascript:console.log(document.readyState);
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };

        try {
            LOGGER.info("trying to get information for route #" + route.getId());
            Wait<WebDriver> wait;

            driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_45);
            driver.setJavascriptEnabled(false);
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);

            driver.get(route.getRouteUrl());

            wait = new WebDriverWait(driver, 5);
            //wait.until(javascriptLoad);

            String content = driver.getPageSource();
            int start = content.indexOf(route.getKilometersAsText());
            int end = start + 350;
            content = content.substring(start, end);

            Info info = new Info.Builder(content, route).build();

            return info;
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
    @RequestMapping(method = RequestMethod.GET)
    public Info findTraffic(@RequestParam String id, @RequestParam String location) {
        return null;
    }

    @Override
    // /------------------------------------------------\
    // | findBestRoute method                           |
    // |------------------------------------------------|
    // | Try to acquire the best route with better      |
    // | traffic and distance conditions                |
    // \------------------------------------------------/
    public Info findBestRoute(Integer origin) {
        Info bestInfo = new Info.Builder(null,null).empty();
        Info currentInfo = null;

        int comparison = 0;

        for (Route route: Route.getRoutesBy(Point.getPoint(origin))) {
            currentInfo = findTraffic(String.valueOf(route.getId()));
            comparison = bestInfo.getTraffic().compareTo(currentInfo.getTraffic());
            if (comparison == 1) {
                bestInfo = currentInfo;
            }
        }

        return bestInfo;
    }

    @Override
    public List<Info> findAllTraffic(Integer origin) {
        List<Info> all = new ArrayList<>();
        for (Route route: Route.getRoutesBy(Point.getPoint(origin))) {
            all.add(findTraffic(String.valueOf(route.getId())));
        }
        return all;
    }

}
