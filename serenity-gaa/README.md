## Usar Java desde la versión 1.8 en adelante

Abrir una ventana de comando de window y ejecutar:

    java -version 

## Usar Maven

Abrir una ventana de comando de window y ejecutar:

    mvn --version 

## Ejecutar los casos de prueba automatizados

Abrir una ventana de comando de window y ejecutar:

    mvn clean verify -pl serenity-gaa -am
    
## Visualizar los reportes

Ambos comandos proporcionados anteriormente producirán un reporte de prueba de Serenity en el directorio `target/site/serenity`.
