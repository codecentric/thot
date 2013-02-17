package org.ale.thot.selenium.pages;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class Speakers extends AbstractPage {

	public Speakers(Selenium selenium, ConditionRunner conditionRunner) {
		super(selenium, conditionRunner);
	}

	public void open() {
		open("/speakers");
	}

	public Speaker clickAddSpeakerButton() {
		click("id=addSpeaker");
		return new Speaker(selenium, conditionRunner);
	}
}
