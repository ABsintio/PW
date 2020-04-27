#!/bin/bash
jav=`find ./src/ -regex '.*\.java' | tail -n 1`
if [ ! -z $jav ]; then
    javac -cp ".:./src/lib/*" -d ./WEB-INF/classes ./src/*.java
    jar cfv ./WEB-INF/lib/servlet.jar ./WEB-INF/classes/*.class
fi

dir=`echo $(pwd) | awk '{split($0, array, "/"); print array[length(array)]}'`
cd ..
sudo bash script.sh $dir $1 $2
cd $dir