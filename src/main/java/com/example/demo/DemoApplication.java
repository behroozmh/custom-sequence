package com.example.demo;

import com.example.demo.config.Dashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    @Autowired
    private Dashboard dashboard;

    @GetMapping("/me")
    public ResponseEntity getMe() {
        return ResponseEntity.ok(dashboard.getSeqStart());
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}
