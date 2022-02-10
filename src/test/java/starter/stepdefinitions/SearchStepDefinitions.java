package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import starter.ConfigurationSpring;
import starter.search.LookForInformation;
import starter.search.WikipediaArticle;

@ContextConfiguration(classes = ConfigurationSpring.class)
public class SearchStepDefinitions {

    @Value("${host}")
    String host;

    @Given("{actor} is researching things on the internet")
    public void researchingThings(Actor actor) {
        System.out.println(host);
        actor.whoCan(BrowseTheWeb.with(new ChromeDriver()));
        Serenity.getDriver().manage().window().maximize();
        Serenity.getDriver().get(host);
    }

    @When("{actor} looks up {string}")
    public void searchesFor(Actor actor, String term) {
        actor.attemptsTo(
                LookForInformation.about(term)
        );
    }

    @Then("{actor} should see information about {string}")
    public void should_see_information_about(Actor actor, String term) {
        actor.attemptsTo(
               Ensure.that(WikipediaArticle.HEADING).hasText(term)
        );
    }
}
