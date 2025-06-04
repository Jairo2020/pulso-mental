# Pulso Mental

## ¿Qué es Pulso Mental?
Pulso Mental es una aplicación de escritorio desarrollada en Java utilizando JavaFX. El objetivo es ofrecer una experiencia interactiva basada en la memoria y la agilidad mental, con una interfaz gráfica amigable.

## Requisitos previos
- Java 11 o superior
- Maven

## Cómo iniciar el proyecto
1. Clona este repositorio o descarga el código fuente.
2. Abre una terminal en la raíz del proyecto.
3. Ejecuta el siguiente comando para compilar y ejecutar la aplicación:
   
   ```bash
   mvn clean javafx:run
   ```

   Esto descargará las dependencias necesarias y lanzará la aplicación.

## Estructura del proyecto

```
pulso-mental/
│
├── pom.xml                        # Archivo de configuración de Maven y dependencias
├── README.md                      # Documentación del proyecto
└── src/
    └── main/
        ├── java/
        │   ├── module-info.java   # Configuración de módulos Java
        │   └── com/pulsomental/
        │       ├── App.java       # Clase principal de la aplicación
        │       ├── controllers/   # Controladores JavaFX (lógica de UI)
        │       ├── models/        # Modelos de datos (ej: Character, Projectil)
        │       ├── services/      # Lógica de negocio y servicios
        │       └── utils/         # Utilidades (ej: manejo de teclado)
        └── resources/
            └── com/pulsomental/
                ├── fxml/         # Archivos de interfaz (FXML)
                ├── images/       # Imágenes usadas en la app
                └── styles/       # Hojas de estilo CSS
```

### Descripción de carpetas principales
- **controllers/**: Lógica de interacción entre la interfaz y el usuario.
- **models/**: Clases que representan los datos principales de la aplicación.
- **services/**: Lógica de negocio y servicios auxiliares.
- **utils/**: Funciones utilitarias, como el manejo de teclado.
- **fxml/**: Archivos de interfaz gráfica (pantallas).
- **images/**: Recursos gráficos.
- **styles/**: Hojas de estilo para la interfaz.

## Créditos
Desarrollado para la materia Paradigmas de Programación.
