package org.ale.thot.selenium.steps;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

import org.ale.thot.selenium.pages.Pages;
import org.ale.thot.selenium.pages.Speaker;
import org.ale.thot.selenium.pages.Speakers;
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
		Speakers speakersPage = pages.speakers();
		speakersPage.open();
		assertEquals("Speakers", speakersPage.getHeadline());

		Speaker speakerPage = speakersPage.clickAddSpeakerButton();
		assertEquals("Speaker", speakerPage.getHeadline());
	}

}
