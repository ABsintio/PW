#!/bin/bash

javac -cp ".:./src/lib/*" -d ./WEB-INF/classes ./src/*.java
jar cfv ./WEB-INF/lib/servlet.jar ./WEB-INF/classes/*.class

dir=`echo $(pwd) | awk '{split($0, array, "/"); print array[length(array)]}'`
bash ../script.sh ../$dir
