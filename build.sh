#!/bin/bash
docker rmi decent-project
mvn package
docker build -t decent-project -f docker/Dockerfile .
