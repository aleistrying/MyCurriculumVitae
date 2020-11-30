# Maven en Docker

Maven en docker es un proyecto que busca permitir a los desarrolladores aprovechar todas las funcionalidades que ofrece Maven sin las necesidad de instalar ni Java, ni ninguna otra dependencia más que Docker en sus computadores.

## Definiciones

### Maven

Maven, palabra yiddish que significa acumulador de conocimientos, comenzó como un intento de simplificar los procesos de construcción en el proyecto de la Turbina de Yakarta (Jakarta Turbine). Hubo varios proyectos, cada uno con sus propios archivos de construcción de Ants, que eran todos ligeramente diferentes. Queríamos una forma estándar de construir los proyectos, una clara definición de en qué consistía el proyecto, una forma fácil de publicar la información del proyecto, y una forma de compartir los JAR a través de varios proyectos.

El objetivo principal de Maven es permitir que un desarrollador comprenda el estado completo de un esfuerzo de desarrollo en el período de tiempo más corto. Para alcanzar este objetivo, Maven se ocupa de varias áreas de interés:

- Hacer que el proceso de construcción sea fácil
- Proporcionar un sistema de construcción uniforme
- Proporcionar información de calidad sobre los proyectos
- Fomento de mejores prácticas de desarrollo

Para más información: https://maven.apache.org/what-is-maven.html

### Docker

Docker es una plataforma abierta para desarrollar, enviar y ejecutar aplicaciones. Docker le permite separar sus aplicaciones de su infraestructura para que pueda entregar el software rápidamente. Con Docker, puede gestionar su infraestructura de la misma manera que gestiona sus aplicaciones. Aprovechando las metodologías de Docker para el envío, prueba e implementación de código rápidamente, puede reducir significativamente el retraso entre la escritura del código y su ejecución en producción.

Para más información: https://www.docker.com/why-docker

## Inicialización del proyecto maven

Para el proceso de iniciación, se debe ejecutar el script:

```docker_restart_maven_project.sh```

Este script elimina la carpeta `project` (si existe), luego construye un nuevo proyecto, basado en los siguientes parámetros:
- DgroupId={NombreDelGrupo}: Refiriéndose al "namespace" en el que el proyecto existe. Generalmente se utiliza nuestro nombre de dominio. Por ejemplo, si nuestro dominio es: peqa.com, colocaríamos `com.peqa.<proyecto>`. Parecería redundante la parte del `<proyecto>` con el atributo `DartifactId`, porque generaría el nombre de artefacto como: com.peqa.todolist:todolist. Donde el todolist que está antes de `:` es en referencia al groupID y el todolist que está después, es referente al artifactId. Sin embargo, hacerlo así, nos permite luego dividir el proyecto en librerías más pequeñas.
- DartifactId={NombreDelProyecto}: Es el propio nombre del proyecto. Cuando se construye el archivo .jar, el mismo tendrá este nombre.
- DarchetypeArtifactId={Plantilla}: Es el nombre del maven plug-in a utilizar.
- DinteractiveMode=false: Es hacer que el `batch-mode` utilice todos los valores por defecto durante la ejecución de maven.

Todos los valores mencionados pueden ser editados directamente en el archivo: `docker_restar_maven_project.sh`.

## Ejecución de comandos dentro del contenedor

Una vez se haya creado la carpeta inicial, se puede ejecutar el comando:

```docker_run.sh <comando_de_maven>```

Este script ejecuta o el compando por defecto de la imagen descrita en el `Dockerfile`, o

## Ejecución de los scripts en Windows

Para ejecutar estos scripts en windows, asegúrese de tener algún intérprete de bash donde ejecutarlos, por ejemplo: [git bash](https://git-scm.com/download/win)
