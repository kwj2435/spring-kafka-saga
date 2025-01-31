#!/bin/bash

echo "docker-compose rebuild and start ..."
docker-compose down
docker-compose up --build -d
