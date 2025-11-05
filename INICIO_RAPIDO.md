# 🚀 GUÍA DE INICIO RÁPIDO

## ⚡ Pasos para Generar tu Presentación

### ✨ Método Ultra-Rápido (SIN instalar Maven)

```bash
./build-and-run.sh
```

**¡Eso es todo!** Este comando:
- ✅ Descarga Maven automáticamente (Maven Wrapper)
- ✅ Compila el proyecto
- ✅ Genera la presentación
- ✅ Te pregunta si quieres abrirla

¡Listo! La presentación estará en: `output/TuTurno_Presentacion.odp`

---

### 📋 Método Tradicional (con Maven instalado)

#### Paso 1: Instalar Maven (solo una vez)

```bash
./install-maven.sh
```

#### Paso 2: Compilar el Proyecto

```bash
mvn clean package
```

#### Paso 3: Generar la Presentación

```bash
./run.sh
```

¡Listo! La presentación estará en: `output/TuTurno_Presentacion.odp`

---

## � Más Información

- **Maven Wrapper**: Ver `MAVEN_WRAPPER.md` (cómo usar Maven sin instalarlo)
- **Documentación completa**: Ver `README.md`
- **Instalación manual**: Ver `INSTALACION.md`
- **Resumen del proyecto**: Ver `RESUMEN.md`

---

## 🎯 Lo que Genera el Programa

**8 diapositivas profesionales sobre el sistema Tu Turno:**

1. 📄 Portada elegante con fecha actual
2. 📋 Índice estructurado
3. 🎯 Introducción al sistema
4. ⚙️ Características principales
5. ✨ Beneficios (ciudadanos y administración)
6. 📝 Proceso de solicitud paso a paso
7. 📊 Estadísticas e impacto
8. 🏁 Conclusiones y próximos pasos

---

## ❓ Problemas Comunes

**Maven no está instalado:**
```bash
./install-maven.sh
```

**LibreOffice no abre el archivo:**
```bash
sudo apt install libreoffice-impress
```

**Error al compilar:**
```bash
mvn clean install -U
```

---

## 💡 Consejos

- El archivo `.odp` se puede editar después con LibreOffice
- Puedes modificar el contenido en `PresentationGenerator.java`
- Los colores institucionales ya están aplicados
- Ejecuta `./run.sh` cada vez que quieras regenerar la presentación

---

**Proyecto listo para usar** ✅
