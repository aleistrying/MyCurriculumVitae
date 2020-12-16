#!/bin/bash
#===============================================================================
#
#          FILE:  docker_compile.sh
#
#         USAGE:  ./docker_compile.sh
#
#   DESCRIPTION: Comila el proyecto de maven.
#
#       OPTIONS:  ---
#  REQUIREMENTS:  ---
#          BUGS:  ---
#         NOTES:  ---
#        AUTHOR:  Erick Agrazal, erick@agrazal.com
#       COMPANY:  P.E.Q.A
#       VERSION:  1.0
#       CREATED:  30/NOV/2020 10:31:01 AM GMT-5
#      REVISION:  ---
#===============================================================================

#===============================================================================
# Script Variables #============================================================
#===============================================================================
MAVEN_DIRECTORY=project
MAVEN_PROJECT_NAME=example_name

#===============================================================================
# Script Logic #================================================================
#===============================================================================

# Inicializa el proyecto de maven usando el plugin: `maven-archetype-quickstart`
sudo "$PWD"/docker_run.sh mvn -f $MAVEN_PROJECT_NAME/pom.xml package

# Corrige los permisos de la carpeta `project` que fue generada dentro de maven
# con permisos de root.
sudo chown -R $USER:$(id -gn $USER) "$PWD"/$MAVEN_DIRECTORY
