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
DOCKER_CONTAINER_NAME=peqa.dev/tutorials/docker-maven
DOCKER_CONTAINER_TAG=latest

#===============================================================================
# Script Logic #================================================================
#===============================================================================
docker run --rm --name peqa.docker-maven \
           -v "$PWD/$MAVEN_DIRECTORY:/usr/src" \
           -it $DOCKER_CONTAINER_NAME:$DOCKER_CONTAINER_TAG $@
