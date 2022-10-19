package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static java.lang.String.format;

/**
 * Main
 */
@Slf4j
@SpringBootApplication
public class ExerciseApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(ExerciseApplication.class, args);
        logUrls(ctx);
    }

    private static void logUrls(ConfigurableApplicationContext ctx) {
        var port = ctx.getEnvironment().getProperty("local.server.port");
        log.info(format("Everything's fine! \n" +
                        "http://localhost:%s\n" +
                        "GET http://localhost:%s/health\n" +
                        "POST http://localhost:%s/api/v1/fizzrule\n" +
                        "GET http://localhost:%s/api/v1/stats\n",
                port, port, port, port));
    }
}