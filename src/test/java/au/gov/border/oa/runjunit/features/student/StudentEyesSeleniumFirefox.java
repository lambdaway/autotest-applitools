package au.gov.border.oa.runjunit.features.student;

import au.gov.border.oa.steps.LoginSteps;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import net.thucydides.core.annotations.Steps;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentEyesSeleniumFirefox {
    WebDriver driverEyes;

    @Steps
    LoginSteps loginSteps = new LoginSteps();

    @Rule
    public TestName name = new TestName();

    Eyes eyes;

    @Before
    public void before() {
        WebDriver driver = new FirefoxDriver();

        eyes = new Eyes();
        eyes.setApiKey("RZ8gdnlt105ewIL3OpvGARWpWlLNDdHwt98HkZmnQtunZU110");
        driverEyes = eyes.open(driver, "Serenity Eyes", name.getMethodName(), new RectangleSize(1000, 800));

    }

    @After
    public void after() {
        eyes.abortIfNotClosed();
        driverEyes.quit();
    }

    @Test
    public void viewStudyVisaDetailsSeleniumFirefox() throws Exception {
        loginSteps.setDriver(driverEyes);
        loginSteps.openVisaFinder();
        eyes.checkWindow("Visa Finder window");
        loginSteps.selectStudyVisaOption();
        eyes.checkWindow("Student 500 window");
        loginSteps.selectStudyFullTime();
        loginSteps.viewVisaDetails();
//        JavascriptExecutor js = (JavascriptExecutor) driverEyes;
//        js.executeScript("$('p.warning-text').removeClass('warning-text');");
        eyes.checkWindow("Student 500 Details window");
        eyes.close();
        driverEyes.quit();
    }

    @Test
    public void viewPDFSeleniumFirefox() {
        String pdfFile = "file:///" + System.getProperty("user.dir") + "\\src\\test\\resources\\pdf\\AppliTools POC - Baseline.pdf";
//        pdfFile = "file:///" + System.getProperty("user.dir") + "\\src\\test\\resources\\pdf\\AppliTools POC - Incorrect.pdf";
        driverEyes.get(pdfFile.replace("\\", "/"));
        eyes.checkWindow("AppliTools POC Result Table");
        eyes.close();
        driverEyes.quit();
    }
}
