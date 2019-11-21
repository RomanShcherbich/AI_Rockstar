package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.*;

public class ExpensesComparisonPage extends AbstractPage {

  public ExpensesComparisonPage(WebDriver driver) {
    super.driver = driver;
  }

  private static By byExpencesCanvas = new By.ByXPath("//canvas[@id='canvas']");

  private static By byButtonAddYear = new By.ByXPath("//button[@class='btn btn-warning']");

  private static String jsNewYearChart = "return barChartData.datasets.map(x => [ x.label, x.data] )";
  private static String jsMonths = "return barChartData.labels";

  public void buttonNewYearHasText(String text) {
    assertElementText(text, byButtonAddYear);
  }

  public void addYearAndCheckData() {
    HashMap<String, List<String>> beforeYearsData = getNewYearChart();
    List<String> beforeMonths = getMonths();

    clickButton(byButtonAddYear);

    HashMap<String, List<String>> afterYearsData = getNewYearChart();
    List<String> afterMonths = getMonths();

    assertListData("There are invalid months", beforeMonths, afterMonths);

    for (var entry : beforeYearsData.entrySet()
         ) {
      String year = entry.getKey();
      List<String> expected = entry.getValue();
      List<String> actual = afterYearsData.get(year);
      assertListData("There are invalid years data", expected, actual);
    }
  }

  private HashMap<String, List<String>> getNewYearChart() {
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
