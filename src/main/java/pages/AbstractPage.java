package pages;

import asserts.AssertPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPage extends AssertPages {

  protected WebDriver driver;

//  protected WebDriverWait wait;

  protected boolean isElementDisplayed(By by) {
//    waitElement(by);
    List<WebElement> elements = driver.findElements(by);
    return !elements.isEmpty();
  }

//  protected void waitElement(By by) {
//    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//  }

  protected void insertText(By textElement, String inputText) {
    WebElement field = driver.findElement(textElement);
    if (inputText != null) {
      field.sendKeys(inputText);
    }
  }

  protected void clickButton(By buttonElement) {
    WebElement button = driver.findElement(buttonElement);
    button.click();
  }

  protected void moveToLink(String url) {
    driver.get(url);
  }

  protected String getElementText(By by) {
    WebElement element = driver.findElement(by);
    return element.getText();
  }

  protected void clickButtonLog(By buttonElement) {
//    waitElement(buttonElement);
    if (isElementDisplayed(buttonElement)){
    System.out.println("Button > " + getElementText(buttonElement));
    }
    clickButton(buttonElement);
  }
}
