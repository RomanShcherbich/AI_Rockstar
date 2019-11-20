package webDriverTests;

import baseTests.BaseTests;
import org.junit.Test;
import pages.LoginPage;
import pages.SecuredPage;

public class TableSortTest extends BaseTests {

  @Test
  public void GridSortTest() {
    LoginPage loginPage = new LoginPage(driver);
    SecuredPage securedPage = loginPage.clickLogin("validUser", "validPass", null);
    securedPage.checkSortingByAmount();
  }
}
