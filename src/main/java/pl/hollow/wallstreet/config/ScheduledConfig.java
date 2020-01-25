package pl.hollow.wallstreet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan("pl.hollow.wallstreet.rate")
public class ScheduledConfig {
}
