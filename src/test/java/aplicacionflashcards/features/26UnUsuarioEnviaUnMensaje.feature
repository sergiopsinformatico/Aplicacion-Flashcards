#Author: Sergio Perez Sanchez


Feature: Un usuario envía un mensaje

Scenario: Un usuario envía un mensaje
Given Un usuario crea un mensaje
When Escribe ese mensaje
Then Envia el mensaje a otro usuario