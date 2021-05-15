# Administracja systemów komputerowych

## Project
Using Docker for the management of microservices: Kafka, MongoDB, CoAP server, MQTT broker


## Authors

Ciałowicz Robert <robcial@student.agh.edu.pl>

Szpila Magdalena <mszpila@student.agh.edu.pl>


## Architecture
![architektura](https://user-images.githubusercontent.com/62157661/118354451-6aa10e00-b56b-11eb-8ed5-5503d0ed8d27.png)


## Dataflow
![dataflow](https://user-images.githubusercontent.com/62157661/118355005-14819a00-b56e-11eb-88ab-722c2b5fcb2d.png)

## How to run:

Every procedure needed to run and test the application is included in powershell script.

```
.\run.ps1
```

During script execution following steps are made:<br/>
- Cleanup<br/>
- Build KafkaStreams project<br/>
- Build CoapServer project<br/>
- Build and start docker containers<br/>
- Install kafka connectors<br/>
- Start mqtt producers (in new window)<br/>
- Test coap endpoint (in new window)<br/>


## Debug:

1. Check if messages were correctly processed ( mqtt -> kafka -> mongoDB )<br/>
2.1. Go to `http://localhost:3000/`<br/>
2.2. Crete connection using url: `mongodb://mongo-db/test?retryWrites=true` and Connect<br/>
2.3. Go to Collections -> MyCollection -> Execute<br/>
2.4. Messages from temp sensors should be visible<br/>


