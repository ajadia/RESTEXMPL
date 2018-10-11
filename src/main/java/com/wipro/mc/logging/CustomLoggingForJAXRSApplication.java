package com.wipro.mc.logging;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
 
public class CustomLoggingForJAXRSApplication extends ResourceConfig
{
    public CustomLoggingForJAXRSApplication()
    {
        packages("com.wipro.*");
        register(JacksonFeature.class);
 
        register(CustomLoggingFilter.class);
    }
}

