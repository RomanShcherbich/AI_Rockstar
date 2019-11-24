package applitoolsTests;

import baseTests.BaseTests;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EyesBase extends BaseTests {
  protected Eyes eyes;

  private EyesRunner runner;
  protected WebDriver driver;

  @Rule
  public TestName name = new TestName();

  private String hackathonUrl = "https://demo.applitools.com/hackathon.html";
//  private String hackathonUrl = "https://demo.applitools.com/hackathonV2.html";


  @Override
  @Before
  public void beforeEach() {
    runner = new ClassicRunner();
    eyes = new Eyes(runner);

    eyes.setApiKey(System.getenv("API_KEY"));

    eyes.setBatch(new BatchInfo(name.getMethodName()));

    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    driver = new ChromeDriver();

    eyes.open(driver, "VisualTestingFramework", name.getMethodName(), new RectangleSize(1700, 900));
    driver.get(hackathonUrl);
  }

  @Override
  @After
  public void afterEach() {

    eyes.closeAsync();

    driver.quit();
    eyes.abortIfNotClosed();

    TestResultsSummary allTestResults = runner.getAllTestResults();

    System.out.println(allTestResults.toString());
  }
}
