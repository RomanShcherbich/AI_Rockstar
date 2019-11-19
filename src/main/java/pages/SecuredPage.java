package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecuredPage extends AbstractPage{

  private static By byLoggedUserIcon = new By.ByXPath("//div[@class='logged-user-i']");

  private static By byTable = new By.ByXPath("//table[@class='table table-padded']");
  private static By byColumnAmount = new By.ByXPath("//th[normalize-space()='Amount']");

  private static By byRows = new By.ByXPath("//span[contains(text(),'USD')]/ancestor::td");
  private static By byAmountValue = new By.ByXPath("span[contains(text(),'USD')]/ancestor::td/child::span");


  public SecuredPage(WebDriver driver) {
    super.driver = driver;
  }

  public void assertLoggedIn() {
    assertTrue("The login is not passed", isElementDisplayed(byLoggedUserIcon));
  }
}
