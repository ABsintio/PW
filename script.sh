#!/bin/bash

file=$1

if [ ! -d $file ]; then
    echo "Directory" $file "non esistente" >& 2
else
    cp -r $file /opt/tomcat/latest/webapps/
fi

commit=${@: -1:1}

# Aggiungiamo al repository git
[ $commit -eq 0 ] && exit
for i in $(ls ..); 
do
	if [ -d $i ]; then
		git add $i
	fi
done

git commit -a -m "$2"

git push -u origin master
