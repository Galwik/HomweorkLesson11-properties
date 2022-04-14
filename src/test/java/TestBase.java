import configuration.BrowserEnvironment;
import configuration.EnvironmentProperty;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {
    private static Logger logger = LoggerFactory.getLogger("TestBase.class");
    protected static WebDriver driver;
    private static BrowserEnvironment browserEnvironment;
    private static EnvironmentProperty environmentProperty;


    @BeforeAll
    static void beforeAll() {
        environmentProperty = EnvironmentProperty.getInstance();
        browserEnvironment = new BrowserEnvironment();
        driver = browserEnvironment.getDriver();
//        WebDriverManager.chromedriver().setup();
//        logger.info(">>>DRIVER INITIATED PROPERLY");
    }

    @AfterAll
    static void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        logger.info(">>>DRIVER CLOSED PROPERLY");
    }

}