package org.ale.thot.selenium.pages;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class Pages {

    private final Selenium selenium;
    private final ConditionRunner conditionRunner;
    private StaticSessions staticSessions;
    private RunStory runStory;

    public Pages(Selenium selenium, ConditionRunner conditionRunner) {
        this.selenium = selenium;
        this.conditionRunner = conditionRunner;
    }

    public StaticSessions staticSessions() {
        if (staticSessions == null) {
            staticSessions = new StaticSessions(selenium, conditionRunner);
        }
        return staticSessions;
    }


    public RunStory runStory() {
        if (runStory == null) {
            runStory = new RunStory(selenium, conditionRunner);
        }
        return runStory;
    }

}
