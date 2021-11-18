#!/bin/bash
dir=$(cd -P -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd -P)
mkdir -p "/home/$USER/.sixenn"

# Making sure that all files exist.
if [ ! -f "$dir/rest.yml" ]; then
  cp "$dir/rest.yml.example" "$dir/rest.yml"
fi
if [ ! -f "$dir/discord.yml" ]; then
  cp "$dir/discord.yml.example" "$dir/discord.yml"
fi

ln -s "$dir/rest.yml" "/home/$USER/.sixenn/rest.yml"
ln -s "$dir/discord.yml" "/home/$USER/.sixenn/discord.yml"

echo "[!] Symbolic link created successfully!"
echo "[!] Now you can edit your configuration in this directory or in /home/$USER/.sixenn/*.yml."