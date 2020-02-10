package org.example.resources;


import com.codahale.metrics.annotation.Timed;
import org.example.api.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResources {
    private final String defaultName;
    private final String template;
    private final AtomicLong counter;

    public HelloWorldResources(String template,String defaultName){
        this.defaultName = defaultName;
        this.template = template;
        this.counter = new AtomicLong();

    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name){
           final String value = String.format(template, name.orElse(defaultName));
           return new Saying(counter.incrementAndGet(),value);
    }
}
