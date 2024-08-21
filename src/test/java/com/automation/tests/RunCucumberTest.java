package com.automation.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                features = "src/test/java/resources/features",
                glue = "steps",
                plugin = {"pretty", "html:target/site/cucumber-pretty",
                        "json:target/cucumber.json"})
public class RunCucumberTest {
}
