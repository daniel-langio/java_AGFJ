#!/bin/sh
find core -name "*.java" -print0 | xargs -0 -n 500 java -jar google-java-format-1.23.0-all-deps.jar --replace
find html -name "*.java" -print0 | xargs -0 -n 500 java -jar google-java-format-1.23.0-all-deps.jar --replace
find lwjgl3 -name "*.java" -print0 | xargs -0 -n 500 java -jar google-java-format-1.23.0-all-deps.jar --replace
