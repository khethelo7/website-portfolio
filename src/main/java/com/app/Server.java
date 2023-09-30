package com.app;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

/**
 * Server
 */
public class Server {

    private static final String PAGES_DIR = "/public";

    private final Javalin appServer;

    public Server() {
        appServer = Javalin.create(config -> config.addStaticFiles(PAGES_DIR, Location.CLASSPATH));
    }

    public void start(int portNumber) {
        this.appServer.start(portNumber);
    }

    public void stop() {
        this.appServer.stop();
    }

    public int port() {
        return this.appServer.port();
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start(5000);
    }
}