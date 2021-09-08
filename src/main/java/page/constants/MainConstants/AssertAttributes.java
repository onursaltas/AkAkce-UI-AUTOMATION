package main.java.page.constants.MainConstants;

import org.openqa.selenium.By;

public interface AssertAttributes {

    public final By AssertType = By.xpath("//table[@class='ppt']//following::text()[contains(.,'Laptop / Notebook')]");
    public final By AssertResulation = By.xpath("//table[@class='ppt']//following::text()[contains(.,'Çözünürlük Formatı')]//following::td[1]");
    public final By AssertPanelType = By.xpath("//table[@class='ppt']//following::text()[contains(.,'Panel Tipi')]//following::td[1]");
    public final By AssertCpuFast = By.xpath("//table[@class='ppt']//following::text()[contains(.,'İşlemci Hızı')]//following::td[1]");
    public final By AssertMemory = By.id("//table[@class='ppt']//following::text()[contains(.,'Bellek')]//following::td[1]");
    public final By AssertScrenSize = By.xpath("//table[@class='ppt']//following::text()[contains(.,'Ekran Boyutu')]//following::td[1]");
    public final By AssertScreenResulation = By.xpath("//table[@class='ppt']//following::text()[contains(.,'Ekran Çözünürlüğü')]//following::td[1]");
    public final By AssertDisplayCardType = By.xpath("//table[@class='ppt']//following::text()[contains(.,'Paylaşımlı')]");
    public final By AssertCpuModel = By.xpath("//table[@class='ppt']//following::text()[contains(.,'İşlemci Modeli')]//following::td[1]");
    public final By AssertCpuType = By.xpath("//table[@class='ppt']//following::text()[contains(.,'İşlemci Türü')]//following::td[1]");
    public final By AssertOperationSystem = By.xpath("//table[@class='ppt']//following::text()[contains(.,'İşletim Sistemi')]//following::td[1]");
    public final By AssertHardDisk = By.xpath("//table[@class='ppt']//following::text()[contains(.,'Sabit Disk')]//following::td[1]");
    public final By AssertSSD = By.xpath("//table[@class='ppt']//following::text()[contains(.,'SSD')]//following::td[1]");
    public final By AssertDisplayCardModel= By.xpath("//table[@class='ppt']//following::text()[contains(.,'Ekran Kartı Modeli')]//following::td[1]");

}
