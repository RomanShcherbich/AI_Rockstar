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

  public void assertGridRows(String errorMessage, List<String> beforeRows, List<String> afterRows) {

    String errorDetails = "";
    for (int i = 0; i < beforeRows.size(); i++) {
      String beforeRow = beforeRows.get(i);
      String afterRow = afterRows.get(i);
      if (!beforeRow.equals(afterRow)) {
        errorDetails += "Row #" + (i+1)
            + "\n\t\t" + "Before: " + beforeRow
            + "\n\t\t" + "After: " + afterRow + "\n";
      }
    }
    if (errorDetails != "") {
      Assert.fail("ERROR -> " + errorMessage + "\n" + errorDetails);
    }
  }
}
