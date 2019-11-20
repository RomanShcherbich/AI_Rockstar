package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class ExpensesComparisonPage extends AbstractPage {

  public ExpensesComparisonPage(WebDriver driver) {
    super.driver = driver;
  }

  private static By byExpencesCanvas = new By.ByXPath("//canvas[@id='canvas']");

  private static By byButtonAddYear = new By.ByXPath("//button[@class='btn btn-warning']");

  public void buttonNewYearHasText(String text) {
    assertElementText(text, byButtonAddYear);
  }

  public void clickNewYear() {
    clickButton(byButtonAddYear);
  }

  public void addYearAndCheck() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    var beforeNewYearChart = (ArrayList) js.executeScript("return barChartData.datasets.map(x => [ x.label, x.data] )");
//    js.executeScript("return barChartData.datasets.map(x => [ x.label, x.data] )");
    beforeNewYearChart.stream()
        .peek((y,x) -> getDataset(x))
        .collect(Collectors.toList())

    clickButton(byButtonAddYear);
  }

  public String[] getDataset (Object values) {
    Object dataset2 =  ((ArrayList)((ArrayList)values).get(0)).get(1);
    return dataset2.toString()
        .replace("[","")
        .replace("]","")
        .replace(" ","")
        .split(",");
  }
}
