package ir.behi.seqtest.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

@Configuration
@PropertySource(value = "classpath:me.properties")
@Order(Ordered.HIGHEST_PRECEDENCE)
@Getter
@Setter
public class Dashboard {
    public Dashboard(Environment env) {
        try {
            String configPath = env.getProperty("config.path");
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(configPath));
            HashMap<String, String> keyMap = new HashMap();
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line = br.readLine();
            while (line != null) {
                String[] keys = line.split("=");
                keyMap.put(keys[0], keys[1]);
                line = br.readLine();
            }
            this.seqGenStart=keyMap.get("seq.start");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Value("${seq.start}")
    private String seqStart;
    @Value("${config.path}")
    private String configPath;
    //this for loading from outer project
    private String seqGenStart;

}
