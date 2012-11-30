package org.ale.thot.selenium.pages;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class Pages {

    private StaticSessions staticSessions;
    private Timeline timeline;
    
	private Selenium selenium;
	private ConditionRunner conditionRunner;

	public Pages(Selenium selenium,ConditionRunner conditionRunner) {
		this.selenium = selenium;
		this.conditionRunner = conditionRunner;
	}

	public Timeline timeline() {
        if (timeline == null) {
            timeline = new Timeline(selenium,conditionRunner);
        }
        return timeline;
    }

	
	public StaticSessions staticSessions() {
        if (staticSessions == null) {
            staticSessions = new StaticSessions(selenium,conditionRunner);
        }
        return staticSessions;
    }

}
