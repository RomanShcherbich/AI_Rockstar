package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {

  public LoginPage(WebDriver driver) {
    super.driver = driver;
  }

  private static By byLogo = new By.ByXPath("//div[@class='logo-w']//img[@src='img/logo-big.png']");
  private static By byPageTitle = new By.ByXPath("//h4");

  private static By byUsernameIcon = new By.ByXPath("//div[contains(@class,'icon-user-male-circle')]");
  private static By byUsernameTitle = new By.ByXPath("//div[./*[@id='username']]/label");
  private static By byUsernameField = new By.ById("username");

  private static By byPasswordTitle = new By.ByXPath("//div[./*[@id='password']]/label");
  private static By byPasswordIcon = new By.ByXPath("//div[contains(@class,'icon-fingerprint')]");
  private static By byPasswordField = new By.ByXPath("//input[@id='password']");

  private static By byLogInButton = new By.ByXPath("//button[@id='log-in']");
  private static By byRememberMeCheckbox = new By.ByXPath("//input[@type='checkbox']");
  private static By byRememberMeText = new By.ByXPath("//input[@type='checkbox']/parent::label");

  private static By byTwitterLink = new By.ByXPath("//img[@src='img/social-icons/twitter.png']");
  private static By byFacebookLink = new By.ByXPath("//img[@src='img/social-icons/facebook.png']");
  private static By byLinkedinLink = new By.ByXPath("//img[@src='img/social-icons/linkedin.png']");

  private static By byAlertArea = new By.ByXPath("//h4/following-sibling::div[last()]");

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

  public void logoIsDisplayed() {
    assertDisplayingElement(byLogo);
  }

  public void pageTitleHasText(String text) {
    assertElementText(text, byPageTitle);
  }

  public void usernameIconIsDisplayed() {
    assertDisplayingElement(byUsernameIcon);
  }

  public void usernameTitleHasText(String text) {
    assertElementText(text, byUsernameTitle);
  }

  public void usernameFieldHasText(String text) {
    assertElementAttributeText(text,"placeholder", byUsernameField);
  }

  public void passwordIconIsDisplayed() {
    assertDisplayingElement(byPasswordIcon);
  }

  public void passwordTitleHasText(String text) {
    assertElementText(text, byPasswordTitle);
  }

  public void passwordFieldHasText(String text) {
    assertElementAttributeText(text,"placeholder", byPasswordField);
  }

  public void buttonLoginHasText(String text) {
    assertElementText(text, byLogInButton);
  }

  public void alertIsNotDisplayed() {
    assertNotDisplayingElement(byAlertArea);
  }

  public void rememberMeCheckboxIsDisplayed() {
    assertDisplayingElement(byRememberMeCheckbox);
  }

  public void rememberMeCheckboxHasText(String text) {
    assertElementText(text, byRememberMeText);
  }

  public void twitterIsDisplayed() {
    assertDisplayingElement(byTwitterLink);
  }

  public void facebookIsDisplayed() {
    assertDisplayingElement(byFacebookLink);
  }

  public void linkedinIsDisplayed() {
    assertDisplayingElement(byLinkedinLink);
  }

  private void assertNoLoginAlert(String alertExpected) {
    assertTextField("invalid alert text", alertExpected, getElementText(byAlertArea));
  }
}
