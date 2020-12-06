#!/bin/bash
#===============================================================================
#
#          FILE:  docker_run.sh
#
#         USAGE:  ./docker_run.sh
#
#   DESCRIPTION: Ejecuta el comando por defecto o uno arbritario de la imagen 
#                generada en base al Dockerfile.
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
PROJECT_ENTRYPOINT=com.peqa.example_name.App

#===============================================================================
# Script Logic #================================================================
#===============================================================================
./docker_run.sh java -jar $MAVEN_PROJECT_NAME/target/$MAVEN_PROJECT_NAME-1.0-SNAPSHOT.jar $PROJECT_ENTRYPOINT
