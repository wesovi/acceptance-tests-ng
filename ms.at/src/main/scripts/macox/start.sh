#!/bin/bash

VAGRANT_PATH=$1'/src/test/etc'
echo $VAGRANT_PATH
cd $VAGRANT_PATH

echo "Launching vagrant"
vagrant up --provision-with=shell

vagrant ssh wesovi-acceptance-tests-ng-host --command="sudo chmod 777 /var/run/docker.sock ; cd /opt/containers ; docker-compose up -d"