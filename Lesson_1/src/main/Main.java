package main;

import Servlets.FirstServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        final ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        final String requestedFile = "/mirror";
        final FirstServlet firstServlet = new FirstServlet();
        context.addServlet(new ServletHolder(firstServlet), requestedFile);

        final Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        System.out.println("Server started");
        server.join();
    }
}
