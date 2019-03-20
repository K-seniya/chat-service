#!/bin/sh
set -e
cp -R chat-service/* build-output/
cd build-output
mvn clean package
