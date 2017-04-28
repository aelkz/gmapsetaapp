package br.com.github.aelkz.gmapseta.app.repository;

import br.com.github.aelkz.gmapseta.app.model.Info;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class InfoRepositoryImpl implements InfoRepositoryCustom {

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public Info findTraffic(@RequestParam String id) {
        Routes route = Routes.getRoute(id);

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
        String content = null;
        int start=0,end=0;

        try {
            System.out.println("info: trying to get information for route #"+route.getId());
            driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_45);
            driver.setJavascriptEnabled(true);
            Wait<WebDriver> wait;

            driver = new HtmlUnitDriver();
            wait = new WebDriverWait(driver, 30);
            driver.get(route.getRouteUrl());

            content = driver.getPageSource();
            start = content.indexOf(route.getKilometersAsText());
            end = start+350;
            content = content.substring(start,end);

            Info info = new Info.Builder(content,route).build();

            return info;
        } catch(Exception e) {
            System.out.println("exception: trying to get information for route #"+route.getId());
            if (content != null) {
                System.out.println("content.length:"+content.length());
                System.out.println("start:"+start);
                System.out.println("end:"+end);
            }
            System.out.println();
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

}
