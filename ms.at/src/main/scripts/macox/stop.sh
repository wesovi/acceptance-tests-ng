#!/bin/bash

VAGRANT_PATH=$1'/src/test/etc'
cd $VAGRANT_PATH

echo "Stoppping vagrant"
vagrant suspend