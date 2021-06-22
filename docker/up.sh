#!/bin/bash

# Set the current working directory to the directory this script is located.
# shellcheck disable=SC2164
cd "$(dirname "$0")"

# Make sure the current user belongs to the group 'docker'.
# This would avoid issues and will not require root privileges.
if ! id -nGz "$USER" | grep -qzxF "docker"; then
  echo "ERROR: You must belong to the 'docker' group."
  exit 1
fi

# Make sure dialog, Docker and Docker Compose are installed.
if ! command -v docker &> /dev/null; then
  echo "Docker is not installed."
  exit 1
fi
if ! command -v docker-compose &> /dev/null; then
  echo "Docker Compose is not installed."
  exit 1
fi

if ! command -v dialog &> /dev/null; then
  echo "dialog is not installed."
  exit 1
fi

# Select the the environment type and finally compose up.
OPTIONS=(
  1 "Development"
  2 "Production"
)
CHOICE=$(dialog --clear \
  --backtitle "Docker | up.sh" \
  --title "What environment you would like to use?" \
  --menu "Choose one of the following options:" \
  20 50 5 \
  "${OPTIONS[@]}" \
  2>&1 >/dev/tty)

case $CHOICE in
  1)
    echo "Selected option: Development"
    cd ./development;;
  2)

    echo "Selected option: Production"
    cd ./production;;
esac

docker-compose --env-file ./.env up