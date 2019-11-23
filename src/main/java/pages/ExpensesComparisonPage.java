package pages;

import testData.TestDataSets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpensesComparisonPage extends AbstractPage {

  public ExpensesComparisonPage(WebDriver driver) {
    super.driver = driver;
  }

  private TestDataSets expectedDataSet = new TestDataSets();

  private HashMap<String, List<String>> expectedChartData = expectedDataSet.getExpectedChart();
  private List<String> expectedMonths = expectedDataSet.getExpectedMonths();

  private static By byButtonAddYear = new By.ByXPath("//button[@class='btn btn-warning']");

  private static String jsNewYearChart = "return barChartData.datasets.map(x => [ x.label, x.data] )";
  private static String jsMonths = "return barChartData.labels";

  public void buttonNewYearHasText(String text) {
    assertElementText(text, byButtonAddYear);
  }

  public void checkChartData() {

    String errorDetails = "";

    HashMap<String, List<String>> actualYearsData = getChartData();
    List<String> actualMonths = getMonths();

    for (Map.Entry<String, List<String>> entry : actualYearsData.entrySet()
    ) {
      String year = entry.getKey();
      List<String> expected = expectedChartData.get(year);
      List<String> actual = entry.getValue();
      errorDetails += assertListData("There are invalid data for " + year, expected, actual);
    }
    errorDetails += assertListData("There are invalid months", expectedMonths, actualMonths);

    assertFail(errorDetails);
  }

  public void addYearAndCheckData() {
    clickButton(byButtonAddYear);
    checkChartData();
  }

  private HashMap<String, List<String>> getChartData() {
    ArrayList beforeNewYearChart = getNewYearChartData();

    HashMap<String, List<String>> yearsDataMap = new HashMap<>();

    for (int i = 0; i < beforeNewYearChart.size(); i++) {
      yearsDataMap.put(String.valueOf(getByIndex(beforeNewYearChart.get(i), 0))
          , getDataset(
              (getByIndex(beforeNewYearChart.get(i), 1))
          )
      );
    }
    return yearsDataMap;
  }

  private ArrayList getNewYearChartData() {
    return toArrayList(executeJsScript(jsNewYearChart));
  }

  private List<String> getMonths() {
    return getDataset(toArrayList(executeJsScript(jsMonths)));
  }

  public List<String> getDataset(Object object) {
    return Arrays.asList(toArrayList(object).toString()
        .replace("[", "")
        .replace("]", "")
        .replace(" ", "")
        .split(","));
  }

  public Object getByIndex(Object object, int index) {
    return toArrayList(object).get(index);
  }
}
