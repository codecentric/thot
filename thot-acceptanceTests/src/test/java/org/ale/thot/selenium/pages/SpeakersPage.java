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
		return new SpeakerPage(selenium, conditionRunner);
	}
}
