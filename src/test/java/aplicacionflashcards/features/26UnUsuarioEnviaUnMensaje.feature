#Author: Sergio Perez Sanchez


Feature: Un usuario env�a un mensaje

Scenario: Un usuario env�a un mensaje
Given Un usuario crea un mensaje
When Escribe ese mensaje
Then Envia el mensaje a otro usuario