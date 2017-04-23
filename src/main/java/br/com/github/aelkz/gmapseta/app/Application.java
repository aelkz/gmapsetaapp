package br.com.github.aelkz.gmapseta.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

// /------------------------------------------------\
// | 1- SpringBoot deployable war file config.      |
// |------------------------------------------------|
// | Application deployed into web server (tomcat)  |
// \------------------------------------------------/

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Object[] { Application.class }, args);
    }
}
