package pages.applitools;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EyesSecuredPage extends EyesAbstractPage {

  private static By byColumnAmount = new By.ByXPath("//th[normalize-space()='Amount']");
  private static By byRows = new By.ByXPath("//span[contains(text(),'USD')]/ancestor::tr");
  private static By byAmountValue = new By.ByXPath(".//span[contains(text(),'USD')]");
  private static By byText = new By.ByXPath(".//span");

  private static By byLinkExpenses = new By.ByXPath("//a[@id='showExpensesChart']");

  public EyesSecuredPage(Eyes eyes, WebDriver driver) {
    super(eyes, driver);
  }

  public void eyesCheckSortingByAmount() {
    List<WebElement> rowsElementsBefore = driver.findElements(byRows);

    clickButtonEyesCheck(byColumnAmount);

    List<WebElement> rowsElementsAfter = driver.findElements(byRows);

    List<String> beforeOrdering = rowValuesToString(sortElementsByText(rowsElementsBefore,byAmountValue));
    List<String> afterOrdering = rowValuesToString(rowsElementsAfter.stream());

    /* the method to help check every row values, because it is possible to missing something,
       when the values manually by screenshots */
    assertFail(assertListData("", beforeOrdering, afterOrdering));
  }

  private List<String> rowValuesToString(Stream<WebElement> stream) {
    return stream
        .map(el -> el.findElements(byText)
            .stream()
            .map(el2 -> el2.getText())
            .collect(Collectors.joining())
        )
        .collect(Collectors.toList());
  }

  public EyesExpensesComparisonPage clickExpensesComparison() {
    clickButtonEyesCheck(byLinkExpenses);
    return new EyesExpensesComparisonPage(eyes, driver);
  }
}
