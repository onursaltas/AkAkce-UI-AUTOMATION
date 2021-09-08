package main.java.base.variables;

import main.java.base.config.XmlFileParse;

public class Var {

    private Var() {

    }

    public static String downloadsFolder = XmlFileParse.xmlFileParse("downloadsFolder", "var.xml");

    public static String baseURL = XmlFileParse.xmlFileParse("baseURL", "var.xml");
    public static String userName = XmlFileParse.xmlFileParse("userName", "var.xml");
    public static String password = XmlFileParse.xmlFileParse("password", "var.xml");
    public static String projectPath = XmlFileParse.xmlFileParse("projectPath", "var.xml");

    public static final String excelFilesPath = XmlFileParse.xmlFileParse("excelFilesPath", "var.xml");
    public static String databaseIp = XmlFileParse.xmlFileParse("databaseIp", "var.xml");

   //Database bilgileri verildi.
    public static String connectionUrlBase = XmlFileParse.xmlFileParse("connectionUrlBase", "var.xml");
    public static String databaseName = XmlFileParse.xmlFileParse("databaseName", "var.xml");
    public static String dbUser = XmlFileParse.xmlFileParse("dbUser", "var.xml");
    public static String dbPassword = XmlFileParse.xmlFileParse("dbPassword", "var.xml");

    public static String connectionUrl = connectionUrlBase + "/" + "databaseName=" + databaseName + "," + "user="
            + dbUser + "," + "password=" + dbPassword; /* Mysql Database Connection URL */


    public static String testResult = XmlFileParse.xmlFileParse("testResult", "var.xml");

}