# 🔧 Maven Wrapper - Guía Completa

## ¿Qué es Maven Wrapper?

Maven Wrapper es una herramienta que permite ejecutar Maven sin necesidad de instalarlo previamente en el sistema. El proyecto incluye scripts (`mvnw` para Linux/Mac y `mvnw.cmd` para Windows) que descargan automáticamente la versión correcta de Maven la primera vez que se ejecutan.

## 🎯 Ventajas

✅ **No requiere instalación previa de Maven**  
✅ **Versión consistente** - Todos usan la misma versión de Maven  
✅ **Portable** - Funciona en cualquier sistema con Java  
✅ **Fácil de usar** - Simplemente ejecuta `./mvnw` en lugar de `mvn`  

## 📦 Archivos Incluidos

El proyecto incluye los siguientes archivos de Maven Wrapper:

```
.
├── mvnw                              # Script para Linux/Mac
├── mvnw.cmd                          # Script para Windows
└── .mvn/
    └── wrapper/
        └── maven-wrapper.properties  # Configuración (versión de Maven)
```

## 🚀 Uso Básico

### Compilar el proyecto

En lugar de:
```bash
mvn clean package
```

Usa:
```bash
./mvnw clean package
```

### Ejecutar el programa

En lugar de:
```bash
mvn exec:java -Dexec.mainClass="com.junta.tuturno.Main"
```

Usa:
```bash
./mvnw exec:java -Dexec.mainClass="com.junta.tuturno.Main"
```

### Limpiar el proyecto

```bash
./mvnw clean
```

### Ver información de Maven

```bash
./mvnw -version
```

## ⚡ Scripts Incluidos

### `build-and-run.sh` (Recomendado)

Compila y ejecuta el proyecto en un solo comando usando Maven Wrapper:

```bash
./build-and-run.sh
```

Este script:
1. Compila el proyecto con Maven Wrapper
2. Ejecuta el generador de presentaciones
3. Opcionalmente abre la presentación en LibreOffice

### `run.sh`

Ejecuta el programa (compila automáticamente si es necesario):

```bash
./run.sh
```

## 🔍 Primera Ejecución

La primera vez que ejecutes `./mvnw`, verás algo como:

```
Downloading https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.6/apache-maven-3.9.6-bin.zip
...........
Unzipping /home/user/.m2/wrapper/dists/apache-maven-3.9.6-bin.zip to /home/user/.m2/wrapper/dists/apache-maven-3.9.6
```

Maven se descargará automáticamente (solo la primera vez). Las siguientes ejecuciones serán inmediatas.

## 📋 Comandos Comunes

| Comando | Descripción |
|---------|-------------|
| `./mvnw clean` | Limpiar archivos compilados |
| `./mvnw compile` | Compilar el código fuente |
| `./mvnw package` | Crear JAR ejecutable |
| `./mvnw clean package` | Limpiar y crear JAR |
| `./mvnw test` | Ejecutar tests |
| `./mvnw dependency:tree` | Ver árbol de dependencias |
| `./mvnw -version` | Ver versión de Maven |

## 🐧 Linux/Mac vs 🪟 Windows

### Linux/Mac:
```bash
./mvnw clean package
```

### Windows (PowerShell):
```powershell
.\mvnw.cmd clean package
```

### Windows (CMD):
```cmd
mvnw.cmd clean package
```

## 🔧 Configuración

La versión de Maven se configura en `.mvn/wrapper/maven-wrapper.properties`:

```properties
distributionUrl=https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.6/apache-maven-3.9.6-bin.zip
```

Para cambiar la versión de Maven, modifica la URL en este archivo.

## 🌐 Ubicación de Descarga

Maven Wrapper descarga Maven en:
- **Linux/Mac**: `~/.m2/wrapper/dists/`
- **Windows**: `%USERPROFILE%\.m2\wrapper\dists\`

## ❓ Preguntas Frecuentes

### ¿Necesito instalar Maven?
**No.** Maven Wrapper lo descarga automáticamente.

### ¿Puedo seguir usando mi Maven instalado?
**Sí.** Puedes usar tanto `mvn` (Maven instalado) como `./mvnw` (Maven Wrapper).

### ¿Qué pasa si no tengo conexión a Internet?
La primera ejecución requiere Internet para descargar Maven. Después funciona sin conexión.

### ¿Ocupa mucho espacio?
Maven se descarga una sola vez (~10 MB) y se reutiliza en todos tus proyectos con Maven Wrapper.

### ¿Es seguro?
**Sí.** Maven Wrapper descarga Maven desde el repositorio oficial de Apache Maven.

## 🎓 Ejemplo Completo

```bash
# 1. Clonar o navegar al proyecto
cd /home/ssg/workspaces/git/curso-inap-iaprog-ejercicio-2

# 2. Compilar (primera vez descarga Maven)
./mvnw clean package

# 3. Ejecutar
java -jar target/tuturno-presentation-1.0.0-jar-with-dependencies.jar

# O usar el script todo-en-uno:
./build-and-run.sh
```

## 🔗 Referencias

- [Maven Wrapper GitHub](https://github.com/takari/maven-wrapper)
- [Documentación oficial Apache Maven](https://maven.apache.org/wrapper/)

---

**Resumen:** Maven Wrapper hace que tu proyecto sea más fácil de usar para cualquier persona, sin requerir instalación previa de Maven. ¡Simplemente ejecuta `./mvnw` y listo! 🚀
