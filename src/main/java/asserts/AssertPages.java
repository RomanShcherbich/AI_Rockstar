package asserts;

import org.junit.Assert;

public abstract class AssertPages {

  public void assertTextField(String errorMessage, String expected, String actual) {
    Assert.assertEquals("ERROR -> " + errorMessage, expected, actual);
  }

  public void assertTrue(String errorMessage, Boolean tf) {
    Assert.assertTrue("ERROR -> " + errorMessage, tf);
  }

  public void assertFalse(String errorMessage, Boolean tf) {
    Assert.assertFalse("ERROR -> " + errorMessage, tf);
  }
}
