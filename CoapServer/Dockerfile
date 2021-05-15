FROM adoptopenjdk/openjdk15:alpine
WORKDIR /
ADD /target/CoapServer-1.0-SNAPSHOT.jar CoapServer-1.0-SNAPSHOT.jar
ADD /target/dependency-jars dependency-jars
EXPOSE 5683
EXPOSE 61616
CMD java -jar CoapServer-1.0-SNAPSHOT.jar
