package webDriverTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({  webDriverTests.LoginPageUiElementsTest.class,
    webDriverTests.DataDrivenTests.class,
    TableSortTests.class,
    webDriverTests.CanvasChartTests.class,
    webDriverTests.DynamicContentTest.class
})
public class TraditionalTests { }
