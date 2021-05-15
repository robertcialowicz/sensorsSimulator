FROM adoptopenjdk/openjdk15:alpine
WORKDIR /
ADD /target/streams.examples-0.1.jar streams.examples-0.1.jar
ADD /target/dependency-jars dependency-jars

CMD java -jar streams.examples-0.1.jar
