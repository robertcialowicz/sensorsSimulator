FROM python:3

RUN mkdir /app
WORKDIR /app
COPY ./app.py ./app/

RUN pip install paho-mqtt

CMD ["python","./app/app.py"]
