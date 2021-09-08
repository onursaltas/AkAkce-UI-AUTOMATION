package test.java.Main;

import main.java.page.pages.MainPages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.Base.BaseTest;

public class ProductTest extends ProductPage   {

    @Test
    public void T01_SelectAttributeAndAssertThem(){

        SendSearchBox("Bilgisayar");
        ClickButton();
        ClickSelectNotebook();
        ClickselectBrand1();
        ClickselectBrand2();
        ClickselectBrand3();
        ClickSelectSeller();
        ClickSelectType();
        ClickSelectResulation();
        ClickSelectPanelType();
        ClickSelectCpuFast();
        ClickSelectMemory1();
        ClickSelectMemory2();
        ClickSelectMemory3();
        ClickSelectScreenSize();
        ClickSelectScreenResulation();
        ClickSelectDisplayCard();
        ClickSelectDisplayCardType();
        ClickSelectCpuModel();
        ClickSelectOperationSystem();
        ClickSelectHardDisk();
        ClickSelectSsd();
        ClickSelectPrice();

        String cpuFast = GetCpuFast();
        Assert.assertEquals("2.6 GHz",cpuFast);
        String cpuModel = GetCpuModel();
        Assert.assertEquals("3250U",cpuModel);
        String displayCardModel = GetDisplayCardModel();
        Assert.assertEquals("Radeon Graphics",displayCardModel);
        String cpuType = GetCpuType();
        Assert.assertEquals("AMD Ryzen 3",cpuType);
        String panelType = GetPanelType();
        Assert.assertEquals("TN",panelType);
        String displayCardType = GetDisplayCardType();
        Assert.assertEquals("Paylaşımlı",displayCardType);
        String hardDisk = GetHardDisk();
        Assert.assertEquals("1 TB",hardDisk);
        String memory = GetMemory();
        Assert.assertEquals("8 GB",memory);
        String ssd = GetSSD();
        Assert.assertEquals("256 GB" ,ssd);
        String operationSystem = GetOperationSystem();
        Assert.assertEquals("Win 10 Home" ,operationSystem);
        String screenResulation = GetScreenResulation();
        Assert.assertEquals("1920x1080 px" ,screenResulation);
        String secreenSize = GetScreenSize();
        Assert.assertEquals("15.6 inç" ,secreenSize);
        String resulation = GetResulation();
        Assert.assertEquals("Full HD" ,resulation);
        String type = GetType();
        Assert.assertEquals("Laptop / Notebook" ,type);


    }
}
