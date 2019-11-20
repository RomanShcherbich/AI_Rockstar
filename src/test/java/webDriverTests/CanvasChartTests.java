package webDriverTests;

import org.junit.Test;
import pages.ExpensesComparisonPage;
import pages.LoginPage;
import pages.SecuredPage;

public class CanvasChartTests extends TableSortTests {

  @Test
  public void buttonNewYearHasText() {
    expensesComparisonPage().buttonNewYearHasText("Show data for next year");
  }

  @Test
  public void NewYearInChartTest() {
    ExpensesComparisonPage chartPage = expensesComparisonPage();
    chartPage.addYearAndCheck();
  }

  public ExpensesComparisonPage expensesComparisonPage() {
    SecuredPage securedPage = login();
    return securedPage.clickExpensesComparison();
  }
}
