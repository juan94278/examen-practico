# Usar una imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR del microservicio al contenedor
COPY /target/examen-practico-0.0.1-SNAPSHOT.jar examen-practico.jar

# Exponer el puerto en el que Spring Boot estará corriendo
EXPOSE 8080

# Comando para ejecutar el microservicio
ENTRYPOINT ["java", "-jar", "examen-practico.jar"]