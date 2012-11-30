package org.ale.thot.selenium.pages;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;
import org.openqa.selenium.WebDriver;

public class StaticSessions extends AbstractPage {

    public StaticSessions(Selenium selenium, ConditionRunner conditionRunner) {
        super(selenium, conditionRunner);
    }

	public void open() {
        open("/staticSessions/");
    }

}
