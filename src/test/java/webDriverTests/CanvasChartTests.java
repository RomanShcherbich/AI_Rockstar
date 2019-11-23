package webDriverTests;

import org.junit.Test;
import pages.ExpensesComparisonPage;
import pages.SecuredPage;

public class CanvasChartTests extends TableSortTests {

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
    SecuredPage securedPage = login();
    return securedPage.clickExpensesComparison();
  }
}
