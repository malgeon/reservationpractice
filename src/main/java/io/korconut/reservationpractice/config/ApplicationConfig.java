package io.korconut.reservationpractice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.korconut.reservationpractice.config.DBConfig;
import io.korconut.reservationpractice.config.EnviConfig;

@Configuration
@Import({ DBConfig.class, EnviConfig.class })
public class ApplicationConfig {

}
