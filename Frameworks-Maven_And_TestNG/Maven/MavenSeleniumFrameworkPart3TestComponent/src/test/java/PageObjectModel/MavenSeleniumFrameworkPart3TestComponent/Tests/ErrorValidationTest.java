
package PageObjectModel.MavenSeleniumFrameworkPart3TestComponent.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import MavenSeleniumFrameworkPart3TestComponent.MavenFrameworkDesignPageObjectModel.LandingPage;
import PageObjectModel.MavenSeleniumFrameworkPart3TestComponent.TestComponent.BaseTest;

public class ErrorValidationTest extends BaseTest {

    @Test(groups = {"ErrorHandling"}, retryAnalyzer = RetryAnalyzer.class)
    public void LoginErrorValidation() throws IOException, InterruptedException {
        LandingPage landingPage = new LandingPage(driver); // Assuming you have a driver instance in BaseTest
        landingPage.loginApplication("anshika@gmail.com", "Acteam@13");
        boolean errorMessageDisplayed = landingPage.getErrorMessage(); // Assuming this method returns a boolean
        Assert.assertTrue(errorMessageDisplayed, "Incorrect email or Password");
    }
}
