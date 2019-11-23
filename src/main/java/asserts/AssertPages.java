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

  public void assertFail(String errorDetails) {
    if (!errorDetails.equals("")) {
      Assert.fail(errorDetails);
    }
  }

  public String assertListData(String errorMessage, List<String> expectedList, List<String> actualList) {

    String errorDetails = "";

    int loop = expectedList.size();

    if (expectedList.size() != actualList.size()) {
      errorDetails += "Row count are different"
          + "\n\t\t" + "Expected: " + expectedList.size()
          + "\n\t\t" + "Actual: " + actualList.size() + "\n";
      if (expectedList.size() > actualList.size()) {
        loop = actualList.size();
        errorDetails += "Expected values have data which doesn't exist in actual values:";
        for (int i = 0; i < expectedList.size() - actualList.size(); i++) {
          int index = actualList.size() + i;
          errorDetails += "\n\t\t" + "Index #" + (index + 1) + "\t" + " =  " + expectedList.get(index) + "\n";
        }
      } else {
        errorDetails += "Actual values have data which doesn't exist in expected values:";
        for (int i = 0; i < actualList.size() - expectedList.size(); i++) {
          int index = expectedList.size() + i;
          errorDetails += "\n\t\t" + "Index #" + (index + 1) + "\t" + " =  " + actualList.get(index) + "\n";
        }
      }
    }

    for (int i = 0; i < loop; i++) {
      String beforeRow = expectedList.get(i);
      String afterRow = actualList.get(i);
      if (!beforeRow.equals(afterRow)) {
        errorDetails += "Index #" + (i + 1)
            + "\n\t\t" + "Expected: " + beforeRow
            + "\n\t\t" + "Actual: " + afterRow + "\n";
      }
    }

    if (errorDetails != "") {
      errorDetails = "ERROR -> " + errorMessage + "\n" + errorDetails;
    }
    return errorDetails;
  }
}
