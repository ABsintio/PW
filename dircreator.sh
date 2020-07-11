#!/bin/bash

name_dir=$1

mkdir $1
cd $1
inner_dir_src=( "bash" "html" "lib" "tags" )
inner_dir_web=( "classes" "lib" "tlds" )
mkdir "./src" "./WEB-INF"

for i in ${inner_dir_src[@]}; 
do
	mkdir ./src/$i
done

for j in ${inner_dir_web[@]}; 
do
	mkdir ./WEB-INF/$j
done

# Prendo un file qualsiasi web.xml
path=`find .. -regex '.*web\.xml' | tail -n 1`
path_tag=`find .. -regex '.*lib\.tld' | tail -n 1`

touch index.html
touch ./WEB-INF/web.xml
touch ./WEB-INF/tlds/lib.tld

python3.8 - <<EOF
import time
try:
	start = time.time()
	streamr = open("${path}", mode="r")
	streamw = open("./WEB-INF/web.xml", mode="w")
	print("Prendo i dati dal file ${path}")
	while (line := streamr.readline()):
		if line == "<web-app>\n":
			break
		streamw.write(line)
	print("Scrittura nel file ./$1/WEB-INF/web.xml andata a buon fine")
except Exception as e:
	print("Qualcosa è andato storto -> ", e)
finally:
	end = time.time()
	print("Procedura completata in {ms} millisecondi".format(ms = str(int(end - start))))

try:
	start = time.time()
	streamr = open("${path_tag}", mode="r")
	streamw = open("./WEB-INF/tlds/lib.tld", mode="w")
	print("Prendo i dati dal file ${path_tag}")
	while (line := streamr.readline()):
		if line == "<taglib>\n":
			break
		streamw.write(line)
	print("Scrittura nel file ./$1/WEB-INF/tlds/lib.tld andata a buon fine")
except Exception as e:
	print("Qualcosa è andato storto -> ", e)
finally:
	end = time.time()
	print("Procedura completata in {ms} millisecondi".format(ms = str(int(end - start))))
EOF

# Sposto anche le librerie
sudo cp /opt/tomcat/latest/lib/servlet-api.jar ./src/lib/
sudo cp /opt/tomcat/latest/lib/jsp-api.jar ./src/lib/
sudo cp ../LIB/mysql-connector-java-8.0.20.jar ./src/lib/
sudo chown riccbrand ./src/lib/servlet-api.jar ./src/lib/jsp-api.jar ./src/lib/mysql-connector-java.8.0.20.jar

cd ..

# Trovo il file per compilare 
compiler=$(find . -regex '.*compile\.sh')
cp -r $compiler "./${name_dir}/src/bash/"
chmod u+x "./${name_dir}/src/bash/compiler.sh"

sudo bash script.sh $1 "Inserita directory $1" 1


