package pages.applitools;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.applitools.EyesSecuredPage;

public class EyesLoginPage extends EyesAbstractPage {

    public EyesLoginPage(Eyes eyes, WebDriver driver) {
        super(eyes, driver);
    }

    private static By logingArea = new By.ByXPath("//div[@class='all-wrapper menu-side with-pattern']");
    private static By byLogInButton = new By.ByXPath("//button[@id='log-in']");
    private static By byAlertArea = new By.ByXPath("//h4/following-sibling::div[last()]");
    private static By byUsernameField = new By.ById("username");
    private static By byPasswordField = new By.ByXPath("//input[@id='password']");

    public void checkLoginPage(){
        checkWindow("Login page");
    }

    public void clickLoginAlertCheck() {
        clickButtonEyesCheck(byLogInButton,byAlertArea);
    }

    public void checkLoginArea(){
        checkRegion(logingArea);
    }

    public EyesSecuredPage clickLogin(String username, String password, String alert) {
        insertText(byUsernameField, username);
        insertText(byPasswordField, password);
        clickButtonEyesCheck(byLogInButton, alert);
        return new EyesSecuredPage(eyes,driver);
    }

    public EyesSecuredPage clickLoginNoCheck(String username, String password) {
        insertText(byUsernameField, username);
        insertText(byPasswordField, password);
        clickButtonLog(byLogInButton);
        return new EyesSecuredPage(eyes,driver);
    }
}
