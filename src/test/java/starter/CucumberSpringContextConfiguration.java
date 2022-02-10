package starter;

import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {ConfigurationSpring.class, StartApplication.class}, loader = SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration {
}
