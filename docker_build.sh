#!/bin/bash
#===============================================================================
#
#          FILE:  docker_restart_maven_project.sh
#
#         USAGE:  ./docker_restart_maven_project.sh
#
#   DESCRIPTION: Inicializa o reinicializa un proyecto maven dentro de una
#                carpeta llamada`project`.
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
DOCKER_CONTAINER_NAME=peqa.dev/tutorials/docker-maven
DOCKER_CONTAINER_TAG=latest

#===============================================================================
# Script Logic #================================================================
#===============================================================================
docker build -t $DOCKER_CONTAINER_NAME:$DOCKER_CONTAINER_TAG . 

# Update and install python if needed
sudo apt-get -y update
sudo apt-get -y install python3 python3-pip ipython3
