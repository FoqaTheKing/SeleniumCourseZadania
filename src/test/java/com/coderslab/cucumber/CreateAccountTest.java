package com.coderslab.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/duckduckgo/ex_2.feature", plugin = {"pretty", "html:report/AddAccountResult.html"})
public class CreateAccountTest {
}
