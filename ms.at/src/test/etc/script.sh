#!/bin/bash
sudo apt-get install -y curl
curl -sSL https://get.docker.com/ | sh

curl -L https://github.com/docker/compose/releases/download/1.2.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose

sudo chmod 777 /var/run/docker.sock
cd /opt/containers
docker-compose up -d