# language: es
Característica: Gestión de campañas

  Como cliente de Toolbox
  Quiero comprar una suscripción mediante dlocal
  Para acceder al contenido digital de Toolbox

  # Escenarios de negocio
  @Camapaigns
  Esquema del escenario: Campaigns

    Dado que el cliente quiere crear una campaña mediante ToolboxID

    Y se loguea con sus credenciales

    Cuando selecciona la opción <CP> y selecciona la sección Campañas

    Y selecciona el botón de Crear campaña

    Y ingresa el nombre de campaña <NombreCampana>

    Y ingresa el prefijo <prefijo>

    Y ingresa el país <country>

    Y ingresa el tiempo de expiración <ttl>

    Y ingresa la cantidad de códigos <amount> a generar

    Y ingresa la longitud <longitud> de los cupones

    Entonces deberá visualizar el registro en el reporte de campañas

    Ejemplos:
      |CP      |NombreCampana|prefijo|country|ttl|amount|longitud|
      |viacom  |PRUEBAJORGE12834  |BR2D| AR    |3  | 30   | 4      |