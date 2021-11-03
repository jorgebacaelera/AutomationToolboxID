package com.test.toolbox.Steps;
import com.test.toolbox.Util.Util;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class DownloadSteps {

    private String downloadFilePath= "D:\\QA Toolbox\\Test_Serenity";
    private WebDriver driver;

    public void setConfiguration(){
        HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups",0);
        chromePrefs.put("download.default_directory",downloadFilePath);

        ChromeOptions options= new ChromeOptions();
        options.setExperimentalOption("prefs",chromePrefs);

        driver = new ChromeDriver(options);
    }

    public void downloadCSVCampaigns(){
        (getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div/div/div[1]/div[2]/div/div/button"))).click();
        Util.waitFor(3);

        File folder = new File(downloadFilePath);
        File[] listofFiles = folder.listFiles();

        if (listofFiles.length>0) {
            System.out.println("SE DESCARGO BIEN");

        }
        else {
            System.out.println("NO SE DESCARGO");
        }




    }



}
