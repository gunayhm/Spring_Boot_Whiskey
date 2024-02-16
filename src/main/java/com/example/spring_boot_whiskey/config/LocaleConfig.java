package com.example.spring_boot_whiskey.config;

import java.util.Arrays;
import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class LocaleConfig {

    private static final Locale AZ = new Locale("az");
    private static final Locale EN = new Locale("en");
    private static final Locale RU = new Locale("ru");

    @Bean
    public LocaleResolver localeResolver() {
        var localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(EN);
        localeResolver.setSupportedLocales(Arrays.asList(AZ, EN, RU));
        return localeResolver;
    }

}
