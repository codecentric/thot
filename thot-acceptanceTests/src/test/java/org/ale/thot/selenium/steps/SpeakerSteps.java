package org.ale.thot.selenium.steps;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

import org.ale.thot.selenium.pages.AbstractPage;
import org.ale.thot.selenium.pages.Pages;
import org.ale.thot.selenium.pages.SpeakerPage;
import org.ale.thot.selenium.pages.SpeakersPage;
import org.jbehave.core.annotations.BeforeScenario;
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
	public void userIsOnTheSpeakerPage() {
		userIsOnSpeakersSite();

		speakerPage = speakersPage.clickAddSpeakerButton();
		speakerPage.assertExpectedTitle();
	}

	@When("user sets forename '$foreName'")
	public void userAddsForename(String foreName) {
		speakerPage.fillField("foreName", foreName);
	}

	@When("user sets last name '$lastName'")
	public void userAddsLastName(String lastName) {
		speakerPage.fillField("lastName", lastName);
	}

	@When("user sets the bio '$bio'")
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
		aSpeakerExistsOnSpeakersPage(foreName, lastName);
		speakerPage.assertExpectedTitle();
		speakerPage.assertFieldValue("foreName", foreName);
		speakerPage.assertFieldValue("lastName", lastName);
		speakerPage.assertFieldValue("bio", bio);
	}

	private void aSpeakerExistsOnSpeakersPage(String foreName, String lastName) {
		speakersPage.open();
		speakersPage.assertExpectedTitle();

		userSelectsSpeakerWith(foreName, lastName);
	}

	@Given("user is on speakers site")
	public void userIsOnSpeakersSite() {
		speakersPage = pages.speakers();
		speakersPage.open();
		speakersPage.assertExpectedTitle();
	}

	@Given("user selects speaker with forename '$foreName' and with last name '$lastName'")
	public void userSelectsSpeakerWith(String foreName, String lastName) {
		assertTrue(speakersPage.speakerExists(foreName, lastName));
		speakerPage = speakersPage.clickSpeaker(foreName, lastName);
	}

	@Then("a speaker with forename '$foreName' and with last name '$lastName' does not exist")
	public void aSpeakerDoesNotExistsWith(String foreName, String lastName) {
		assertFalse("speaker should not exist", speakersPage.speakerExists(foreName, lastName));
	}
}
