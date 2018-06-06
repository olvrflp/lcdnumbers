[![Build Status](https://travis-ci.org/olvrflp/lcdnumbers.svg?branch=master)](https://travis-ci.org/olvrflp/lcdnumbers)

## Building and testing
This project includes a gradle wrapper that can be used to compile, test and publish jar.
just execute `gradlew` and this will compile and run the unit tests.
The test report can be found in `build/reports`

## Running
for running program first execute `gradlew shadowJar`
a fat-jar will be generated under build/libs
then execute `java -jar lcdnumbers-all.jar <inputfile>`
