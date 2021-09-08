package main.java.base.config;

public class Config {

    private Config() {

    }

    public static final String firefoxDriver = XmlFileParse.xmlFileParse("firefoxDriver", "config.xml");
    public static final String chromeDriver = XmlFileParse.xmlFileParse("chromeDriver", "config.xml");
    public static final String ieDriver = XmlFileParse.xmlFileParse("ieDriver", "config.xml");
    public static final String failurelogPath = XmlFileParse.xmlFileParse("failurelogPath", "config.xml");
    public static final String failurelogFilePath = XmlFileParse.xmlFileParse("failurelogFilePath", "config.xml");
    public static final String failureScreenShotName = XmlFileParse.xmlFileParse("failureScreenShotName", "config.xml");
    public static final String failureLogName = XmlFileParse.xmlFileParse("failureLogName", "config.xml");
    public static String gridEnable = XmlFileParse.xmlFileParse("gridEnable", "config.xml");
    public static String gridBrowserType = XmlFileParse.xmlFileParse("gridBrowserType", "config.xml");
    public static String gridPlatform = XmlFileParse.xmlFileParse("gridPlatform", "config.xml");
    public static String gridNodeIP = XmlFileParse.xmlFileParse("gridNodeIP", "config.xml");
    public static String acceptSSL = XmlFileParse.xmlFileParse("acceptSSL", "config.xml");
    public static String localBrowserType = XmlFileParse.xmlFileParse("localBrowserType", "config.xml");
    public static String headless = XmlFileParse.xmlFileParse("headless", "config.xml");

    public static final int wait = 30;
    public static final int waitBeforeTest = 300;
}