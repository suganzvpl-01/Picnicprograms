package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/tour.feature",
glue={"com.stepdefinition"},
dryRun=true,
monochrome = true,
tags="@scenarioTag")

public class TestRunner {

}
