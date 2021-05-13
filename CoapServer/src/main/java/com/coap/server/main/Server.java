package com.coap.server.main;

import java.net.SocketException;
import java.net.UnknownHostException;

import com.coap.server.main.mongo.MongoDBClient;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class Server extends CoapServer {

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.start();
        } catch (SocketException e) {
            System.err.println("Failed to initialize server: " + e.getMessage());
        } catch (UnknownHostException e) {
            System.err.println("Unknown mongodb host: " + e.getMessage());
        }
    }

    public Server() throws SocketException, UnknownHostException {
        add(new PublishResource());
    }

    static class PublishResource extends CoapResource {
        MongoDBClient mongoDBClient;
        public PublishResource() throws UnknownHostException {
            super("publish");
            mongoDBClient = new MongoDBClient();
            getAttributes().setTitle("Publish Resource");
        }
        public void handlePOST(CoapExchange exchange) {
            System.out.println(exchange.getRequestText());
            exchange.respond("POST_REQUEST_SUCCESS ");
        }
        public void handleGET(CoapExchange exchange) {
            exchange.respond(mongoDBClient.getDataFromSensors());
        }
    }
}
