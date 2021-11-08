package com.test.toolbox.Steps;

import com.test.toolbox.StepsDefinitions.PayStepDefinition;
import com.test.toolbox.Util.Util;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import com.test.toolbox.Page.ElementsPage;
import org.openqa.selenium.JavascriptExecutor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PaySteps extends PageObject {


    ElementsPage elementsPage;
    public static String codVerify="";
    public static String demoMonthly="";
    public static String buttonSuscription="";


    @Step ("Ingresa a dummy y selecciona Cloudpay del país Argentina ")
    public void openWeb() {
        setDefaultBaseUrl("https://dummy-cert.tbxnet.com/");
        open();
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Serenity.takeScreenshot();
        Util.waitFor(3);
        (getDriver().findElement(By.xpath(elementsPage.buttonRedirect))).click();
        Util.waitFor(3);
        (getDriver().findElement(By.xpath(elementsPage.selectCountryAR))).click();
        Util.waitFor(3);
        (getDriver().findElement(By.xpath(elementsPage.msoModal))).click();
        Util.waitFor(3);
        (getDriver().findElement(By.xpath(elementsPage.msoModalDetails))).click();
        Util.waitFor(3);

    }
    @Step ("Selecciona la opción de Comprar Suscripción")
    public void clickOptionBuy(){
        (getDriver().findElement(By.xpath(elementsPage.buttonBuy))).click();
        Util.waitFor(3);
    }

    @Step ("Cliente ingresa su correo electronico")
    public void insertEmail(String email){
        (getDriver().findElement(By.xpath(elementsPage.textEmail))).sendKeys(email);
        Util.waitFor(1);
    }
    @Step ("Cliente digita su nombre y apellido")
    public void insertPersonalDates(String nombre , String apellido){
        (getDriver().findElement(By.xpath(elementsPage.name))).sendKeys(nombre);
        Util.waitFor(1);
        (getDriver().findElement(By.id(elementsPage.lastname))).sendKeys(apellido);

    }
    @Step ("Cliente acepta los términos y da click en continuar")
    public void clickContinue(){
        (getDriver().findElement(By.id(elementsPage.terms))).click();
        Util.waitFor(1);
        (getDriver().findElement(By.xpath(elementsPage.buttonContinue))).click();
        Util.waitFor(3);
    }

    public void pruebaYopmail(){

        setDefaultBaseUrl("https://yopmail.com/es/");
        open();
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        (getDriver().findElement(By.id("login"))).sendKeys(PayStepDefinition.correo);
        Util.waitFor(3);
        (getDriver().findElement(By.xpath(elementsPage.buttonEmailSearch))).click();
        Util.waitFor(3);
        Serenity.takeScreenshot();
        getDriver().switchTo().frame("ifmail");
        String codVerif= (String) ((JavascriptExecutor) getDriver()).executeScript(elementsPage.getCodesVerify);
        Util.waitFor(3);
        codVerify=codVerif;
        System.out.println(codVerif);

    }


    public void nuevaPestana(){
        ((JavascriptExecutor) getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        Util.waitFor(3);
    }

    public void confirmText(){
        Util.waitFor(3);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(0));
        Util.waitFor(3);
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath(elementsPage.getTextVerify))).sendKeys(codVerify);
        Util.waitFor(4);
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath(elementsPage.buttonConfirm))).click();
        Util.waitFor(3);
    }

    public void selectProduct(String product){

        if (product.equalsIgnoreCase("primer")) {

        }

        if (product.equalsIgnoreCase("segundo")) {
            (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/div/div[1]/div/div/div[2]/button[1]/span"))).click();
        }

        if (product.equalsIgnoreCase("tercero")) {
            Util.waitFor(2);
            (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/div/div[1]/div/div/div[2]/button[1]/span"))).click();
            Util.waitFor(2);
            (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/div/div[1]/div/div/div[2]/button[1]/span"))).click();
        }
        Util.waitFor(3);
        (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/div/div[2]/button[1]"))).click();
        Util.waitFor(5);
        Serenity.takeScreenshot();
    }

    public void formPay(){
        Util.waitFor(5);
        getDriver().switchTo().frame(0);
        (getDriver().findElement(By.id("pan-input"))).sendKeys("4111111111111111");
        Util.waitFor(2);
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(1);
        (getDriver().findElement(By.id("expiration-input"))).sendKeys("0226");
        Util.waitFor(2);
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(2);
        (getDriver().findElement(By.id("cvv-input"))).sendKeys("123");
        getDriver().switchTo().defaultContent();
        (getDriver().findElement(By.xpath("//*[@id=\"name\"]"))).sendKeys("JORGE BACA ELERA");
        (getDriver().findElement(By.xpath("//*[@id=\"userDocument\"]"))).sendKeys("77270572");
        (getDriver().findElement(By.xpath("//*[@id=\"description\"]"))).sendKeys("prueba");
        Util.waitFor(2);
        (getDriver().findElement(By.xpath("//*[@id=\"fields-form-example-1\"]/div/div/button[1]"))).click();
        Util.waitFor(4);
   //     (getDriver().findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div/div/button"))).click();
        Serenity.takeScreenshot();

    }

    public void verifyDummy(){
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        (getDriver().findElement(By.xpath("//*[@id=\"navbar-user\"]/ul/li[3]/a"))).click();
        Util.waitFor(3);
        (getDriver().findElement(By.xpath("//*[@id=\"navbar-user\"]/ul/li[3]/ul/li[1]/a"))).click();
        Util.waitFor(3);
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath("//*[@id=\"my-account-button\"]"))).click();
        Util.waitFor(5);
        Serenity.takeScreenshot();
        demoMonthly=(getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/p[2]"))).getText();
        Util.waitFor(3);
        System.out.println(demoMonthly);
      // assertThat(demoMonthly, equalTo("Suscripción mensual"));
        (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[1]/div/ul/a[2]"))).click();
        Util.waitFor(4);
        Serenity.takeScreenshot();
        //(getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[2]/div[2]/div/div[2]/table/tbody/tr/td[6]"))).click();
        //Util.waitFor(5);
        //Serenity.takeScreenshot();
    }

    public void confirmButtonBuy(){
        (getDriver().findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div/div/button"))).click();
        Serenity.takeScreenshot();
        Util.waitFor(6);
    }
    @Step("Cancelando Suscripción")
    public void cancelSuscription(){
        (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[2]/div[2]/p/a"))).click();
        Util.waitFor(3);
        (getDriver().findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/button[2]"))).click();
        Util.waitFor(3);
        Serenity.takeScreenshot();
    }

    public void verifyTextCancelled(){
        (getDriver().findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/button"))).click();
        Util.waitFor(3);
    }

    public void verifyOptionBuy(){
        buttonSuscription=(getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/div/div[2]/button[1]"))).getText();
    }



    public void verifyYopmail(){

        setDefaultBaseUrl("https://yopmail.com/es/");
        open();
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        (getDriver().findElement(By.id("login"))).clear();
        (getDriver().findElement(By.id("login"))).sendKeys(PayStepDefinition.correo);
        Util.waitFor(3);
        (getDriver().findElement(By.xpath(elementsPage.buttonEmailSearch))).click();
        Util.waitFor(3);
        Serenity.takeScreenshot();
    }




    public void loginCloudPay(String emailAnular){
        (getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div/div[2]/button[1]"))).click();
        Util.waitFor(3);
        (getDriver().findElement(By.id("username"))).sendKeys(emailAnular);
        Util.waitFor(3);
        (getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div/div/div[2]/div[1]/form/div[2]/button[1]"))).click();
        Util.waitFor(3);


    }

    public void accessDummy(){
        System.out.println("LLEGAMOS AQUI DELETE :O");
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        (getDriver().findElement(By.xpath("//*[@id=\"navbar-user\"]/ul/li[3]/a"))).click();
        Util.waitFor(3);
        (getDriver().findElement(By.xpath("//*[@id=\"navbar-user\"]/ul/li[3]/ul/li[1]/a"))).click();
        Util.waitFor(3);
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath("//*[@id=\"my-account-button\"]"))).click();
        Util.waitFor(5);
        Serenity.takeScreenshot();
        demoMonthly=(getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/p[2]"))).getText();
        Util.waitFor(3);
        System.out.println(demoMonthly);
        //assertThat(demoMonthly, equalTo("Suscripción mensual"));
        (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[1]/div/ul/a[2]"))).click();
        Util.waitFor(3);
    }
    public void confirmTextCancell(){
        Util.waitFor(3);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(0));
        Util.waitFor(3);
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath(elementsPage.getTextVerify))).sendKeys(codVerify);
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div/div/div/div[2]/div[2]/button"))).click();

    }

    public void accessDummyCancell(){
        System.out.println("LLEGAMOS AQUI DELETE");
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        (getDriver().findElement(By.xpath("//*[@id=\"navbar-user\"]/ul/li[3]/a"))).click();
        Util.waitFor(3);
        (getDriver().findElement(By.xpath("//*[@id=\"navbar-user\"]/ul/li[3]/ul/li[1]/a"))).click();
        Util.waitFor(3);
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath("//*[@id=\"my-account-button\"]"))).click();
        Util.waitFor(5);
        Serenity.takeScreenshot();
        //demoMonthly=(getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/p[2]"))).getText();
        Util.waitFor(3);
        //System.out.println(demoMonthly);
        //assertThat(demoMonthly, equalTo("Suscripción mensual"));
    }



}