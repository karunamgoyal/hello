package org.example;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import javax.validation.constraints.Max;
import org.glassfish.jersey.server.JSONP;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.NotEmpty;


public class HelloWorldConfiguration extends Configuration {
    // TODO: implement service configuration
    @JsonProperty
    @NotEmpty
    private String message;

    @JsonProperty
    private String additionalMessage = "This is optional";

    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty
    public DataSourceFactory getDataStoreFactory() {
        return database;
    }

    @JsonProperty
    @Max(10)
    private int messageRepetition;


    public String getAdditionalMessage()
    {
        return additionalMessage;
    }

    //@JsonProperty
    public void setMessage(String message) {
        this.message=message;
    }
    //@JsonProperty
    public int getMessageRepetition()
    {
        return messageRepetition;
    }
    //@JsonProperty
    public String getMessage()
    {
        return message;
    }
    //@JsonProperty
    public void setMessageRepetition(int messageRepetition)
    {
        this.messageRepetition = messageRepetition;
    }
}
