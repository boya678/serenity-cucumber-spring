package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import starter.ConfigurationSpring;
import starter.repository.NewTableRepository;

@ContextConfiguration(classes = ConfigurationSpring.class)
public class MyStepdefs {

    @Value("${host}")
    String host;

    @Value("${message}")
    String message;

    @Autowired
    NewTableRepository dsbLicenseRepository;

    @Given("print message")
    public void printMessage() {
        dsbLicenseRepository.findAll();
        System.out.println(dsbLicenseRepository.findAll().iterator().next().toString());
        System.out.println(host + " " + message);
    }
}
