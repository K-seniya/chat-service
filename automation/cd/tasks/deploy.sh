#!/bin/sh
set -e
VERSION=`cat repo/number`
cf push -p build-output/chat-app-${VERSION}-SNAPSHOT.jar