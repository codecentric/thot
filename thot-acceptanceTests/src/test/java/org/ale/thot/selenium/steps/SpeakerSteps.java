package org.ale.thot.selenium.steps;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

import org.ale.thot.selenium.pages.AbstractPage;
import org.ale.thot.selenium.pages.Pages;
import org.ale.thot.selenium.pages.SpeakerPage;
import org.ale.thot.selenium.pages.SpeakersPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class SpeakerSteps {

	private Pages pages;
	private SpeakerPage speakerPage;
	private SpeakersPage speakersPage;

	public SpeakerSteps(Pages pages) {
		this.pages = pages;
	}

	@Given("user is on the speaker creation page")
	public void userIsOnTheSpeakersPage() {
		SpeakersPage speakersPage = pages.speakers();
		speakersPage.open();
		speakersPage.assertExpectedTitle();

		speakerPage = speakersPage.clickAddSpeakerButton();
		speakerPage.assertExpectedTitle();
	}

	@Given("user adds forename '$foreName'")
	public void userAddsForename(String foreName) {
		speakerPage.fillField("foreName", foreName);
	}

	@Given("user adds last name '$lastName'")
	public void userAddsLastName(String lastName) {
		speakerPage.fillField("lastName", lastName);
	}

	@Given("user adds the bio '$bio'")
	public void userAddsTheBio(String bio) {
		speakerPage.fillField("bio", bio);
	}

	@When("user saves the speaker")
	public void userSavesTheSpeaker() {
		this.speakersPage = speakerPage.clickSaveButtonExpectingSuccess();
		speakersPage.assertExpectedTitle();
	}

	@Then("a speaker exists with forename '$foreName', last name '$lastName' and bio '$bio'")
	public void aSpeakerExistsWith(String foreName, String lastName, String bio) {
		speakersPage.open();
		speakersPage.assertExpectedTitle();

		speakerPage = speakersPage.clickSpeaker(foreName, lastName);
		speakerPage.assertExpectedTitle();
		speakerPage.assertFieldValue("foreName", foreName);
		speakerPage.assertFieldValue("lastName", lastName);
		speakerPage.assertFieldValue("bio", bio);
	}

	@Given("a user is on speakers site")
	@Pending
	public void givenAUserIsOnSpeakersSite() {
		// PENDING
	}

}
