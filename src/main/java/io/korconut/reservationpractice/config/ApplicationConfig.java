package io.korconut.reservationpractice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.korconut.reservationpractice.config.DBConfig;

@Configuration
@ComponentScan(basePackages = { "io.korconut.reservationpractice.dao", "io.korconut.reservationpractice.service", "io.korconut.reservationpractice.envi" })
@Import({ DBConfig.class })
public class ApplicationConfig {

}
