import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.FormPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class FormTestPOP extends TestBase {

    @Test
    void fillForm() {
        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Kamil");
        formPage.setFirstName(System.getProperty("firstName"));
        formPage.setLastName("Gawlicki");
        formPage.setEmail("kgawlicki@sii.pl");
        formPage.setRandomGender();
        formPage.setAge("23");
        formPage.setRandomYearsOfExperience();
        formPage.setProfessionToAutomationTester();
        formPage.setRandomContinent();
        formPage.setSwitchAndWaitSeleniumCommand(driver);
        formPage.uploadFile("src/main/resources/fileToUpload");
        formPage.signIn();

        assertThat("Incorrect text", driver.findElement(By.cssSelector("#validator-message"))
                .getText().equals("Form send with success"));
    }
}