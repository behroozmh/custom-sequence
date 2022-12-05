package ir.behi.seqtest;

import ir.behi.seqtest.config.Dashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SeqApplication {

    @Autowired
    private Dashboard dashboard;

    @GetMapping("/me")
    public ResponseEntity getMe() {
        return ResponseEntity.ok(dashboard.getSeqStart());
    }

    public static void main(String[] args) {
        SpringApplication.run(SeqApplication.class, args);
    }


}
