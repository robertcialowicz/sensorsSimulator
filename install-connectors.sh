#!/bin/sh

curl -d @./KafkaConnect/connect-mqtt-source1.json -H "Content-Type: application/json" -X POST http://localhost:8083/connectors
curl -d @./KafkaConnect/connect-mqtt-source2.json -H "Content-Type: application/json" -X POST http://localhost:8083/connectors
curl -d @./KafkaConnect/connect-mqtt-source3.json -H "Content-Type: application/json" -X POST http://localhost:8083/connectors
curl -d @./KafkaConnect/connect-mqtt-source4.json -H "Content-Type: application/json" -X POST http://localhost:8083/connectors

curl -d @./KafkaConnect/connect-mongodb-sink1.json -H "Content-Type: application/json" -X POST http://localhost:8083/connectors
curl -d @./KafkaConnect/connect-mongodb-sink2.json -H "Content-Type: application/json" -X POST http://localhost:8083/connectors
curl -d @./KafkaConnect/connect-mongodb-sink3.json -H "Content-Type: application/json" -X POST http://localhost:8083/connectors
curl -d @./KafkaConnect/connect-mongodb-sink4.json -H "Content-Type: application/json" -X POST http://localhost:8083/connectors
