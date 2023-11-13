package com.satellitetv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.*;


@SpringBootApplication
public class SatelliteApplication
{
    private static final Logger LOGGER = LogManager.getLogger(SatelliteApplication.class);
    public static void main(String[] args) {
        LOGGER.info("Application started success!!!!");
        SpringApplication.run(SatelliteApplication.class, args);
    }
}
