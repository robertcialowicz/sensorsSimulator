FROM adoptopenjdk/openjdk15:alpine
WORKDIR /
ADD CoapServer-1.0-SNAPSHOT.jar CoapServer-1.0-SNAPSHOT.jar
ADD dependency-jars dependency-jars
EXPOSE 5683
EXPOSE 61616
CMD java -jar CoapServer-1.0-SNAPSHOT.jar

