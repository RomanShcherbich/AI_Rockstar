package webDriverTests;

import baseTests.BaseTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import pages.LoginPage;
import pages.SecuredPage;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class DataDrivenTests extends BaseTests {

  @Parameters(name = "2.{3}:  {0} / {1} / {2}")
  public static List<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"validUser", null, "Password must be present", "a"},
        {null, "validPass", "Username must be present", "b"},
        {null, null, "Both Username and Password must be present", "c"},
        {"validUser", "validPass", null, "d"}
    });
  }

  @Parameter
  public String username;

  @Parameter(1)
  public String password;

  @Parameter(2)
  public String alert;

  @Parameter(3)
  public String caseName;

  @Test
  public void LoginWithData() {
    LoginPage loginPage = new LoginPage(driver);
    SecuredPage securedPage = loginPage.clickLogin(username, password, alert);
    if (securedPage != null) {
      securedPage.assertLoggedIn();
    }
  }
}