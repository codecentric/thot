package org.ale.thot.selenium.pages;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class SpeakersPage extends AbstractPage {

	public SpeakersPage(Selenium selenium, ConditionRunner conditionRunner) {
		super(selenium, conditionRunner);
	}

	public void open() {
		open("/speakers");
	}

	public SpeakerPage clickAddSpeakerButton() {
		click("id=addSpeaker");
		return speakerPage();
	}

	private SpeakerPage speakerPage() {
		return new SpeakerPage(selenium, conditionRunner);
	}
	
	protected String getExpectedHeadline() {
		return "Speakers";
	}

	public SpeakerPage clickSpeaker(String foreName, String lastName) {
		click("id=speaker" + foreName + lastName);
		return speakerPage();
	}

}
