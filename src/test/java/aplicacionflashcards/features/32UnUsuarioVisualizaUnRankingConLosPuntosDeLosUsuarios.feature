#Author: Sergio Perez Sanchez


Feature: Un Usuario visualiza un ranking con los puntos de los usuarios

Scenario: Un Usuario visualiza un ranking
Given Un usuario accede a un ranking
When Visualiza el ranking
Then Ve una lista con los usuarios con mayor puntuacion