package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.BaseHooks;

public class AuthPage extends BaseHooks {

    private By email = By.xpath("//form[contains(@action,\"login\")]//input[@placeholder='Электронная почта']");
    private By password = By.xpath("//form[contains(@action,\"login\")]//input[@placeholder='Введите пароль']");
    private By enter = By.xpath("//form[contains(@action,\"login\")]//button[@type='submit']");

    public AuthPage login (String myEmail, String myPassword) {
        driver.findElement(email).sendKeys(myEmail);
        driver.findElement(password).sendKeys(myPassword);
        driver.findElement(password).sendKeys(Keys.ENTER);
        logger.info("Authorization in Otus");

        return new AuthPage();
    }

    public PersonalPage enter() {
        driver.findElement(enter).click();
        logger.info("Moving to Personal Page");

        return new PersonalPage();
    }
}
