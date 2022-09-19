package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:me.properties")
public class Dashboard {

    @Value("${seq.start}")
    private String seqStart;

    public String getSeqStart() {
        return seqStart;
    }

    public void setSeqStart(String seqStart) {
        this.seqStart = seqStart;
    }
}
