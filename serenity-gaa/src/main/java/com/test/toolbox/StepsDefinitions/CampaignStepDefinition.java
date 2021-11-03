package com.test.toolbox.StepsDefinitions;

import com.test.toolbox.Steps.CampaignSteps;
import com.test.toolbox.Steps.DownloadSteps;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

public class CampaignStepDefinition {
public static String correo="";


    @Steps
    CampaignSteps campaignSteps;
    DownloadSteps downloadSteps;


    @Dado("que el cliente quiere crear una campaña mediante ToolboxID")
    public void loginBS(){
        campaignSteps.openWeb();

    }

    @Y("se loguea con sus credenciales")
    public void loginCredentials(){
        campaignSteps.loginCredentials();
    }

    @Cuando("selecciona la opción (.*) y selecciona la sección Campañas")
    public void insertNames(String cp){
        campaignSteps.selectCP(cp);
    }

    @Y("selecciona el botón de Crear campaña")
    public void createCampaing(){
        campaignSteps.selectButtonCampaign();
    }

    @Y("ingresa el nombre de campaña (.*)")
    public void setNameCampaign(String nameCampaign){
        campaignSteps.setNameCampaign(nameCampaign);
        campaignSteps.setClientID();
    }
    @Y("ingresa el prefijo (.*)")
    public void setPrefix(String prefix)
    {
        campaignSteps.setPrefix(prefix);
    }

    @Y("ingresa el país (.*)")
    public void setCountry(String country)
    {
        campaignSteps.setCountry(country);
    }

    @Y("ingresa el tiempo de expiración (.*)")
    public void setCodesTTL(String ttl)
    {
        campaignSteps.setCodesTTL(ttl);
    }

    @Y("ingresa la cantidad de códigos (.*) a generar")
    public void setAmountCodes(String amountCodes)
    {
        campaignSteps.setAmount(amountCodes);
    }

    @Y("ingresa la longitud (.*) de los cupones")
    public void setlongitudCodes(String longitud)
    {
        campaignSteps.setcodeLenght(longitud);
        campaignSteps.setFechaInicial();
        campaignSteps.setFechaFinal();
        campaignSteps.setURN();
        campaignSteps.confirmFormCampaign();
    }

    @Entonces("deberá visualizar el registro en el reporte de campañas")
    public void searchCampaign(){
        campaignSteps.searchCampaign();
        campaignSteps.clickOrdenarByMayor();
        campaignSteps.searchTextCampaign(campaignSteps.nameCampaignText);
        downloadSteps.setConfiguration();
        downloadSteps.downloadCSVCampaigns();
    }





}
