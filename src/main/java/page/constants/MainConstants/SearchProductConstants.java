package main.java.page.constants.MainConstants;

import org.openqa.selenium.By;

public interface SearchProductConstants {

    public final By SearchBox = By.xpath("//input[@placeholder='Neyi ucuza almak istersin?']");
    public final By SearchButton = By.xpath("//button[@title='Ara']");
    public final By SelectNotebook = By.xpath("//a[@title='Laptop ve Notebook']");



}
