package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import starter.ConfigurationSpring;
import starter.entities.NewTable;
import starter.repository.DsbLicenseRepository;

import java.util.List;

@ContextConfiguration(classes = ConfigurationSpring.class)
public class MyStepdefs {

    @Value("${host}")
    String host;

    @Value("${message}")
    String message;

    @Autowired
    DsbLicenseRepository dsbLicenseRepository;

    @Given("print message")
    public void printMessage() {
       Iterable<NewTable> data = dsbLicenseRepository.findAll();
        System.out.println(host + " " + message);

    }
}
