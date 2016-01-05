package com.madadata.playground.app;

import com.madadata.playground.configuration.HelloWorldConfiguration;
import com.madadata.playground.health.TemplateHealthCheck;
import com.madadata.playground.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * Created by jiayu on 1/5/16.
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "马达数据的「你好世界」程序";
    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName());
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
