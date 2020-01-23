package monoliths.catalogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CatalogApplication {

    public static final String PROPS_CONFIG_NAME = "spring.config.name: application, catalogs";

    public static void main(String[] args) {
        SpringApplication  application = new SpringApplicationBuilder()
                .properties(PROPS_CONFIG_NAME)
                .sources(CatalogApplication.class)
                .build();

        application.run(args);
    }
    
}