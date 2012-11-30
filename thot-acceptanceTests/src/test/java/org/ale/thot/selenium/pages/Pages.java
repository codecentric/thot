package org.ale.thot.selenium.pages;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;
import org.openqa.selenium.WebDriver;

public class Pages {

    private StaticSessions staticSessions;

	private Selenium selenium;
	private ConditionRunner conditionRunner;

	public Pages(Selenium selenium,ConditionRunner conditionRunner) {
		this.selenium = selenium;
		this.conditionRunner = conditionRunner;
	}

	public StaticSessions staticSessions() {
        if (staticSessions == null) {
            staticSessions = new StaticSessions(selenium,conditionRunner);
        }
        return staticSessions;
    }

}
