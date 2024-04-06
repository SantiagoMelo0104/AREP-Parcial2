# Parcial Segundo Corte De Arep
En este parcial, se tiene que diseñe un sistema de microservicios que cumpla con los requisitos mencionados. El sistema constará de un servicio de ordenamiento, 
un service proxy y un cliente Web. El servicio de ordenamiento será responsable de computar las funciones de ordenamiento y será desplegado en al menos dos instancias 
virtuales de EC2. El service proxy será responsable de recibir las solicitudes de llamado desde los clientes y delegarlas a las dos instancias del servicio de ordenamiento 
usando un algoritmo de round-robin.El proxy será desplegado en otra máquina EC2. 
# Iniciando 
A continuación se indican una serie de instruciones para bajar y ejecutar el proyecto de manera exitosa:
Es **importante**❗tener instalado: 
- [MAVEN](https://maven.apache.org) : Manejo de las dependecias. 
- [GIT](https://git-scm.com) : Control de versiones.
- [JAVA](https://www.java.com/es/) : Lenguaje de programación (JDK 20).
- [AWS ACADEMI](https://awsacademy.instructure.com/): Para el uso de una máquina virtual.

# Arquitectura 
La arquitectura de este proyecto consta de los siguientes componentes:
+ Servicio de ordenamiento (MathService): Este servicio es responsable de computar las funciones de ordenamiento. Se implementan diferentes algoritmos de ordenamiento como burbuja, selección, inserción, etc. Este servicio es desplegado en al menos dos instancias virtuales de EC2.
+ Service Proxy (ServerProxy): Este proxy es responsable de recibir las solicitudes de llamado desde los clientes y delegarlas a las dos instancias del servicio de ordenamiento usando un algoritmo de round-robin. El proxy es desplegado en otra máquina EC2.
+ Cliente Web: Este cliente es responsable de recibir el valor y de manera asíncrona invocar el servicio en el PROXY. El cliente está escrito en HTML y JS.

El proyecto tiene las siguientes clases:
+ HttpConnection: Esta clase se encarga de realizar la conexión HTTP con el servicio de ordenamiento y obtener la respuesta.
+ MathService: Esta clase es el servicio de ordenamiento que implementa los algoritmos de ordenamiento y es desplegado en al menos dos instancias virtuales de EC2.
+ ServerProxy: Esta clase es el service proxy que recibe las solicitudes de llamado desde los clientes y delega las solicitudes a las dos instancias del servicio de ordenamiento usando un algoritmo de round-robin.

# Instalación ⬇️ y Ejecución🪄

* Los siguiente comando le permitira clonar el repositorio de manera local:
  ~~~
  git clone https://github.com/SantiagoMelo0104/AREP-Parcial2.git
  ~~~
* Entrar al directorio del proyecto con el siguiente comando:
   ~~~
   cd AREP-Parcial2
   ~~~
+ Abrir el proyecto en dos consolas porque en una se va acorrer la clase **ServerProxy** y en otro la clase **MathService**:
+ Primero compliar:
  ~~~
  mvn clean install
  ~~~
+ Correr con el siguiente comando la clase **ServerProxy**:
  ~~~
  java -cp "target/classes;target/dependency/*" org.arep.ServerProxy
  ~~~
+ Correr con el siguiente comando la clase **MathService**:
  ~~~
  java -cp "target/classes;target/dependency/*" org.arep.MathService
  ~~~

# Pruebas 
## Local 
Abrir en el navegador y colocar el path lo siguiente: 
~~~
http://localhost:4569/index.html
~~~
![image](https://github.com/SantiagoMelo0104/AREP-Parcial2/assets/123812833/ab80912c-f7ef-4999-9b77-a363d97c3538)
![image](https://github.com/SantiagoMelo0104/AREP-Parcial2/assets/123812833/689812cf-aabc-42c6-83fb-bb7478dfe9b9)


## AWS 
+ Vamos a correr desde la página de aws para esto se elige la instacia a conectarse:
Abrir en el navegador y colocar el path lo siguiente:
+ Vamos a instalar java,maven y git para poder correr el proyecto:
  ~~~
  sudo yum install java 
  ~~~
   ~~~
  sudo yum install maven 
  ~~~
    ~~~
  sudo yum install git
  ~~~
+ Ahora vamos a clonar el repositorio con el siguiente comando:
  ~~~
  git clone https://github.com/SantiagoMelo0104/AREP-Parcial2.git
  ~~~
* Entrar al directorio del proyecto con el siguiente comando:
   ~~~
   cd AREP-Parcial2
   ~~~
+ Vamos abir las 3 instancias, una para correr las clase **ServerProxy** y en las otras dos la clase **MathService**
+ Primero compliar:
  ~~~
  mvn clean install
  ~~~
+ Correr con el siguiente comando la clase **ServerProxy**:
  ~~~
  java -cp "target/classes:target/dependency/*" org.arep.ServerProxy
  ~~~
+ Correr con el siguiente comando la clase **MathService**:
  ~~~
  java -cp "target/classes:target/dependency/*" org.arep.MathService
  ~~~

# Pruebas 
## AWS
Abrir en el navegador y colocar el path lo siguiente: 
![imagen](https://github.com/SantiagoMelo0104/AREP-Parcial2/assets/123812833/f53fff39-79d0-4fda-92b1-710ddacb4ef1)

video: https://youtu.be/Shon9lcPYD4 
# Autor 
Santiago Naranjo Melo [SantiagoMelo0104](https://github.com/SantiagoMelo0104)
