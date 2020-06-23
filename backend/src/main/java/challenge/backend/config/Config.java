package challenge.backend.config;

import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

   @Bean //setTimezone configuration, if isnt there, then the date delays by one day
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}