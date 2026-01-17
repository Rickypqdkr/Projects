# Dockerfile

# Usamos una imagen que tiene tanto JDK como Maven
FROM maven:3.9.8-eclipse-temurin-21

# Establecemos el directorio de trabajo
WORKDIR /app

# Copiamos el pom.xml y descargamos dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código fuente
COPY src ./src

# El nuevo comando para iniciar la app en modo desarrollo
# Ya no creamos un .jar, ejecutamos directamente con el plugin de Maven
# que es compatible con DevTools
ENTRYPOINT ["mvn", "spring-boot:run"]