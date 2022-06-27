package com.coderslab.duckduckgo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/duckduckgo/text-search.feature", plugin = {"pretty", "html:report/result.html"})
public class SearchTest {
}
