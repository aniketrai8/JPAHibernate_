package com.example.jpaassignment.config;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Value;



@Component
public class AppConfig {


    @Value("{app.name}")
    private String appName;

    @Value("{app.version}")
    private String appVersion;

    @Value("{app.author}")
    private String appAuthor;



    public String getAppName (){
        return appName;
    }


    public String getAppAuthor (){
        return appAuthor;
    }



}
