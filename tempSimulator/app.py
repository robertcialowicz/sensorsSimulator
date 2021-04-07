import os
import time
import paho.mqtt.client as mqtt
import random
from datetime import datetime

host_ip = 'mosquitto'
port = 1883 
keepalive = 60
topics = ['temp1', 'temp2', 'temp3', 'temp4']
client = mqtt.Client()
client.connect(host_ip, port, keepalive)
i = 0

while True:
    time.sleep(0.1)
    i+=1
    topic = random.choice(topics)
    message = "{\"created\": \"" + datetime.now().strftime("%Y-%m-%d %H:%M:%S") + "\",\"temperature\": {\"value\": " + str(round(random.uniform(19.5, 23.5),2)) + ",\"unit\": \"Celsius degree\"}}"
    if i <=1000:
        print("-----")
        print("Publish on topic: " + topic)
        print("Publish with msg: " + message)
        client.publish(topic, message)
    else:
        break

client.disconnect()
