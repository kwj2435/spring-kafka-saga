#!/bin/bash

echo "each module build start ..."
bash ./init/allModuleBuild.sh

echo "if docker-compose run then stop all container ..."
docker-compose down

echo "docker-compose up ..."
docker-compose up --build -d
