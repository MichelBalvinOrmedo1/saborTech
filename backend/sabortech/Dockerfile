# Etapa de construcción
FROM maven:3.8.4-openjdk-17 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el resto del código fuente y compilar la aplicación
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:17-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR desde la etapa de compilación
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Definir el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]