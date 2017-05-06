package br.com.github.aelkz.gmapseta.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// /------------------------------------------------\
// | 1- SpringBoot deployable war file config.      |
// |------------------------------------------------|
// | Application deployed into web server (tomcat)  |
// \------------------------------------------------/

// http://stackoverflow.com/questions/34414367/mongo-tries-to-connect-automatically-to-port-27017localhost
// http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-mongodb
// http://stackoverflow.com/questions/35415308/exception-in-monitor-thread-while-connecting-to-server-localhost27017-while-acc
// http://stackoverflow.com/questions/28747909/how-to-disable-spring-data-mongodb-autoconfiguration-in-spring-boot
// https://sdqali.in/blog/2016/07/16/controlling-redis-auto-configuration-for-spring-boot-session/
// http://stackoverflow.com/questions/35849383/mongodb-trying-to-connect-to-localhost-why

/**
 * exclude = {EmbeddedMongoAutoConfiguration.class, DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, SpringDataWebAutoConfiguration.class, HibernateJpaAutoConfiguration.class}
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/info").allowedOrigins("http://198.199.67.245:8080");
                registry.addMapping("/info").allowedOrigins("http://localhost:8100");
            }
        };
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Object[] { Application.class }, args);
    }
}