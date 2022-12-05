package ir.behi.seqtest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
@PropertySource("classpath:me.properties")
@Order(Ordered.HIGHEST_PRECEDENCE)
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
