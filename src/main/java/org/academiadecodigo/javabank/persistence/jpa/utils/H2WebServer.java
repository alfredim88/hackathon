package org.academiadecodigo.javabank.persistence.jpa.utils;

import org.h2.tools.Server;

import java.sql.SQLException;

public class H2WebServer {
    /**
     * Embedded Web interface for managing H2 databases, available in the development environment.
     */

    private Server server;

    /**
     * Creates a new {@code H2WebServer}
     *
     * @throws SQLException if the server cannot be created
     */
    public H2WebServer() throws SQLException {
        server = Server.createWebServer("-web", "-webAllowOthers", "-webDaemon", "-webPort", "8080");
    }

    /**
     * Starts the server
     *
     * @throws SQLException if the server cannot be started
     */
    public void start() throws SQLException {

        if (server != null) {
            server.start();
        }
    }

    /**
     * Stops the server
     */
    public void stop() {

        if (server != null) {
            server.stop();
        }
    }
}
