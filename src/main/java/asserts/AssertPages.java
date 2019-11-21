package asserts;

import org.junit.Assert;

import java.util.List;

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

  public void assertListData(String errorMessage, List<String> expectedList, List<String> actualList) {

    String errorDetails = "";

    if (expectedList.size() != actualList.size()) {
      errorDetails += "Row count are different"
          + "\n\t\t" + "Before: " + expectedList.size()
          + "\n\t\t" + "After: " + actualList.size() + "\n";
    }

    for (int i = 0; i < expectedList.size(); i++) {
      String beforeRow = expectedList.get(i);
      String afterRow = actualList.get(i);
      if (!beforeRow.equals(afterRow)) {
        errorDetails += "Index #" + (i+1)
            + "\n\t\t" + "Before: " + beforeRow
            + "\n\t\t" + "After: " + afterRow + "\n";
      }
    }
    if (errorDetails != "") {
      Assert.fail("ERROR -> " + errorMessage + "\n" + errorDetails);
    }
  }
}
