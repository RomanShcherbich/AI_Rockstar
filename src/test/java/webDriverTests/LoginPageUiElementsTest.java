package webDriverTests;

import baseTests.BaseTests;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.LoginPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginPageUiElementsTest extends BaseTests {

  public LoginPage loginPage() {
    return new LoginPage(driver);
  }

  @Test
  public void logoIsDisplayed() {
    loginPage().logoIsDisplayed();
  }

  @Test
  public void pageTitleHasText() {
    loginPage().pageTitleHasText("Login Form");
  }

  /**
   * Remark.
   *
  @Test
  public void usernameIconIsDisplayed() {
    loginPage().usernameIconIsDisplayed();
  }
   */
  @Test
  public void usernameTitleHasText() {
    loginPage().usernameTitleHasText("Username");
  }

  @Test
  public void usernameFieldHasText() {
    loginPage().usernameFieldHasText("Enter your username");
  }
/**
 * Remark.
 *
 @Test
  public void passwordIconIsDisplayed() {
    loginPage().passwordIconIsDisplayed();
  }
*/
  @Test
  public void passwordTitleHasText() {
    loginPage().passwordTitleHasText("Password");
  }

  @Test
  public void passwordFieldHasText() {
    loginPage().passwordFieldHasText("Enter your password");
  }

  @Test
  public void buttonLoginHasText() {
    loginPage().buttonLoginHasText("Log In");
  }

  @Test
  public void alertIsNotDisplayed() {
    loginPage().alertIsNotDisplayed();
  }

  @Test
  public void rememberMeCheckboxIsDisplayed() {
    loginPage().rememberMeCheckboxIsDisplayed();
  }

  @Test
  public void rememberMeCheckboxHasText() {
    loginPage().rememberMeCheckboxHasText("Remember Me");
  }

  @Test
  public void twitterIsDisplayed() {
    loginPage().twitterIsDisplayed();
  }

  @Test
  public void facebookIsDisplayed() {
    loginPage().facebookIsDisplayed();
  }
/**
 * Remark.
 *
 @Test
  public void linkedinIsDisplayed() {
    loginPage().linkedinIsDisplayed();
  }
 */
}
