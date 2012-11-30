package org.ale.thot.selenium;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

import java.util.List;

import org.ale.thot.selenium.pages.Pages;
import org.ale.thot.selenium.steps.WebApplicationSteps;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.util.StringUtils;

import com.thoughtworks.selenium.condition.ConditionRunner;
import com.thoughtworks.selenium.condition.DefaultConditionRunner;

public class WebApplicationTest extends JUnitStories {

	// default 
	private static String serverUrl = "http://107.20.22.51/thot";
	private static final String SYSTEM_PROPERTY = "server.url";
	
	private static WebDriverBackedSelenium selenium;
	private ConditionRunner conditionRunner = new DefaultConditionRunner(selenium);
    private Pages pages = new Pages(selenium,conditionRunner);

	@BeforeClass
	public static void init(){
		WebDriver webDriver = new FirefoxDriver();
		if( StringUtils.hasText( System.getProperty( SYSTEM_PROPERTY) ) ) {
			serverUrl = System.getProperty( SYSTEM_PROPERTY); 
		}
		selenium = new WebDriverBackedSelenium(webDriver, serverUrl);
		System.out.println(webDriver.getTitle());
	}

	@AfterClass
	public static void destroy(){
		selenium.getWrappedDriver().quit();
	}

	@Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        return new MostUsefulConfiguration()
            .useStoryLoader(new LoadFromClasspath(embeddableClass))
            .useStoryReporterBuilder(new StoryReporterBuilder()
                .withCodeLocation(codeLocationFromClass(embeddableClass))
                .withDefaultFormats()
                .withFormats(CONSOLE, TXT, HTML, XML));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new WebApplicationSteps(pages));
    }
    
    @Override
    protected List<String> storyPaths() {
        return new StoryFinder()
                .findPaths(codeLocationFromClass(this.getClass()).getFile(), asList("**/*.story"), null);
    }

}
