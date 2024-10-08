#language: es
#Encoding: UTF-8
 ##Author: jairo.garcia@sofka.com.co
Característica:  Validar creacion de cliente

  Esquema del escenario: Crear Cliente
    Dado procede a ingresa a la siguiente "<URL>"
    Cuando procede a ingresar los datos del cliente en sing up
    Y procede loguearse en la opcion log in
    Y Despues añadir el telefono con "<posicion>" a gusto al carrito
    Entonces se podra observar un item en el carrito

    Ejemplos:
      | URL                        | posicion |
      | https://www.demoblaze.com/ | 5        |