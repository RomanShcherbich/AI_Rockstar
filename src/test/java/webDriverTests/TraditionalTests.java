package webDriverTests;

import baseTests.BaseTests;
import org.junit.Test;
import pages.LoginPage;
import pages.SecuredPage;

public class TraditionalTests extends BaseTests {

  @Test
  public void DataDrivenTest() {
    LoginPage loginPage = new LoginPage(super.driver);
    SecuredPage securedPage = loginPage.clickLogin("validUser","validPass", null);
    securedPage.assertLoggedIn();
  }
}
