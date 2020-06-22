#!/bin/bash

mvn package -DskipTests
docker-compose down
docker-compose build
docker-compose up -d
