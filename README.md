# Generador de Presentación LibreOffice - Tu Turno

Generador automático de presentaciones en formato ODP (LibreOffice) sobre el sistema **Tu Turno**, el sistema de gestión de cita previa de la Junta de Andalucía.

## 📋 Descripción

Este proyecto genera automáticamente una presentación profesional estructurada con:

- ✅ Diapositiva de portada con título, subtítulo y fecha
- ✅ Diapositiva de índice con listado de secciones
- ✅ 5 diapositivas de contenido sobre Tu Turno:
  1. Introducción al sistema
  2. Características principales
  3. Beneficios para ciudadanos y administración
  4. Proceso de solicitud de cita previa
  5. Datos y estadísticas de uso
- ✅ Diapositiva de conclusiones y futuras mejoras

## 🚀 Requisitos Previos

### Software necesario:

1. **Java Development Kit (JDK) 17 o superior**
   ```bash
   java -version
   ```

2. **Maven** (OPCIONAL - el proyecto incluye Maven Wrapper)
   - ✅ **Recomendado**: Usar Maven Wrapper incluido (no requiere instalación)
   - El proyecto incluye `mvnw` (Maven Wrapper) que descarga Maven automáticamente
   - Si prefieres instalar Maven globalmente:
   ```bash
   mvn -version
   ```

3. **LibreOffice** (para visualizar la presentación generada)
   ```bash
   # En Ubuntu/Debian
   sudo apt install libreoffice-impress
   
   # En Fedora/RHEL
   sudo dnf install libreoffice-impress
   
   # En Arch Linux
   sudo pacman -S libreoffice-impress
   ```

## 📦 Instalación

### Opción A: Usando Maven Wrapper (Recomendado - No requiere instalar Maven)

**¡Sin instalación previa!** El proyecto incluye Maven Wrapper que descarga Maven automáticamente.

#### 1. Clonar o descargar el proyecto

```bash
cd /home/ssg/workspaces/git/curso-inap-iaprog-ejercicio-2
```

#### 2. Compilar y ejecutar en un solo paso

```bash
./build-and-run.sh
```

O compilar manualmente:

```bash
./mvnw clean package
```

---

### Opción B: Usando Maven instalado globalmente

#### 0. Instalar Maven (si no está instalado)

**Script Automático:**
```bash
./install-maven.sh
```

**Manual:**
```bash
# Ubuntu/Debian
sudo apt install maven

# Fedora/RHEL
sudo dnf install maven

# Arch Linux
sudo pacman -S maven
```

Ver más detalles en `INSTALACION.md`

#### 1. Clonar o descargar el proyecto

```bash
cd /home/ssg/workspaces/git/curso-inap-iaprog-ejercicio-2
```

#### 2. Compilar el proyecto

```bash
mvn clean compile
```

#### 3. Empaquetar el proyecto (crear JAR ejecutable)

```bash
mvn clean package
```

Esto creará dos archivos JAR en el directorio `target/`:
- `tuturno-presentation-1.0.0.jar` - JAR básico
- `tuturno-presentation-1.0.0-jar-with-dependencies.jar` - JAR con todas las dependencias incluidas (recomendado)

## 🎯 Ejecución

### ⚡ Forma más rápida (TODO EN UNO - con Maven Wrapper)

```bash
./build-and-run.sh
```

Este script compila el proyecto (si es necesario) y ejecuta el generador automáticamente.

---

### Otras opciones de ejecución:

#### Opción 1: Script de ejecución (compila si es necesario)

```bash
./run.sh
```

#### Opción 2: Ejecutar con Maven Wrapper

```bash
./mvnw exec:java -Dexec.mainClass="com.junta.tuturno.Main"
```

#### Opción 3: Ejecutar con Maven instalado

```bash
mvn exec:java -Dexec.mainClass="com.junta.tuturno.Main"
```

#### Opción 4: Ejecutar el JAR directamente

```bash
java -jar target/tuturno-presentation-1.0.0-jar-with-dependencies.jar
```

## 📂 Estructura del Proyecto

```
.
├── AGENTS.md                           # Especificaciones del ejercicio
├── README.md                           # Este archivo
├── pom.xml                             # Configuración Maven
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── junta/
│                   └── tuturno/
│                       ├── Main.java                      # Punto de entrada CLI
│                       ├── generator/
│                       │   └── PresentationGenerator.java # Generador principal
│                       └── slides/                        # Clases de diapositivas (legacy)
│                           ├── PortadaSlide.java
│                           ├── IndiceSlide.java
│                           ├── ContenidoSlides.java
│                           └── ConclusionesSlide.java
└── output/
    └── TuTurno_Presentacion.odp       # Presentación generada
```

## 📊 Salida

El programa genera un archivo `.odp` en el directorio `output/` con el nombre:

```
output/TuTurno_Presentacion.odp
```

## 👁️ Visualizar la Presentación

### Opción 1: LibreOffice Impress

```bash
libreoffice --impress output/TuTurno_Presentacion.odp
```

### Opción 2: Abrir directamente desde el gestor de archivos

Doble clic en el archivo `output/TuTurno_Presentacion.odp`

## 🛠️ Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación
- **Maven**: Gestión de dependencias y construcción
- **ODFDOM 0.10.0**: Librería para manipulación de documentos ODF (Open Document Format)
- **LibreOffice SDK 7.4.0**: SDK oficial de LibreOffice

## 🔧 Desarrollo

### Compilar sin ejecutar tests

```bash
mvn clean compile -DskipTests
```

### Limpiar archivos generados

```bash
mvn clean
rm -rf output/*.odp
```

### Regenerar la presentación

Simplemente ejecuta nuevamente el programa. El archivo en `output/` será sobrescrito.

## ❗ Solución de Problemas

### Error: "JAVA_HOME no está definido"

```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
export PATH=$JAVA_HOME/bin:$PATH
```

### Error al compilar: "Cannot find symbol"

Asegúrate de tener todas las dependencias:

```bash
mvn dependency:resolve
mvn clean install
```

### Error: "OutOfMemoryError"

Aumenta la memoria de la JVM:

```bash
export MAVEN_OPTS="-Xmx1024m"
mvn clean package
```

### La presentación no se abre en LibreOffice

Verifica que LibreOffice esté instalado:

```bash
which libreoffice
libreoffice --version
```

## 📝 Notas

- El contenido sobre "Tu Turno" está basado en características comunes de sistemas de cita previa en administraciones públicas
- Los datos estadísticos son ilustrativos y orientativos
- La presentación utiliza la tipografía y colores estándar de LibreOffice
- Formato profesional y estructura clara para presentaciones institucionales

## 👨‍💻 Autor

Proyecto desarrollado para el curso INAP sobre programación con IA.

## 📄 Licencia

Este proyecto es de carácter educativo.

---

**¿Preguntas o problemas?** Abre un issue en el repositorio del proyecto.
