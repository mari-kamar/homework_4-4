package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;


public class BaseHooks {
    protected static WebDriver driver;
    private WebDriverFactory factory = new WebDriverFactory();
    public Logger logger = LogManager.getLogger(BaseHooks.class);
    String browser = System.getProperty("browser");
    String options = System.getProperty("options");
    public String myLogin = System.getProperty("myEmail");
    public String myPass = System.getProperty("myPassword");


    @BeforeTest
    public void setup() {
        if (options == null) {
            driver = factory.createDriver(browser);
        } else {
            driver = factory.createDriver(browser, options);
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @AfterTest
    public void closedown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }


}
