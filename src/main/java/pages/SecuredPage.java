package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecuredPage extends AbstractPage {

  private static By byLoggedUserIcon = new By.ByXPath("//div[@class='logged-user-i']");

  private static By byColumnAmount = new By.ByXPath("//th[normalize-space()='Amount']");

  private static By byRows = new By.ByXPath("//span[contains(text(),'USD')]/ancestor::tr");
  private static By byAmountValue = new By.ByXPath(".//span[contains(text(),'USD')]");
  private static By byText = new By.ByXPath(".//span");

  private static By byLinkExpenses = new By.ByXPath("//a[@id='showExpensesChart']");


  public SecuredPage(WebDriver driver) {
    super.driver = driver;
  }

  public void assertLoggedIn() {
    assertTrue("The login is not passed", isElementDisplayed(byLoggedUserIcon));
  }

  public void checkSortingByAmount() {
    List<WebElement> rowsElementsBefore = driver.findElements(byRows);

    clickButton(byColumnAmount);

    List<WebElement> rowsElementsAfter = driver.findElements(byRows);

    List<String> beforeOrdering = rowValuesToString(sortByAmount(rowsElementsBefore));
    List<String> afterOrdering = rowValuesToString(rowsElementsAfter.stream());

    assertListData("", beforeOrdering, afterOrdering);
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

  private Stream<WebElement> sortByAmount(List<WebElement> webElements) {
    return webElements.stream()
        .sorted(
            (e1, e2) -> {
              Double n1 = getStringToAmount(e1.findElement(byAmountValue).getText());
              Double n2 = getStringToAmount(e2.findElement(byAmountValue).getText());

              if (n1 <= n2) {
                return -1;
              } else {
                return 1;
              }
            }
        );
  }

  public Double getStringToAmount(String amount) {
    return Double.valueOf(amount
        .replace(" ", "").replace(",", "").replace("+", "")
        .substring(0, amount.indexOf("USD") - 4));
  }

  public ExpensesComparisonPage clickExpensesComparison() {
    clickButton(byLinkExpenses);
    return new ExpensesComparisonPage(driver);
  }

  public void buttonAmountHasText(String text) {
    assertElementText(text, byColumnAmount);
  }
}
