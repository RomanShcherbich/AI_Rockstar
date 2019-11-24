package applitoolsTests;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pages.applitools.EyesExpensesComparisonPage;
import pages.applitools.EyesLoginPage;
import pages.applitools.EyesSecuredPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VisualAITests extends EyesBase {

  private EyesLoginPage login() {
    return new EyesLoginPage(eyes, driver);
  }

  @Test
  public void T1_LoginPageUiElementsTest() {
    login().checkLoginPage();
  }

  @Test
  public void T2a_DataDrivenTests_No_Password() {
    login().clickLogin("validUser", null, "Password must be present");
  }

  @Test
  public void T2b_DataDrivenTests_No_Username() {
    login().clickLogin(null, "validPass", "Username must be present");
  }

  @Test
  public void T2c_DataDrivenTests_No_Credentials() {
    login().clickLogin(null, null, "Both Username and Password must be present");
  }

  @Test
  public void T2d_DataDrivenTests_Valid_Credentials() {
    login().clickLogin("validUser", "validPass", null);
  }

  @Test
  public void T3_TableSortTests() {
    EyesSecuredPage securedPage = login().clickLoginNoCheck("validUser", "validPass");
    securedPage.eyesCheckSortingByAmount();
  }

  @Test
  public void T4_CanvasChartTest() {
    EyesSecuredPage securedPage = login().clickLoginNoCheck("validUser", "validPass");
    EyesExpensesComparisonPage page = securedPage.clickExpensesComparison();
    page.addYearAndCheck();
  }

  @Test
  public void T5_DynamicContentTest() {
    driver.get(driver.getCurrentUrl() + "?showAd=true");
    EyesSecuredPage securedPage = login().clickLoginNoCheck("validUser", "validPass");
    securedPage.checkWindow("gif adverts");
  }
}
