#!/bin/bash
set -e

echo "each module build start ..."
bash ./init/allModuleBuild.sh

echo "docker-compose down ..."
docker-compose down

echo "docker-compose up ..."
docker-compose up --build -d
