# language: es
Característica: Comprar suscripción desde CloudPay con dLocal

  Como cliente de Toolbox
  Quiero comprar una suscripción mediante dlocal
  Para acceder al contenido digital de Toolbox

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
      | emailAnular           |
      |jorge48461@yopmail.com |