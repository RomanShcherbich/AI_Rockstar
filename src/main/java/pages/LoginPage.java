package pages;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

  public LoginPage(WebDriver driver) {
    super.driver = driver;
//    super.wait = new WebDriverWait(driver, 2);
  }

  private static By byLogo = new By.ByXPath("//div[@class='logo-w']//img[@src='img/logo-big.png']");
  private static By byPageTitle = new By.ByXPath("//h4");

  private static By byUsernameIcon = new By.ByXPath("//div[contains(@class,'icon-user-male-circle')]");
  private static By byUsernameTitle = new By.ByXPath("//div[./*[@id='username']]/label");
  private static By byUsernameField = new By.ById("username");

  private static By byPasswordTitle = new By.ByXPath("//div[./*[@id='password']]/label");
  private static By byPasswordIcon = new By.ByXPath("//div[contains(@class,'icon-fingerprint')]");
  private static By byPasswordField = new By.ByXPath("//input[@id='password']");
//  private static By byPasswordField = new By.ById("password");

  private static By byLogInButton = new By.ByXPath("//button[@id='log-in']");
  //  private static By byLogInButton = new By.ByXPath("//button[@id='log-in' and text()='Log In']");
  private static By byRememberMeCheckbox = new By.ByXPath("//label[normalize-space(text())='Remember Me']/input");

  private static By byTwitterLink = new By.ByXPath("//img[@src='img/social-icons/twitter.png']");
  private static By byFacebookLink = new By.ByXPath("//img[@src='img/social-icons/facebook.png']");
  private static By byLinkedinLink = new By.ByXPath("//img[@src='img/social-icons/linkedin.png']");

  private static By byLoginPage = new By.ByXPath("//div[@class='auth-box-w']");
  private static By byLogoArea = new By.ByXPath("//div[@class='logo-w']");
  private static By byHeaderArea = new By.ByXPath("//h4[@class='auth-header']");
  private static By byAlertArea = new By.ByXPath("//h4/following-sibling::div[last()]");
  private static By byLoginArea = new By.ByXPath("//form");

  public SecuredPage clickLogin(String username, String password, String alert) {
    insertText(byUsernameField, username);
    insertText(byPasswordField, password);
    clickButtonLog(byLogInButton);

    if (username != null && password != null) {
      return new SecuredPage(driver);
    } else {
      assertNoLoginAlert(alert);
      return null;
    }
  }

  private void assertNoLoginAlert(String alertExpected) {
    assertTextField("invalid alert text", alertExpected, getElementText(byAlertArea));
  }
}
