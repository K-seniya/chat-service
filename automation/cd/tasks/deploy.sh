#!/bin/sh
set -e
cp -R chat-service/* build-output/
cd build-output
cf push -p *.jar