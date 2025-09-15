### Multistage build 


``` bash
# Stage 1: Install dependencies and build the app
FROM node:18-alpine AS installer
WORKDIR /app

# Copy package files and install dependencies
COPY package*.json ./
RUN npm install

# Copy all source files and build the app
COPY . .
RUN npm run build  # Generates build artifacts

# Stage 2: Use nginx to serve the built app
FROM nginx:latest AS deployer

# Copy build output from previous stage to nginx's html directory
COPY --from=installer /app/build /usr/share/nginx/html
```

``` bash
# ---- Build Stage ----
    FROM maven:3.9.6-eclipse-temurin-17 AS build

    WORKDIR /app
    COPY Blog_Backend/. .
    
    RUN mvn clean package -DskipTests
    
    # ---- Runtime Stage ----
    FROM eclipse-temurin:17-jre-alpine
    
    WORKDIR /app
    COPY --from=build /app/target/*.jar app.jar
    
    EXPOSE 8080
    ENTRYPOINT ["java", "-jar", "app.jar"]
```