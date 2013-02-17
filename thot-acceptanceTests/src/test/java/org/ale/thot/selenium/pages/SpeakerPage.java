package org.ale.thot.selenium.pages;

import static junit.framework.Assert.assertEquals;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class SpeakerPage extends AbstractPage {

	public SpeakerPage(Selenium selenium, ConditionRunner conditionRunner) {
		super(selenium, conditionRunner);
	}

	public void fillField(String field, String value) {
		type("id=" + field, value);
	}

	public SpeakersPage clickSaveButtonExpectingSuccess() {
		click("id=saveSpeaker");
		return new SpeakersPage(selenium, conditionRunner);
	}
	
	protected String getExpectedHeadline() {
		return "Speaker";
	}

	public void assertFieldValue(String field, String expectedValue) {
		assertEquals("value of field " + field, expectedValue, value("id=" + field));
	}

}
