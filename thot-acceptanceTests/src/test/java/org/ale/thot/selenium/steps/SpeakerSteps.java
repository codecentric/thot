package org.ale.thot.selenium.steps;

import static junit.framework.Assert.assertEquals;

import org.ale.thot.selenium.pages.Pages;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class SpeakerSteps {

	private Pages pages;

	public SpeakerSteps(Pages pages) {
		this.pages = pages;
	}

	@Given("a user is on the speaker site")
	public void givenAUserIsOnTheSpeakerSite() {
		pages.timeline().open();
	}

}
