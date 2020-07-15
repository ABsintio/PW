#!/usr/bin/env bash

javac -cp ".:./src/lib/*" -d ./WEB-INF/classes ./src/ServletGet.java
javac -cp ".:./src/lib/*" -d ./WEB-INF/classes ./src/ServletPost.java

class=`find . -regex '.*\.class'`

for fileclass in ${class}; do
    jar cfv ./WEB-INF/lib/servlet.jar $fileclass
done

dir=`echo $(pwd) | awk '{split($0, array, "/"); print array[length(array)]}'`
cd ..
sudo bash script.sh $dir $1 $2
cd $dir
