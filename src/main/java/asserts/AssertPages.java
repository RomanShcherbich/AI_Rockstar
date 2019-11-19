package asserts;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TestName;

public abstract class AssertPages {

  @Rule
  public TestName name = new TestName();

  public String getTestName() {
    return name.getMethodName() ;
  }

  public void assertTextField(String errorMessage, String expected, String actual) {
    Assert.assertEquals("ERROR -> " + getTestName() + " failed (" + errorMessage + ")",expected,actual);
  }

  public void assertBoolean(String errorMessage, Boolean tf) {
    Assert.assertTrue("ERROR -> " + getTestName() + " failed (" + errorMessage + ")", tf);
  }
}
