#!/bin/bash

file=$1

if [ ! -d $file ]; then
    echo "Directory" $file "non esistente" >& 2
else
    sudo cp -r $file /opt/tomcat/latest/webapps/
fi

# Aggiungiamo al repository git
for i in $(ls); 
do
	if [ -d $i ]; then
		git add $i
	fi
done

git commit -m "$*"

git push -u origin master
