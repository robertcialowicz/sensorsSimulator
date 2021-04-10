# Administracja systemów komputerowych

## Project
Using Docker for the management of microservices: Kafka, MongoDB, CoAP server, MQTT broker


## Authors

Ciałowicz Robert <robcial@student.agh.edu.pl>

Szpila Magdalena <mszpila@student.agh.edu.pl>


## Architecture
![architecture](https://user-images.githubusercontent.com/62157661/113933870-6445a680-97f5-11eb-958d-f4eab547be92.png)


## How to setup:

1. Launch docker images
```
docker-compose up
```

2. Configure mqtt source connectors and mongodb sink connectors
```
install-connectors.bat   or   bash install-connectors.sh
```


## How to test:

1. Simulate temp sensors by sending mqtt messages
```
docker build -t temp-sensor .\tempSimulator
docker run -it --rm --name temp-sensor --network sensorssimulator_default temp-sensor
```


2. Check if messages were correctly processed ( mqtt -> kafka -> mongoDB )<br/>
2.1. Go to `http://localhost:3000/`<br/>
2.2. Crete connection using url: `mongodb://mongo-db/test?retryWrites=true` and Connect<br/>
2.3. Go to Collections -> MyCollection -> Execute<br/>
2.4. Messages from temp sensors should be visible<br/>

