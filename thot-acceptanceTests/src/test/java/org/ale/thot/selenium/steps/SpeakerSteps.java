package org.ale.thot.selenium.steps;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

import org.ale.thot.selenium.pages.Pages;
import org.ale.thot.selenium.pages.SpeakerPage;
import org.ale.thot.selenium.pages.SpeakersPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class SpeakerSteps {

	private Pages pages;

	public SpeakerSteps(Pages pages) {
		this.pages = pages;
	}

	@Given("user is on the speaker creation page")
	public void givenAUserIsOnTheSpeakersPage() {
		SpeakersPage speakersPage = pages.speakers();
		speakersPage.open();
		assertEquals("Speakers", speakersPage.getHeadline());

		SpeakerPage speakerPage = speakersPage.clickAddSpeakerButton();
		assertEquals("Speaker", speakerPage.getHeadline());
	}
	
	@Given("user adds forename '$foreName'")
	public void givenUserAddsForenameDavid(String foreName) {
	  fail();
	}


}
