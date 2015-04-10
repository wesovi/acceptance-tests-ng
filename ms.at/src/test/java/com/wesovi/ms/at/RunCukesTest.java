package com.wesovi.ms.at;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,features="classpath:cucumber", glue={"com.wesovi.ms.at.steps"})
public class RunCukesTest {

}
