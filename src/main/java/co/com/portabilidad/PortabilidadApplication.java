package co.com.portabilidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"co.com.portabilidad.persona"})
public class PortabilidadApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortabilidadApplication.class, args);
    }

}
