#Do the cleanup
docker compose down
Start-Sleep -s 3
Remove-Item -path ".\volumes\*" -recurse

#Build KafkaStreams
cd streams.examples
mvn clean package
Start-Sleep -s 3
cd ..

#Build CoapServer
cd CoapServer
mvn clean package
Start-Sleep -s 3
cd ..

#Start docker images
docker-compose up -d --build
Start-Sleep -s 30

#Install kafka connectors
Start-Process -FilePath ".\install-connectors.bat" -NoNewWindow -Wait
Start-Sleep -s 3

#Start mqtt producers
docker build -t temp-sensor .\tempSimulator
Start-Process -FilePath "powershell" -ArgumentList "-NoExit docker run -it --rm --name temp-sensor --network sensorssimulator_default temp-sensor"
Start-Sleep -s 3

#Coap client
cd CoapServer
npm i coap-cli -g
Start-Process -FilePath "powershell" -ArgumentList "-NoExit Start-Sleep -s 5; coap get coap://localhost:5683/publish"
cd ..
Start-Sleep -s 3

