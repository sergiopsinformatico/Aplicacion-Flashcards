package test.java.aplicacionflashcards.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;

@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/java/aplicacionflashcards/features",glue="test/java/aplicacionflashcards/stepDefinitions",
					 format= {"pretty","html:src/test/java/aplicacionflashcards/resultTest/Sprint5"})

	public class TestRunner {}