#!/bin/bash

VAGRANT_PATH=$1'/src/test/etc'
echo $VAGRANT_PATH
cd $VAGRANT_PATH

echo "Launching vagrant"


#Launching vagrant vm. Provisioning the virtual machines with docker and docker-compose, this will only be 
vagrant up --provision-with=shell


#Connecting to vagrant vm, and starting the containers by docker-compose utility.
vagrant ssh wesovi-acceptance-tests-ng-host --command="
	sudo chmod 777 /var/run/docker.sock;
	cd /opt/containers;
	docker-compose build extraction;
	docker-compose build insertion;
	docker-compose up -d;
	
	"
until $(curl --output /dev/null --silent --get --fail http://localhost:8081/health); do
    printf '.'
    sleep 1
done
until $(curl --output /dev/null --silent --get --fail http://localhost:8082/health); do
    printf '.'
    sleep 1
done
