#Author: Sergio Perez Sanchez


Feature: Un usuario envia un mensaje

Scenario: Un usuario envia un mensaje
Given Un usuario crea un mensaje
When Escribe ese mensaje
Then Envia el mensaje a otro usuario