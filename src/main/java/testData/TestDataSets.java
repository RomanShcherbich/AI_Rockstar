package testData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestDataSets {

  public HashMap<String, List<String>> getExpectedChart() {
    HashMap<String, List<String>> map = new HashMap<>();

    List<String> values2017 = new ArrayList<>();
    values2017.add("10");
    values2017.add("20");
    values2017.add("30");
    values2017.add("40");
    values2017.add("50");
    values2017.add("60");
    values2017.add("70");

    map.put("2017",values2017);

    List<String> values2018 = new ArrayList<>();
    values2018.add("8");
    values2018.add("9");
    values2018.add("-10");
    values2018.add("10");
    values2018.add("40");
    values2018.add("60");
    values2018.add("40");

    map.put("2018",values2018);

    List<String> values2019 = new ArrayList<>();
    values2019.add("5");
    values2019.add("10");
    values2019.add("15");
    values2019.add("20");
    values2019.add("25");
    values2019.add("30");
    values2019.add("35");

    map.put("2019",values2019);

    return map;
  }

  public List<String> getExpectedMonths() {
    List<String> list = new ArrayList<>();
    list.add("January");
    list.add("February");
    list.add("March");
    list.add("April");
    list.add("May");
    list.add("June");
    list.add("July");

    return list;
  }

}
