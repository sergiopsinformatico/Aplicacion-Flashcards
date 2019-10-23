package test.java.aplicacionFlashcards.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;

@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/java/aplicacionFlashcards/features",glue="test/java/aplicacionFlashcards/stepDefinitions",
					 format= {"pretty","html:src/test/java/aplicacionFlashcards/resultTest/Sprint2"})

	public class TestRunner {}