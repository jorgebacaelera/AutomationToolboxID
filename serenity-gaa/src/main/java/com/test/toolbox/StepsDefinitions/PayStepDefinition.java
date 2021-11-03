package com.test.toolbox.StepsDefinitions;

import cucumber.api.java.es.Dado;
import com.test.toolbox.Steps.PaySteps;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.beanutils.PropertyUtilsBean;

public class PayStepDefinition {
public static String correo="";


    @Steps
    PaySteps paySteps;


    @Dado("que el comprador desea ingresar a la plataforma de Cloudpay")
    public void loginBS(){
        paySteps.openWeb();

    }

    @Y("selecciona la opción de comprar Suscripción")
    public void buySuscription(){
        paySteps.clickOptionBuy();
    }

    @Y("ingresa en el formulario sus datos personales (.*) (.*)")
    public void insertNames(String name, String lastname){
        paySteps.insertPersonalDates(name,lastname);
    }

    @Y("ingresa su correo electrónico (.*)")
    public void insertEmail(String email){
        correo=email;
        paySteps.insertEmail(email);
    }

    @Y("acepta los terminos y condiciones")
    public void acceptConditions(){
        paySteps.clickContinue();
    }

    @Y ("activa la cuenta confirmando el mensaje de verificación recibo al correo")
    public void activateAccount(){
        paySteps.nuevaPestana();
        paySteps.pruebaYopmail();
        paySteps.confirmText();
    }

    @Y("selecciona el producto con periodo (.*)")
    public void selectProduct(String period){
        paySteps.selectProduct(period);
    }

    @Y ("realiza el pago de la suscripción digitando los datos de pago con una tarjeta de crédito")
    public void insertPayInformation(){
        paySteps.formPay();
    }

    @Entonces("deberá visualizar el mensaje de transacción de compra exitosa")
    public void confirmAccount(){
        paySteps.confirmButtonBuy();
    }

    @Y("deberá recibir un correo electrónico de confirmación de la compra")
    public void verifyBuy(){
        paySteps.nuevaPestana();
        paySteps.verifyYopmail();
    }

    @Y("deberá visualizar su acceso adquirido desde la plataforma Dummy")
    public void verifyDummy(){
        paySteps.verifyDummy();
    }

    @Dado("que el comprador cuenta con una suscripción adquirida")
    public void searchSuscription(){
        paySteps.openWeb();
    }

    @Y("accede mediante su correo electrónico (.*) a CloudPay")
    public void loginEmailCloudPay(String emailAnular){
        correo=emailAnular;
        paySteps.loginCloudPay(emailAnular);
    }

    @Y ("confirma su acceso mediante el código de verificación")
    public void insertCodeVerificaciónYopmail(){
        paySteps.nuevaPestana();
        paySteps.pruebaYopmail();
        paySteps.confirmTextCancell();
    }

    @Y("ingresando a Dummy selecciona la opción My Account")
    public void accessDummy(){
        paySteps.accessDummy();
    }

    @Y("ingresando a Dummy para dar de baja selecciona la opción My Account")
    public void accessDummyCancell(){
        paySteps.accessDummyCancell();
    }

    @Y("selecciona la opción de Anular suscripción")
    public void cancelSucription(){
        paySteps.cancelSuscription();
    }

    @Entonces("deberá visualizar el mensaje de suscripción anulada")
    public void verifySuscriptionCancelled(){
        paySteps.verifyTextCancelled();
    }

    @Y("se deberá recibir el correo electrónico indicando que la suscripción fue cancelada")
    public void verifyEmailCancelled(){
        paySteps.nuevaPestana();
        paySteps.verifyYopmail();

    }
}
