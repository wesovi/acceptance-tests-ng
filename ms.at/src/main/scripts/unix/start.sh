#!/bin/bash

APPLICATIONS_PATH=$1/classes/applications

cd $1/classes/vagrant

echo "Launching vagrant"
vagrant up --no-parallel
