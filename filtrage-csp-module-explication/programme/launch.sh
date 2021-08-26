  
#!bin/sh

[ -d build ] || mkdir build
javac -d build src/*.java 
java -cp build src.Main
