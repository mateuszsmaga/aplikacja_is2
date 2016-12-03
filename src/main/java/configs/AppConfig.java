package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Testy jednostokowe paczki beans
@Configuration
@ComponentScan(basePackages = {"beans"})
public class AppConfig {
	
}