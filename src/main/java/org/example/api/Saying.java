package org.example.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Saying {

    private long id;
    private String content;

    public Saying(){

    }

    public Saying(long id, String content){
        this.content = content;
        this.id = id;
    }
    @JsonProperty
    public long getId() {
        return id;
    }
    @JsonProperty
    public String getContent() {
        return content;
    }

}
