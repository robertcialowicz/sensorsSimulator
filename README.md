How to setup:

1. Launch docker images
docker-compose up

2. Configure mqtt source connector
curl -d @./connect-mqtt-source.json -H "Content-Type: application/json" -X POST http://localhost:8083/connectors

3. Configure mongodb sink connector
curl -d @./connect-mongodb-sink.json -H "Content-Type: application/json" -X POST http://localhost:8083/connectors



How to test:

1. Send mqtt msg
docker run -it --rm --name mqtt-publisher --network sensorssimulator_default efrecon/mqtt-client pub -h mosquitto  -t "baeldung" -m "{\"id\":1245634,\"message\":\"This is a test2465\"}"

2. Check if msg is present on kafka broker
docker run --network sensorssimulator_default --rm confluentinc/cp-kafka:5.1.0 kafka-console-consumer --bootstrap-server kafka:9092 --topic connect-custom --from-beginning

3. Check if msg is present in MongoDB
3.1. Go to http://localhost:3000/
3.2. Crete connection using url: mongodb://mongo-db/test?retryWrites=true and Connect
3.3. Go to Collections -> MyCollection -> Execute, msg should be visible
