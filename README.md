# Contador Básico de Palabras.
### Descripción:
---
Este programa es un contador básico de palabras, proporcionando el número de palabras en total utilizadas en el archivo, además del total palabras sin palabras auxiliares. Presenta también una lista de las 10 palabras más repetidas dentro de todo el texto. Estos datos pueden ser visualizados desde la consola donde se ejecuta el programa, genera también un archivo con el nombre del archivo original seguido de la palabra "Reporte" donde se guardan las estadisticas, del número de palabras y el listado de las palabras utilizadas en el texto, ordenadas por el número de veces que aparece cada una de mayor a menor.

### Tecnologías:
---
EL programa esta desarrollado en Java, desde el IDE de Eclipse Jee Mars. Dentro del programa se emplean librerías como Scanner y File, para manejar los archivos de entrada y salida del programa, implementado las herramientas para estructuras de datos como HashMap para los diccionario, y List para listas generadas dentro del programa.
	
### Forma de Uso:
---
Para utilizar el programa deberá descragar el archivo proporcionado, además debe de contar con el archivo "stopwords.txt", proporcionado aquí mismo, de donde se toman las palabras auxiliares. Estos archivos tanto el java como el txt deberan estar en el mismo directorio que el archivo del cual se van a contar las palabras.
Deberá colocarse en el directorio donde se encuentra su archivo desde la consola. Una vez ubicado en el directorio debera realizar los siguientes pasos.

	1. Compilar el archivo Java Para ello debe implementar el siguiente comando.
		javac Contador.java
    2. Ya terminada la compilacion debera ejecutar el programa el siguiente comando.
		java Contador <nombreArchivo>

# Ejemplo
---
En seguida se mostraran las estadisticas del archivo y se generará el archivo con el reporte. El archivo presenta los datos de la siguiente manera:

Total de Palabras = 160

Total de Palabras sin auxiliares = 87

<-- Palabras Repetidas Por Número de Aparición -->


1. de = 11
2. página = 8
3. wiki = 7
4. la = 6
5. en = 6
6. una = 5
7. el = 5
8. un = 4
9. del = 4
10. título = 4
11. palabra = 3
12. o = 3
13. web = 3
14. alpinismo = 3
15. es = 3
16. y = 2
17. así = 2
18. url = 2
19. a = 2
20. wikipedia = 2
21. enlace = 2
22. se = 2
23. los = 2
