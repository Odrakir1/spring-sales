package com.odrakir1;

import com.odrakir1.annotations.Development;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Development
public class WebConfiguration {

    @Bean(name = "applicationName")
    public String applicationName(){
        return "Sales System";
    }
}
