package baseTests;

import org.junit.Rule;
import org.junit.After;
import org.junit.Before;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {

  protected WebDriver driver;

  @Rule public TestName name = new TestName();

//  private String hackathonUrl = "https://demo.applitools.com/hackathon.html";
  private String hackathonUrl = "https://demo.applitools.com/hackathonV2.html";

  @Before
  public void beforeEach() {
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.get(hackathonUrl);
  }

  @After
  public void afterEach() {
    driver.quit();
  }
}

