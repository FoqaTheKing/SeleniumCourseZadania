package com.coderslab.prestashopTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/prestashopFeatures/zadanie_1_prestashop.feature", plugin = "pretty")
public class AddAddressTest {
}
