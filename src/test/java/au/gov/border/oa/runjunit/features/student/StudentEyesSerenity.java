package au.gov.border.oa.runjunit.features.student;

import au.gov.border.oa.steps.LoginSteps;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentEyesSerenity {
    @Managed
    WebDriver driver;

    @Steps
    LoginSteps loginSteps;

    @Rule
    public TestName name = new TestName();

    Eyes eyes;

    @Before
    public void before() {
        eyes = new Eyes();
        eyes.setApiKey("RZ8gdnlt105ewIL3OpvGARWpWlLNDdHwt98HkZmnQtunZU110");
        eyes.open(((WebDriverFacade) driver).getProxiedDriver(), "Serenity Eyes", name.getMethodName(), new RectangleSize(800, 600));
    }

    @After
    public void after() {
        eyes.abortIfNotClosed();
    }

    @Test
    public void viewStudyVisaDetailsSerenityJUnitIE() throws Exception {
        loginSteps.openVisaFinder();
        eyes.checkWindow("Visa Finder window");
        loginSteps.selectStudyVisaOption();
        eyes.checkWindow("Student 500 window");
        loginSteps.selectStudyFullTime();
        loginSteps.viewVisaDetails();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("$('p.warning-text').removeClass('warning-text');");
        eyes.checkWindow("Student 500 Details window");
        eyes.close();
    }

}
