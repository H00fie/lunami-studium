package bm.app.lunamistudium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class LunamiStudiumApplication {

    public static void main(String[] args) {
        SpringApplication.run(LunamiStudiumApplication.class, args);
    }

}
