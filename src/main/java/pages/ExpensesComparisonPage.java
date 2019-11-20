package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExpensesComparisonPage extends AbstractPage {

  public ExpensesComparisonPage(WebDriver driver) {
    super.driver = driver;
  }

  private static By byExpencesCanvas = new By.ByXPath("//canvas[@id='canvas']");

  private static By byButtonAddYear = new By.ByXPath("//button[@class='btn btn-warning']");

  public void addYearAndCheck() {
    clickButton(byButtonAddYear);
  }
}
