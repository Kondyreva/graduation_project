package com.githab.kondyreva.graduation;

import com.github.kondyreva.graduation.GraduationProjectClientApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializerServer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GraduationProjectServerApplication.class);
    }

}