#!/bin/bash
#===============================================================================
#
#          FILE:  docker_stop.sh
#
#         USAGE:  ./docker_stop.sh
#
#   DESCRIPTION: Detiene un contenedor que esté ejecutando.
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
DOCKER_CONTAINER_NAME=peqa.docker-maven
DOCKER_IMAGE_NAME=peqa.dev/tutorials/docker-maven
DOCKER_IMAGE_TAG=latest

#===============================================================================
# Script Logic #================================================================
#===============================================================================
docker run --name $DOCKER_CONTAINER_NAME \
           -v "$PWD/$MAVEN_DIRECTORY:/usr/src" \
           -it $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_TAG $@
