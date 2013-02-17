package org.ale.thot.selenium.pages;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class Pages {

    private StaticSessions staticSessions;
    private Timeline timeline;
    
	private Selenium selenium;
	private ConditionRunner conditionRunner;
	private Speakers speakers;

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
	
	public Speakers speakers() {
		if (speakers == null) {
			speakers = new Speakers(selenium, conditionRunner);
		}
		return speakers;
	}

}
