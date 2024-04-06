package org.arep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static spark.Spark.*;

public class ServerProxy {
    private static final List<String> SERVERS = new ArrayList<>(Arrays.asList("http://3.80.69.181:4567/", "http://54.221.15.221:4567/"));
    private static int INDEX_SERVER = 0;

    public static void main(String... args) {
        staticFiles.location("/public");
        port(getPort());

        get("/linear", (req,res) -> {
            res.type("application/json");
            String value = req.queryParams("value");
            String list = req.queryParams("list");
            String operation = rotateRoundRobinServer("linear");
            System.out.println(operation);
            return HttpConnection.connection(operation  + "?list=" + list + "&value=" + value);

        });

        get("/binary", (req,res) -> {
            res.type("application/json");
            String value = req.queryParams("value");
            String list = req.queryParams("list");
            String operation = rotateRoundRobinServer("binary");
            return HttpConnection.connection(operation  + "?list=" + list + "&value=" + value);
        });
    }

    public static String rotateRoundRobinServer(String operation) {

        INDEX_SERVER = (INDEX_SERVER + 1) % SERVERS.size();
        System.out.println(SERVERS.get(INDEX_SERVER));
        return SERVERS.get(INDEX_SERVER) + operation;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4569;
    }
}