# Guía de Instalación de Dependencias

## 🔧 Instalación de Apache Maven

Maven no está instalado en tu sistema. Aquí tienes varias opciones para instalarlo:

### Opción 1: Instalación mediante gestor de paquetes (Recomendado)

#### Ubuntu/Debian:
```bash
sudo apt update
sudo apt install maven
```

#### Fedora/RHEL:
```bash
sudo dnf install maven
```

#### Arch Linux:
```bash
sudo pacman -S maven
```

### Opción 2: Instalación manual

1. Descargar Maven desde: https://maven.apache.org/download.cgi

2. Extraer el archivo:
```bash
tar -xzvf apache-maven-3.9.x-bin.tar.gz
sudo mv apache-maven-3.9.x /opt/
```

3. Configurar variables de entorno:
```bash
echo 'export M2_HOME=/opt/apache-maven-3.9.x' >> ~/.zshrc
echo 'export PATH=$M2_HOME/bin:$PATH' >> ~/.zshrc
source ~/.zshrc
```

4. Verificar instalación:
```bash
mvn -version
```

### Opción 3: Usar Maven Wrapper (incluido en este proyecto)

Si no quieres instalar Maven globalmente, puedes usar el Maven Wrapper:

```bash
# Descargar Maven Wrapper
cd /home/ssg/workspaces/git/curso-inap-iaprog-ejercicio-2
curl -O https://raw.githubusercontent.com/takari/maven-wrapper/master/mvnw
curl -O https://raw.githubusercontent.com/takari/maven-wrapper/master/mvnw.cmd
chmod +x mvnw

# Usar mvnw en lugar de mvn
./mvnw clean compile
./mvnw clean package
```

## ✅ Verificar Instalación

Después de instalar Maven, verifica que funciona:

```bash
mvn -version
```

Deberías ver algo como:

```
Apache Maven 3.9.x (...)
Maven home: /usr/share/maven
Java version: 17.0.16, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-17-openjdk-amd64
Default locale: es_ES, platform encoding: UTF-8
OS name: "linux", version: "...", arch: "amd64", family: "unix"
```

## 📦 Compilar el Proyecto

Una vez instalado Maven:

```bash
cd /home/ssg/workspaces/git/curso-inap-iaprog-ejercicio-2
mvn clean compile
mvn clean package
```

## 🚀 Ejecutar el Programa

```bash
java -jar target/tuturno-presentation-1.0.0-jar-with-dependencies.jar
```

O usa el script proporcionado:

```bash
./run.sh
```

## 🐛 Solución de Problemas

### Problema: "JAVA_HOME no está definido"

```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64' >> ~/.zshrc
echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.zshrc
source ~/.zshrc
```

### Problema: Maven descarga muy lento

Configura un mirror en `~/.m2/settings.xml`:

```xml
<settings>
  <mirrors>
    <mirror>
      <id>central-mirror</id>
      <url>https://repo.maven.apache.org/maven2</url>
      <mirrorOf>central</mirrorOf>
    </mirror>
  </mirrors>
</settings>
```

## 📚 Recursos Adicionales

- Documentación oficial de Maven: https://maven.apache.org/guides/
- Tutorial de Maven: https://maven.apache.org/guides/getting-started/
- ODFDOM Documentation: https://odftoolkit.org/odfdom/
