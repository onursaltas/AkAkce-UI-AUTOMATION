package main.java.page.pages.MainPages;

import main.java.base.functions.AssertionFunctions;
import main.java.base.functions.BrowserController;
import main.java.base.functions.HelperMethods;
import main.java.base.functions.NavigationController;
import main.java.page.constants.MainConstants.AssertAttributes;
import main.java.page.constants.MainConstants.SearchProductConstants;
import main.java.page.constants.MainConstants.SelectAttributes;
import main.java.page.pages.InıtıalPages.LoginPage;

public class ProductPage extends LoginPage implements BrowserController, AssertionFunctions, NavigationController , HelperMethods, AssertAttributes, SearchProductConstants , SelectAttributes {


    public void SendSearchBox(String name) {
        info("Send Search Box");
        waitAndSendKeys(SearchBox , name);
    }
    public void ClickButton() {
        info("Click Button");
        waitAndClick(SearchButton);
    }
    public void ClickSelectType() {
        info("Click Select Type");
        waitAndClick(selectType);
    }
    public void ClickSelectNotebook() {
        info("Click Select Notebook");
        waitAndClick(SelectNotebook);
    }
    public void ClickselectBrand1() {
        info("Click Select Brand 1");
        waitAndClick(selectBrand1);
    }
    public void ClickselectBrand2() {
        info("Click Select Brand 2");
        waitAndClick(selectBrand2);
    }
    public void ClickselectBrand3() {
        info("Click Select Brand");
        waitAndClick(selectBrand3);
    }
    public void ClickSelectCpuFast() {
        info("Click Select Cpu Fast");
        waitAndClick(selectCpuFast);
    }
    public void ClickSelectCpuModel() {
        info("Click Select Cpu Model");
        waitAndClick(selectCpuModel);
    }
    public void ClickSelectCpuType() {
        info("Click Select Cpu Type");
        waitAndClick(selectCpuType);
    }
    public void ClickSelectDisplayCard() {
        info("Click Select Display Card");
        waitAndClick(selectDisplayCard);
    }
    public void ClickSelectSeller() {
        info("Click Select Seller");
        waitAndClick(selectSeller);
    }
    public void ClickSelectResulation() {
        info("Click Select Resulation");
        waitAndClick(selectResulation);
    }
    public void ClickSelectPanelType() {
        info("Click Select Panel Type");
        waitAndClick(selectPanelType);
    }
    public void ClickSelectMemory1() {
        info("Click Select Memeory 1 ");
        waitAndClick(selectMemory1);
    }
    public void ClickSelectMemory2() {
        info("Click Select Memory 2 ");
        waitAndClick(selectMemory2);
    }
    public void ClickSelectMemory3() {
        info("Click Select Memory3");
        waitAndClick(selectMemory3);
    }
    public void ClickSelectScreenSize() {
        info("Click Select Screen Size");
        waitAndClick(selectScrenSize);
    }
    public void ClickSelectScreenResulation() {
        info("Click Select Screen Resulation");
        waitAndClick(selectScreenResulation);
    }
    public void ClickSelectDisplayCardType() {
        info("Click Select Display Card Type");
        waitAndClick(selectDisplayCardType);
    }
    public void ClickSelectOperationSystem() {
        info("Click Select Operation System");
        waitAndClick(selectOperationSystem);
    }
    public void ClickSelectHardDisk() {
        info("Click Select Hard Disk");
        waitAndClick(selectHardDisk);
    }
    public void ClickSelectSsd() {
        info("Click Select SSD");
        waitAndClick(selectSSD);
    }
    public void ClickSelectPrice() {
        info("Click Select Price");
        waitAndClick(selectPrice);
    }
    public void ClickSelectUp() {
        info("Click Select Up");
        waitAndClick(Up);
    }
    public String  GetType(){
        info("Get Type");
        String type =getText(AssertType);
        return type;
    }
    public String  GetResulation(){
        info("Get Resulation");
        String resulation =getText(AssertResulation);
        return resulation;
    }
    public String  GetPanelType(){
        info("Get Panel Type");
        String panelType =getText(AssertPanelType);
        return panelType;
    }
    public String  GetCpuFast(){
        info("Get Cpu Fast");
        String cpuFast =getText(AssertCpuFast);
        return cpuFast;
    }
    public String  GetMemory(){
        info("Get Memory");
        String memory =getText(AssertMemory);
        return memory;
    }
    public String  GetScreenSize(){
        info("Get Screen Size");
        String screenSize =getText(AssertScrenSize);
        return screenSize;
    }
    public String  GetScreenResulation(){
        info("Get Screen Resulation ");
        String screenResulation =getText(AssertScreenResulation);
        return screenResulation;
    }
    public String  GetDisplayCardType(){
        info("Get Display Card Type");
        String displayCardType =getText(AssertDisplayCardType);
        return displayCardType;
    }
    public String  GetCpuModel(){
        info("Get Cpu Model");
        String cpuModel =getText(AssertCpuModel);
        return cpuModel;
    }
    public String  GetCpuType(){
        info("Get Cpu Type");
        String cpuType =getText(AssertCpuType);
        return cpuType;
    }
    public String  GetOperationSystem(){
        info("Get Operation System");
        String operationSystem =getText(AssertOperationSystem);
        return operationSystem;
    }
    public String  GetHardDisk(){
        info("Get Hard Disk");
        String hardDisk =getText(AssertHardDisk);
        return hardDisk;
    }
    public String  GetSSD(){
        info("Get Ssd");
        String ssd =getText(AssertSSD);
        return ssd;
    }
    public String  GetDisplayCardModel(){
        info("Get Display Card Model");
        String displayCardModel =getText(AssertDisplayCardModel);
        return displayCardModel;
    }









}
