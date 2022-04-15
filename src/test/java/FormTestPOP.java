import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.FormPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class FormTestPOP extends TestBase {

    @Test
    void fillForm() {
        FormPage formPage = new FormPage(driver);

        formPage.setFirstName(System.getProperty("firstName"));
        formPage.setLastName(System.getProperty("lastName"));
        formPage.setEmail(System.getProperty("email"));
        formPage.setRandomGender();
        formPage.setAge(System.getProperty("age"));
        formPage.setRandomYearsOfExperience();
        formPage.setProfessionToAutomationTester();
        formPage.setRandomContinent();
        formPage.setSwitchAndWaitSeleniumCommand(driver);
        formPage.uploadFile(System.getProperty("filePath"));
        formPage.signIn();

        assertThat("Incorrect text", driver.findElement(By.cssSelector("#validator-message"))
                .getText().equals(System.getProperty("formMessage")));
    }
}