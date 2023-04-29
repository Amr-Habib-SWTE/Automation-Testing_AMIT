package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (features = "src/main/resources/features",
                glue = {"org.example.stepDefs"},
                tags = "@smoke",
                plugin = {
                        "pretty",
                        "html:target/cucumber-reports.html",
                        "json:target/json-reports/cucumber.json",
                        "junit:target/cukes.xml/cucumber.xml",
                        "rerun:target/rerun.txt"
                }
        )


public class Runner extends AbstractTestNGCucumberTests{
        }
