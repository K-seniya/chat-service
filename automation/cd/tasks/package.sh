#!/bin/sh
set -e
cp -R chat-service/* build-output/
cd build-output
VERSION=`cat repo/number`
mvn versions:set -DnewVersion=${VERSION}
mvn clean package