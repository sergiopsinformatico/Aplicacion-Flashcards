#Author: Sergio Perez Sanchez


Feature: Un Usuario elimina un mensaje

Scenario: Un Usuario elimina un mensaje
Given Un usuario quiere eliminar un mensaje
When Borra el mensaje
Then Mensaje borrado