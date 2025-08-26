# Sistema de Gestión de Cartuchos de Videojuegos

## Descripción

Sistema integral de gestión para tiendas de videojuegos que permite administrar inventario de cartuchos, gestionar clientes y procesar ventas de forma eficiente. Desarrollado en Java utilizando Maven como herramienta de construcción y JUnit 5 para testing.

### Funcionalidades principales

- **Gestión de Clientes**: Alta, baja, modificación, búsqueda y listado de clientes
- **Gestión de Cartuchos**: Inventario por plataforma (Xbox, PlayStation, Switch)
- **Sistema de Ventas**: Ventas con múltiples líneas y control automático de stock
- **Búsquedas avanzadas**: Por plataforma, título y cliente
- **Reportes**: Ventas por cliente y totales acumulados

## Requisitos del sistema

- Java Development Kit (JDK) 17 o superior
- Apache Maven 3.6.0 o superior

## Instalación

### 1. Clonar el repositorio
```bash
git clone https://github.com/Davidrumbaa/sistema-cartuchos.git
cd sistema-cartuchos
```

### 2. Verificar herramientas
```bash
java -version
mvn --version
```

### 3. Compilar el proyecto
```bash
mvn clean compile
```

### 4. Ejecutar tests
```bash
mvn test
```

### 5. Generar documentación
```bash
mvn javadoc:javadoc
```

## Instrucciones de uso

### Ejecutar la aplicación
```bash
mvn exec:java -Dexec.mainClass="Main"
```

### Navegación del sistema

La aplicación presenta un menú principal con estas opciones:

1. **Gestión de clientes**
    - Alta de cliente con DNI único
    - Búsqueda por DNI
    - Modificación de datos
    - Baja de cliente
    - Listado completo

2. **Gestión de cartuchos**
    - Alta de cartucho por título y plataforma
    - Listado del catálogo
    - Búsqueda por plataforma

3. **Realizar venta**
    - Selección de cliente por DNI
    - Adición de líneas de venta
    - Control automático de stock
    - Cálculo de totales

4. **Mostrar ventas**
    - Listado completo de ventas
    - Consulta por cliente específico
    - Totales acumulados

## Estructura del proyecto

```
sistema-cartuchos/
├── src/
│   ├── main/java/
│   │   ├── Cliente.java              # Modelo de cliente
│   │   ├── Cartucho.java             # Modelo de cartucho
│   │   ├── GestorClientes.java       # Operaciones CRUD clientes
│   │   ├── GestorCartuchos.java      # Gestión inventario
│   │   ├── GestorVentas.java         # Procesamiento ventas
│   │   ├── Venta.java                # Modelo de venta
│   │   ├── LineaVenta.java           # Línea de producto vendido
│   │   ├── Plataforma.java           # Enum plataformas
│   │   ├── Estado.java               # Enum estados
│   │   └── Main.java                 # Aplicación principal
│   └── test/java/
│       ├── GestorClientesTest.java   # Tests gestión clientes
│       └── GestorCartuchosTest.java  # Tests gestión cartuchos
├── docs/                             # Documentación HTML
├── pom.xml                           # Configuración Maven
└── README.md                         # Este archivo
```

## Testing

Ejecutar suite completa de tests:
```bash
mvn test
```

Ejecutar test específico:
```bash
mvn test -Dtest=GestorClientesTest
```

Los tests cubren:
- Operaciones CRUD de clientes y cartuchos
- Validaciones de datos
- Control de stock en ventas
- Casos positivos y negativos

## Documentación

La documentación técnica se genera con Javadoc:
- Local: `docs/index.html`
- Comando: `mvn javadoc:javadoc`

## Autor

**Davidrumbaa** - Sistema de Gestión de Cartuchos  
Proyecto EDD 2025  
https://github.com/Davidrumbaa/sistema-cartuchos