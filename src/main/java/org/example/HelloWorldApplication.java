package org.example;

import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.health.TemplateHealthCheck;
import org.example.resources.ContactResources;
import org.example.resources.HelloWorldResources;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldApplication.class);
    public static void main(final String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "HelloWorld";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run( final HelloWorldConfiguration configuration,
                     final Environment environment) throws Exception {
        LOGGER.info("Method HelloWorldApplication#run called");
        System.out.println("Hello World");
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataStoreFactory(),"mysql");
        environment.jersey().register(new ContactResources(jdbi));

    }

}
