package com.madadata.playground.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by jiayu on 1/5/16.
 */
public class Saying {

    private long id;

    @Length(max = 10)
    private String content;

    public Saying() {
        // for JSON creator
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
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
