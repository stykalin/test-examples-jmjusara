#!/bin/bash
if [ -z $1 ]
then
browser=""
else
browser=-Dselenide.browser=$1
fi
mvn test $browser