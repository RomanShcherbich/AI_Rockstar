package pages.applitools;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EyesExpensesComparisonPage extends EyesAbstractPage {

  public EyesExpensesComparisonPage(Eyes eyes, WebDriver driver) {
    super(eyes, driver);
  }

  private static By byButtonAddYear = new By.ByXPath("//button[@class='btn btn-warning']");

  public void addYearAndCheck() {
    clickButtonEyesCheck(byButtonAddYear,"2019 added");
  }
}
