package test.java.Main;

import main.java.base.functions.BrowserController;
import main.java.page.pages.MainPages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.Base.BaseTest;

import java.util.WeakHashMap;

public class ProductTest extends BaseTest implements BrowserController {


    ProductPage productPage = new ProductPage();

    @Test
    public void T01_SelectAttributeAndAssertThem(){

        productPage.SendSearchBox("Bilgisayar");
        productPage.ClickButton();
        productPage.ClickSelectNotebook();
        productPage.ClickselectBrand1();
        productPage.ClickselectBrand2();
        productPage.ClickselectBrand3();
        productPage.ClickSelectSeller();
        productPage.ClickSelectType();
        productPage.ClickSelectResulation();
        productPage.ClickSelectPanelType();
        productPage.ClickSelectCpuFast();
        productPage.ClickSelectMemory1();
        productPage.ClickSelectMemory2();
        productPage.ClickSelectMemory3();
        productPage.ClickSelectScreenSize();
        productPage.ClickSelectScreenResulation();
        productPage.ClickSelectDisplayCard();
        productPage.ClickSelectDisplayCardType();
        productPage.ClickSelectCpuModel();
        productPage.ClickSelectOperationSystem();
        productPage.ClickSelectHardDisk();
        productPage.ClickSelectSsd();
        productPage.ClickSelectPrice();

        String cpuFast = productPage.GetCpuFast();
        Assert.assertEquals("2.6 GHz",cpuFast);
        String cpuModel = productPage.GetCpuModel();
        Assert.assertEquals("3250U",cpuModel);
        String displayCardModel = productPage.GetDisplayCardModel();
        Assert.assertEquals("Radeon Graphics",displayCardModel);
        String cpuType = productPage.GetCpuType();
        Assert.assertEquals("AMD Ryzen 3",cpuType);
        String panelType = productPage.GetPanelType();
        Assert.assertEquals("TN",panelType);
        String displayCardType = productPage.GetDisplayCardType();
        Assert.assertEquals("Paylaşımlı",displayCardType);
        String hardDisk = productPage.GetHardDisk();
        Assert.assertEquals("1 TB",hardDisk);
        String memory = productPage.GetMemory();
        Assert.assertEquals("8 GB",memory);
        String ssd = productPage.GetSSD();
        Assert.assertEquals("256 GB" ,ssd);
        String operationSystem = productPage.GetOperationSystem();
        Assert.assertEquals("Win 10 Home" ,operationSystem);
        String screenResulation = productPage.GetScreenResulation();
        Assert.assertEquals("1920x1080 px" ,screenResulation);
        String secreenSize = productPage.GetScreenSize();
        Assert.assertEquals("15.6 inç" ,secreenSize);
        String resulation = productPage.GetResulation();
        Assert.assertEquals("Full HD" ,resulation);
        String type = productPage.GetType();
        Assert.assertEquals("Laptop / Notebook" ,type);


    }
}
