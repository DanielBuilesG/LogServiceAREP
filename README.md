# LogServiceAREP


Para la tarea usted debe construir una aplicación con la arquitectura propuesta y desplegarla en AWS usando EC2 y Docker.


![image](https://github.com/DanielBuilesG/LogServiceAREP/assets/73034258/3c9642b8-8233-4774-b0a6-c0c9c152ebd1)


El servicio MongoDB es una instancia de MongoDB corriendo en un container de docker en una máquina virtual de EC2
LogService es un servicio REST que recibe una cadena, la almacena en la base de datos y responde en un objeto JSON con las 10 ultimas cadenas almacenadas en la base de datos y la fecha en que fueron almacenadas.
La aplicación web APP-LB-RoundRobin está compuesta por un cliente web y al menos un servicio REST. El cliente web tiene un campo y un botón y cada vez que el usuario envía un mensaje, este se lo envía al servicio REST y actualiza la pantalla con la información que este le regresa en formato JSON. El servicio REST recibe la cadena e implementa un algoritmo de balanceo de cargas de Round Robin, delegando el procesamiento del mensaje y el retorno de la respuesta a cada una de las tres instancias del servicio LogService.


# Requisitos
- docker desktop
- IDE
- Java
- GitHub
  


# Instalación

Para correrlo se debe clonar este repositorio y el de https://github.com/DanielBuilesG/LogRoundRobinAREP.git

```
git clone https://github.com/DanielBuilesG/LogServiceAREP.git

```

# Como corrrerlo 

En ambos repositorios se abre un cmd y se corre el siguiente comando para cada uno 

```
mvn clean install

```

Luego en cada cmd respectivamente corremos los comandos

```
docker build --tag logservice .
docker build --tag roundrobin .

```

Esto para crear las imágenes en docker desktop

Adicionalmente bajamos la imagen de mongo, esto desde un cmd desde la raiz

```
docker pull mongo
```

Luego de esto basta con correr el siguiente comando en el proyecto de LogService 



![image](https://github.com/DanielBuilesG/LogServiceAREP/assets/73034258/a18220b4-8300-473e-9114-3c9da0c27515)

```
docker-compose up -d
```


![image](https://github.com/DanielBuilesG/LogServiceAREP/assets/73034258/a858c458-3bc3-4c76-b9a8-29a0793869f7)



En el docker-compose.yml habiamo puesto el puerto 8080 por defecto, asi que cuando el comando termine de correr, las imagenes
en docker desktop deberian estar corriendo.



El mismo procedimiento fue realizado en AWS en EC2, las siguientes imagenes son del docker corriendo desde AWS 


![image](https://github.com/DanielBuilesG/LogServiceAREP/assets/73034258/f7a67925-e821-45f0-a5e0-f51a939529d1)




![image](https://github.com/DanielBuilesG/LogServiceAREP/assets/73034258/a8681a2b-5cca-41ed-8ae3-56d71d7346f9)










