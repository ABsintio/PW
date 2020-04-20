#!/bin/bash

name_dir=$1

mkdir $1
cd $1
inner_dir_src=( "bash" "html" "lib" )
inner_dir_web=( "classes" "lib" )
mkdir "./src" "./WEB-INF"

for i in ${inner_dir_src[@]}; 
do
	mkdir ./src/$i
done

for j in ${inner_dir_web[@]}; 
do
	mkdir ./WEB-INF/$j
done

touch index.html

# Sposto anche le librerie
sudo cp /opt/tomcat/latest/lib/servlet-api.jar ./src/lib/

cd ..

# Trovo il file per compilare 
compiler=$(find . -regex '.*compile\.sh')
cp -r $compiler "./${name_dir}/src/bash/"

sudo bash script.sh $1 "Inserita directory $1"
