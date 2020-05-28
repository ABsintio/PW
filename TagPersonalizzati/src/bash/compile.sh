#!/bin/bash
jav=`find . -regex '.*\.java'`

if [ ! -z "`echo $jav | tail -n 1`" ]; then
    for file in ${jav}; do 
        javac -cp ".:./src/lib/*" -d ./WEB-INF/classes $file
    done

    class=`find . -regex '.*\.class'`
    
    for fileclass in ${class}; do
        jar cfv ./WEB-INF/lib/servlet.jar $fileclass
    done
fi

dir=`echo $(pwd) | awk '{split($0, array, "/"); print array[length(array)]}'`
cd ..
sudo bash script.sh $dir $1 $2
cd $dir