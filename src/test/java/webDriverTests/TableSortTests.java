package webDriverTests;

import baseTests.BaseTests;
import org.junit.Test;
import pages.LoginPage;
import pages.SecuredPage;

public class TableSortTests extends BaseTests {

  @Test
  public void gridSortTest() {
    login().checkSortingByAmount();
  }

  @Test
  public void buttonAmountHasText() {
    SecuredPage securedPage = login();
    securedPage.buttonAmountHasText("AMOUNT");
  }

  public SecuredPage login() {
    LoginPage loginPage = new LoginPage(driver);
    return loginPage.clickLogin("validUser", "validPass", null);
  }
}
