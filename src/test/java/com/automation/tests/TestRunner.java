package com.automation.tests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
                features = "src/test/java/resources/features",
                glue = "com.automation.steps",
                plugin = {"pretty", "html:target/site/cucumber-pretty"})
public class TestRunner {
}
