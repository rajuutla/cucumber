package cucumber.testrunners;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "features", 
					glue = {"cucumber.stepdef"}, monochrome = true)		
public class TestNGRunner extends AbstractTestNGCucumberTests {

      @Override
      @DataProvider
      public Object[][] scenarios() {
            return super.scenarios();
      }
}