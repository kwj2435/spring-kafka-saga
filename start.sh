#!/bin/bash

echo "each module build start ..."
bash ./init/allModuleBuild.sh

echo "docker-compose up ..."
docker-compose up -d
