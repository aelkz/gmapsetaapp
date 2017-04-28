package br.com.github.aelkz.gmapseta.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// /------------------------------------------------\
// | 1- SpringBoot deployable war file config.      |
// |------------------------------------------------|
// | Application deployed into web server (tomcat)  |
// \------------------------------------------------/

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Object[] { Application.class }, args);
    }
}
