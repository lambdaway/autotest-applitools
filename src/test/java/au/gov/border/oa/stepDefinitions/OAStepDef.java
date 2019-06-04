package au.gov.border.oa.stepDefinitions;

import au.gov.border.oa.steps.LoginSteps;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.JavascriptExecutor;

public class OAStepDef {
    private Scenario scenario;
    Eyes eyes;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        eyes = new Eyes();
        eyes.setApiKey("RZ8gdnlt105ewIL3OpvGARWpWlLNDdHwt98HkZmnQtunZU110");
        eyes.open(((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver(), "Serenity Eyes Cucumber", scenario.getName(), new RectangleSize(1000, 600));
    }

    @After
    public void after() {
        eyes.abortIfNotClosed();
    }

    @Steps
    LoginSteps loginSteps;

    @Given("^(?:.*) opens? Visa Finder page$")
    public void openOAHomePage() {
        loginSteps.openVisaFinder();
        eyes.checkWindow("Visa Finder window");
    }

    @And("^(?:.*) selects? Study visa option$")
    public void selectStudyVisaOption() throws Exception {
        loginSteps.selectStudyVisaOption();
        eyes.checkWindow("Student 500 window");
    }

    @When("^(?:.*) selects? Study Full Time$")
    public void selectStudyFullTime() throws Exception {
        loginSteps.selectStudyFullTime();
    }

    @Then("^(?:.*) could see visa details$")
    public void seeVisaDetails() throws Exception {
        loginSteps.viewVisaDetails();
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getWebdriverManager().getCurrentDriver();
        js.executeScript("$('p.warning-text').removeClass('warning-text');");
        eyes.checkWindow("Student 500 Details window");
        eyes.close();
    }

}
