package webDriverTests;

import baseTests.BaseTests;
import org.junit.Test;
import pages.ExpensesComparisonPage;
import pages.LoginPage;
import pages.SecuredPage;

public class CanvasChartTests extends BaseTests {

  @Test
  public void buttonNewYearHasText() {
    expensesComparisonPage().buttonNewYearHasText("Show data for next year");
  }

  @Test
  public void chartHasValidData() {
    ExpensesComparisonPage chartPage = expensesComparisonPage();
    chartPage.checkChartData();
  }

  @Test
  public void addNewYearTest() {
    ExpensesComparisonPage chartPage = expensesComparisonPage();
    chartPage.addYearAndCheckData();
  }

  public ExpensesComparisonPage expensesComparisonPage() {
    LoginPage loginPage = new LoginPage(driver);
    SecuredPage securedPage = loginPage.clickLogin("validUser", "validPass", null);
    return securedPage.clickExpensesComparison();
  }
}
