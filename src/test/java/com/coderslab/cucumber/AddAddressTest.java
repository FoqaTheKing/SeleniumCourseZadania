package com.coderslab.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/duckduckgo/addAddress.feature", plugin = {"pretty", "html:report/AddAddressResult.html"})
public class AddAddressTest {
}
