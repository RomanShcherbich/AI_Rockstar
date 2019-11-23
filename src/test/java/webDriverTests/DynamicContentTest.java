package webDriverTests;

import baseTests.BaseTests;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.SecuredPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DynamicContentTest extends BaseTests {

  private static By byAdvert1 = new By.ByXPath("//div[@id='flashSale']");
  private static By byAdvert2 = new By.ByXPath("//div[@id='flashSale2']");

  public DynamicContentTest(WebDriver driver) {
    driver.get(driver.getCurrentUrl() + "?showAd=true");
    super.driver = driver;
  }

  @Test
  public void checkAdvert1() {
    login().assertDisplayingElement(byAdvert1);
  }

  @Test
  public void checkAdvert2() {
    login().assertDisplayingElement(byAdvert2);
  }

  public SecuredPage login() {
    LoginPage loginPage = new LoginPage(driver);
    return loginPage.clickLogin("validUser", "validPass", null);
  }
}
