package com.test.toolbox.Steps;

import com.test.toolbox.Page.ElementsPage;
import com.test.toolbox.StepsDefinitions.PayStepDefinition;
import com.test.toolbox.Util.Util;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CampaignSteps extends PageObject {


    ElementsPage elementsPage;
    public static String nameCampaignText="";


    public DesiredCapabilities setDownloadsPath() {
        String downloadsPath = "D:\\QA Toolbox\\Test_Serenity";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", downloadsPath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        return caps;
    }

    @Step ("Ingresa a Toolbox ID")
    public void openWeb() {
        setDefaultBaseUrl("https://toolbox-id-admin-cert.tbxnet.com/login");
        open();
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Serenity.takeScreenshot();

    }

    public void loginCredentials(){
        (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/button"))).click();
        Util.waitFor(3);
        (getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/form/input[1]"))).sendKeys("pruebacertdash");
        (getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/form/input[2]"))).sendKeys("123456");
        (getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/form/div[1]/button"))).click();
        Util.waitFor(3);

    }

    public void selectCP(String cp){
        if (cp.equalsIgnoreCase("viacom")) {

        (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[1]/div/div/li[1]"))).click();
        (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[1]/div/div/div/div/div/div/a"))).click();
        Util.waitFor(3);

        }
    }

    public void selectButtonCampaign(){
        (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div/div[1]/div/a/span[1]/span"))).click();
        Util.waitFor(3);
    }

    public void setNameCampaign(String nameCampaign){
        nameCampaignText=nameCampaign;
        (getDriver().findElement(By.xpath("//*[@id=\"name\"]"))).sendKeys(nameCampaign);
    }

    public void setClientID(){
        (getDriver().findElement(By.xpath("//*[@id=\"clientId\"]"))).sendKeys("nogginCodes");
    }

    public void setPrefix(String prefix){
        (getDriver().findElement(By.xpath("//*[@id=\"prefix\"]"))).sendKeys(prefix);
    }

    public void setCountry(String country){
        (getDriver().findElement(By.xpath("//*[@id=\"country_code\"]"))).sendKeys(country);
    }

    public void setCodesTTL(String codesTTL){
        (getDriver().findElement(By.xpath("//*[@id=\"codesTTL\"]"))).sendKeys(codesTTL);
    }

    public void setAmount(String amount){
        (getDriver().findElement(By.xpath("//*[@id=\"amount\"]"))).sendKeys(amount);
    }

    public void setcodeLenght(String codeLenght){
        (getDriver().findElement(By.xpath("//*[@id=\"codeLength\"]"))).sendKeys(codeLenght);
    }

    public void flagTTL(String flagTTL){

        if (flagTTL.equalsIgnoreCase("si")) {

            (getDriver().findElement(By.xpath("//*[@id=\"loginValidAfterCampaignExpire\"]"))).click();
        }

    }

    public void onlyNumerics(String onlyNumerics){

        if (onlyNumerics.equalsIgnoreCase("si")) {

            (getDriver().findElement(By.xpath("//*[@id=\"onlyNumericCodes\"]"))).click();
        }

    }
    public void setFechaInicial(){
        (getDriver().findElement(By.xpath("//*[@id=\"from\"]"))).sendKeys("28090020211010");
    }

    public void setFechaFinal(){
        (getDriver().findElement(By.xpath("//*[@id=\"until\"]"))).sendKeys("28100020212020");

    }

    public void setURN(){

      (getDriver().findElement(By.xpath("//*[@id=\"react-select-2-input\"]"))).sendKeys("prueba"+Keys.TAB);
        Serenity.takeScreenshot();
    }

    public void confirmFormCampaign(){
        (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div/div/div/form/div[3]/div/button[2]"))).click();
        Util.waitFor(3);
    }

    public void searchCampaign(){
        (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div/div[2]/div/span/div/div[2]"))).click();

        (getDriver().findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[3]"))).click();
    }

    public void clickOrdenarByMayor(){
        (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div/div[2]/div/div[2]/table/thead/tr/th[3]/span"))).click();
        Util.waitFor(3);
    }

    public void searchTextCampaign(String textCampaign){
        (getDriver().findElement(By.xpath("//span[.='"+textCampaign+"']"))).click();
        Util.waitFor(3);

    }







}