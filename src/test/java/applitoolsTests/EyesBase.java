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


  public static Eyes eyes;

  public static Eyes getEyes() {
    return eyes;
  }

  public static void setEyes(Eyes eyes) {
    EyesBase.eyes = eyes;
  }

  private EyesRunner runner;
  protected WebDriver driver;

  @Rule
  public TestName name = new TestName();

  private static String ver = "23";

  private String hackathonUrl = "https://demo.applitools.com";
//  private String hackathonUrl = "https://demo.applitools.com/index_v2.html";

  @Before
  public void beforeEach() {

    runner = new ClassicRunner();
    eyes = new Eyes(runner);

    eyes.setApiKey(System.getenv("API_KEY"));

    eyes.setBatch(new BatchInfo(name.getMethodName() + ver));

    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().setSize(new Dimension(800,800));
    driver.manage().window().setPosition(new Point(0,0));

    eyes.open(driver, "Demo App" + ver, "Smoke Test" + name.getMethodName() + ver, new RectangleSize(800, 800));
    driver.get(hackathonUrl);
  }

  @After
  public void afterEach() {
    // End the test.
    eyes.closeAsync();

    driver.quit();

    eyes.abortIfNotClosed();

    TestResultsSummary allTestResults = runner.getAllTestResults();
//    System.out.println(allTestResults);
  }
}
