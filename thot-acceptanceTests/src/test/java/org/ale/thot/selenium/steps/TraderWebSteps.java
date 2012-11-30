package org.ale.thot.selenium.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.ale.thot.selenium.pages.Pages;

public class TraderWebSteps {
    private final Pages pages;

    public TraderWebSteps(Pages pages) {
        this.pages = pages;
    }

    @Given("user is on Home page")
    public void userIsOnHomePage(){        
        pages.staticSessions().open();
    }

    @When("user opens sessions today")
    public void userClicksOnFindSteps(){        
        pages.staticSessions().open();
    }

    @Then("sessions today is shown")
    public void findStepsPageIsShown(){

    }

}
