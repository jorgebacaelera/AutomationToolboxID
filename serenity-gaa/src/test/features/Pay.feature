# language: es
Característica: Comprar suscripción desde CloudPay con dLocal

  Como cliente de Toolbox
  Quiero comprar una suscripción mediante dlocal
  Para acceder al contenido digital de Toolbox

  # Escenarios de negocio
  @ComprarSuscripción
  Esquema del escenario: Comprar suscripción mediante CloudPay con dlocal

    Dado que el comprador desea ingresar a la plataforma de Cloudpay

    Y selecciona la opción de comprar Suscripción

    Y ingresa en el formulario sus datos personales <nombre> <apellido>

    Y ingresa su correo electrónico <email>

    Y acepta los terminos y condiciones

    Y activa la cuenta confirmando el mensaje de verificación recibo al correo

    Y selecciona el producto con periodo <periodo>

    Y realiza el pago de la suscripción digitando los datos de pago con una tarjeta de crédito

    Entonces deberá visualizar el mensaje de transacción de compra exitosa

    Y deberá visualizar su acceso adquirido desde la plataforma Dummy

    Y deberá recibir un correo electrónico de confirmación de la compra

    Ejemplos:
      |nombre   |apellido   | email                      |periodo|
      |Jorge    |Baca       |jorge7783222@yopmail.com   |segundo|


  @CancelarSuscripción
  Esquema del escenario: Cancelar suscripción mediante CloudPay

    Dado que el comprador cuenta con una suscripción adquirida

    Y accede mediante su correo electrónico <emailAnular> a CloudPay

    Y confirma su acceso mediante el código de verificación

    Y ingresando a Dummy para dar de baja selecciona la opción My Account

    Y selecciona la opción de Anular suscripción

    Entonces deberá visualizar el mensaje de suscripción anulada

    Y se deberá recibir el correo electrónico indicando que la suscripción fue cancelada


    Ejemplos:
      | emailAnular              |
      |jorge7783222@yopmail.com  |