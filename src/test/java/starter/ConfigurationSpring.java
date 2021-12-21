package starter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("starter")
@PropertySource("classpath:configuration.properties")
public class ConfigurationSpring {

}
