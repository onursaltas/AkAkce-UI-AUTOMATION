package main.java.base.main;

import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;

public class mainclass {

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add(".//testnglogtest.xml");
        testng.setTestSuites(suites);
        testng.run();
    }

}
