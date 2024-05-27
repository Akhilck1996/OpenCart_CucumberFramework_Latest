package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features= {".//Features//LogintoOpenCart.feature"},
		//features= {".//Features/LoginDDT_UsingExcelfile.feature"},
		//features= {".//Features/AccountRegistration.feature"},
		features= {".//Features/AccountRegistration.feature",".//Features//LogintoOpenCart.feature",".//Features/LoginDDT_UsingExcelfile.feature"},
		//features= {"@target/rerun.txt"},  //suppose if u want to execute only failed TestCases then u can enable this
		glue="stepDefinations",
		plugin= {
				"pretty", "html:reports/myreport.html", //u can give any format like pdf , excel
				"rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		dryRun=false,   // checks mapping between scenario steps and step definition methods
		monochrome=true,  //// to avoid junk characters in output
		publish=true  // to publish report in cucumber server
		//tags="@sanity"  // this will execute scenarios tagged with @sanity
		//tags="@regression"
		//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression
		//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
		//tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
		
		)
public class TestRunner {

}
