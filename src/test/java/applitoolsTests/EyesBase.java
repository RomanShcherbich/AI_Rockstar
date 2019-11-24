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
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.chrome.ChromeDriver;

public class EyesBase extends BaseTests{
  protected Eyes eyes;

  private EyesRunner runner;
  private static BatchInfo batch;

  @Rule
  public TestName name = new TestName();

  private String hackathonUrl = "https://demo.applitools.com/hackathon.html";
//  private String hackathonUrl = "https://demo.applitools.com/hackathonV2.html";

  @BeforeClass
  public static void setBatch() {
    batch = new BatchInfo("AiRockstarHackathon");
  }

  @Before
  public void beforeEach() {
    runner = new ClassicRunner();
    eyes = new Eyes(runner);

    /**
     * add API_KEY variable into Operating System Environment variables.
     */
    eyes.setApiKey(System.getenv("API_KEY"));

    eyes.setBatch(batch);

    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    driver = new ChromeDriver();

    eyes.open(driver, "demo.applitools.com", name.getMethodName(), new RectangleSize(1700, 900));
    driver.get(hackathonUrl);
  }


  @After
  public void afterEach() {

    eyes.closeAsync();
    driver.quit();
    eyes.abortIfNotClosed();

    TestResultsSummary allTestResults = runner.getAllTestResults();

    System.out.println(allTestResults.toString());
  }
}
