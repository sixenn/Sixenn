#!/bin/bash

# Set the current working directory to the directory this script is located.
# shellcheck disable=SC2164
cd "$(dirname "$0")"

# Make sure the target folder exists.
TARGET=${1:-~/sixenn}
mkdir -p "$TARGET"

cp ./sixenn.conf "$TARGET/"
cp ../locale/translations "$TARGET/"