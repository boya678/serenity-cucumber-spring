package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import starter.ConfigurationSpring;
import starter.navigation.NavigateTo;
import starter.search.LookForInformation;
import starter.search.WikipediaArticle;

@ContextConfiguration(classes = ConfigurationSpring.class)
public class SearchStepDefinitions {

    @Value("${host}")
    String host;

    @Given("{actor} is researching things on the internet")
    public void researchingThings(Actor actor) {
        System.out.println(host);
        actor.wasAbleTo(NavigateTo.theWikipediaHomePage());
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
               // Ensure.that(WikipediaArticle.HEADING).hasText(term)
        );
    }
}
