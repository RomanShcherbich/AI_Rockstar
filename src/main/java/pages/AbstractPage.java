package pages;

import asserts.AssertPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPage extends AssertPages {

  protected WebDriver driver;
  protected WebDriverWait wait;

  public boolean isElementDisplayed(By by) {
    try {
      waitElement(by);
    } catch (TimeoutException ex) {
      return false;
    }
    List<WebElement> elements = driver.findElements(by);
    return !elements.isEmpty();
  }

  public boolean isElementEnabled(By by) {
    waitElement(by);
    WebElement element = driver.findElement(by);
    return element.isEnabled();
  }

  public void assertDisplayingElement(By by) {
    assertTrue("Element " + by.getClass().getSimpleName() + " doesn't exists", isElementDisplayed(by));
  }

  public void assertNotDisplayingElement(By by) {
    assertFalse("Element " + by.getClass().getSimpleName() + " doesn't exists", isElementDisplayed(by));
  }

  public void assertNotEnabledElement(By by) {
    assertFalse("Element " + by.getClass().getSimpleName() + " doesn't exists", isElementEnabled(by));
  }

  protected void waitElement(By by) {
    if (wait == null) {
      wait = new WebDriverWait(driver, 2);
    }
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }

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

  protected String getElementAttributeText(By by, String attribute) {
    WebElement element = driver.findElement(by);
    return element.getAttribute(attribute);
  }

  public void assertElementText(String text, By by) {
    assertTextField("Element " + by.toString() + " has invalid text", text, getElementText(by));
  }

  public void assertElementAttributeText(String text, String attribute, By by) {
    assertTextField("Element " + by.toString() + " has invalid text", text, getElementAttributeText(by, attribute));
  }

  protected void clickButtonLog(By buttonElement) {
    if (isElementDisplayed(buttonElement)) {
      System.out.println("Button > " + getElementText(buttonElement));
    }
    clickButton(buttonElement);
  }


  protected Object executeJsScript(String script){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    return js.executeScript(script);
  }

  protected ArrayList toArrayList(Object object) {
    return (ArrayList) object;
  }
}
