package com.uy.lion.worldTakeover.pinky.loader;

import com.sun.net.httpserver.HttpServer;
import com.uy.lion.worldTakeover.pinky.api.HayParo;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.time.Instant;

/**
 * @author lion.
 * @since 11/10/16.
 */
public class Main {

    private static final int SLEEPING_TIME = Integer.MAX_VALUE;

    public static void main(String... args) {

        startServer(HayParo.class);
        startHayParo();
        keepRunning();

    }

    private static void startHayParo() {

        //FIXME [LION] Implement a better logger.
        System.out.println("Starting HayParo");
        new HayParo();
        System.out.println("HayParo started");
    }

    private static void keepRunning() {
        System.out.println("Started keepRunning");
        while (true) {
            try {
                System.out.println(String.format("%s : Taking a power nap.", Instant.now()));
                Thread.sleep(SLEEPING_TIME);//Integer.MAX_VALUE
                System.out.println(String.format("%s : Slept some long %d milliseconds", Instant.now(), SLEEPING_TIME));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void startServer(Class... classes) {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
        ResourceConfig config = create(classes);
        HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);

        Runnable runnable = () -> server.stop(0);
        Runtime.getRuntime().addShutdownHook(new Thread(runnable));
    }

    private static ResourceConfig create(Class... classes) {
        final ResourceConfig config = new ResourceConfig(classes);
        config.register(classes);
        config.property(ServerProperties.TRACING, "ON_DEMAND");
        return config;
    }
}
