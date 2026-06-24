# API Gateway - Cuidado Seguro

## Descripción

El API Gateway de **Cuidado Seguro** corresponde al punto central de acceso hacia los microservicios del sistema.

Este componente permite gestionar el enrutamiento de solicitudes, controlar la seguridad mediante JWT, centralizar políticas de acceso y actuar como intermediario entre los clientes y los distintos servicios backend.

El Gateway fue desarrollado utilizando Spring Cloud Gateway bajo una arquitectura de microservicios moderna y escalable.

---

# Tecnologías Utilizadas

## Lenguaje y Framework

* **Java 17**
* **Spring Boot 3**
* **Spring Cloud Gateway**
* **Spring Security**
* **Spring WebFlux**

## Seguridad

* **JWT (JSON Web Token)**
* **Spring Security**
* **JWT Common Library**

## Documentación

* **Swagger OpenAPI**
* **Springdoc OpenAPI**

## DevOps y Arquitectura

* **Docker**
* **Arquitectura de Microservicios**
* **API Gateway Pattern**
* **Programación Reactiva**

---

# Funcionalidad del API Gateway

El API Gateway cumple las siguientes funciones dentro del sistema:

* Centralizar acceso a los microservicios
* Gestionar autenticación JWT
* Validar solicitudes HTTP
* Enrutar tráfico hacia servicios específicos
* Controlar seguridad y acceso
* Reducir exposición directa de microservicios

---

# Arquitectura del Proyecto

El proyecto implementa una arquitectura basada en componentes desacoplados.

## Componentes principales

### Gateway

Encargado del enrutamiento de solicitudes.

### Security

Gestiona autenticación y validación JWT.

### Filters

Permite interceptar solicitudes HTTP.

### JWT Common

Librería compartida para validación y generación de tokens.

---

# Estructura del Proyecto

```bash
api.gateway.cuidadoseguro
│
├── jwt-common
│   └── JwtService.java
│
├── src/main/java
│
├── src/main/resources
│
├── Dockerfile
│
└── pom.xml
```

---

# Dependencias Principales

| Dependencia          | Descripción                    |
| -------------------- | ------------------------------ |
| Spring Cloud Gateway | Enrutamiento de microservicios |
| Spring Security      | Seguridad y autenticación      |
| Spring WebFlux       | Programación reactiva          |
| JWT                  | Validación de tokens           |
| Swagger OpenAPI      | Documentación API              |
| Lombok               | Reducción de código repetitivo |

---

# Configuración del Proyecto

```properties
spring.application.name=api-gateway

server.port=8080

# Configuración Reactiva
spring.main.web-application-type=reactive

# Swagger
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.api-docs.path=/api-docs
```

---

# Explicación de Configuración

| Configuración                    | Descripción                    |
| -------------------------------- | ------------------------------ |
| spring.application.name          | Nombre del API Gateway         |
| server.port                      | Puerto principal del Gateway   |
| spring.main.web-application-type | Configuración WebFlux reactiva |
| springdoc.swagger-ui.path        | Ruta Swagger UI                |
| springdoc.api-docs.path          | Ruta documentación OpenAPI     |

---

# Instalación del Proyecto

## Clonar repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
```

## Ingresar al proyecto

```bash
cd api.gateway.cuidadoseguro
```

## Compilar proyecto

```bash
mvn clean install
```

---

# Ejecución del Proyecto

## Ejecutar localmente

```bash
mvn spring-boot:run
```

---

# Configuración Docker

```yaml
services:
  api-gateway:
    build: .
    container_name: api-gateway
    ports:
      - "8080:8080"
```

---

# Seguridad JWT

El API Gateway implementa autenticación y autorización mediante JWT.

## Funcionalidades implementadas

* Validación de tokens
* Protección de rutas
* Filtros de autenticación
* Seguridad centralizada
* Librería compartida jwt-common

---

# Programación Reactiva

El sistema utiliza Spring WebFlux para manejar solicitudes de forma reactiva.

## Beneficios

* Mejor manejo de concurrencia
* Arquitectura no bloqueante
* Mejor rendimiento bajo carga
* Escalabilidad horizontal

---

# Swagger - Documentación API

## Acceso Swagger UI

```bash
http://localhost:8080/swagger-ui.html
```

## API Docs

```bash
http://localhost:8080/api-docs
```

---

# Comunicación con Microservicios

El API Gateway se comunica con los distintos microservicios del sistema.

## Servicios Integrados

* Microservicio de Autenticación
* Microservicio de Pacientes
* Microservicio de Datos Médicos
* Backend For Frontend (BFF)

---

# Arquitectura Implementada

## API Gateway Pattern

Centraliza el acceso hacia los microservicios.

## Programación Reactiva

Implementada mediante Spring WebFlux.

## Seguridad JWT

Protege las comunicaciones entre servicios.

## Arquitectura de Microservicios

Permite desacoplar funcionalidades del sistema.

---

# Requisitos Previos

Antes de ejecutar el proyecto se requiere:

* Java 17
* Maven
* Docker Desktop (opcional)
* Puerto 8080 disponible

---

# Puertos Utilizados

| Puerto | Descripción                      |
| ------ | -------------------------------- |
| 8080   | Puerto principal del API Gateway |
| 8090   | Backend For Frontend             |

---

# Testing y Validación

Las pruebas del Gateway pueden realizarse mediante:

* Swagger UI
* Postman
* Frontend React



# Autor

Proyecto desarrollado para la asignatura de Fullstack III.

Desarrollado por: Carlos Bernal.



# Conclusión

El API Gateway de Cuidado Seguro implementa una solución moderna basada en Spring Cloud Gateway y WebFlux.

El sistema permite:

* Centralizar acceso a microservicios
* Gestionar autenticación JWT
* Proteger rutas y endpoints
* Mejorar seguridad del sistema
* Implementar arquitectura reactiva escalable

Todo esto permite construir una arquitectura distribuida segura, desacoplada y preparada para aplicaciones modernas basadas en microservicios.

# Despliegue en AWS ECS Fargate

## Infraestructura
- Cluster: cuidado-seguro-cluster
- Puerto: 8080
- Imagen: karipilo/api-gateway:latest
- Región: us-east-1

## CI/CD
Pipeline automático con GitHub Actions:
1. Build & Test
2. Docker Build & Push → Docker Hub
3. Deploy → AWS ECS Fargate

## Variables de entorno
| Variable | Descripción |
|----------|-------------|
| SPRING_PROFILES_ACTIVE | docker |
| JWT_SECRET | Clave secreta JWT |

## Servicios enrutados
| Servicio | IP | Puerto |
|----------|----|--------|
| Auth | 174.129.112.201 | 8081 |
| Datos médicos | 100.31.131.105 | 8083 |
| BFF | 34.203.222.130 | 8090 |
| Pacientes | pendiente | 8082 |
