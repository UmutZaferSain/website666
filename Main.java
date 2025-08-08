import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/", exchange -> {
            byte[] bytes = Files.readAllBytes(Paths.get("index.html"));
            exchange.getResponseHeaders().add("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        });

        server.createContext("/script.js", exchange -> {
            byte[] bytes = Files.readAllBytes(Paths.get("script.js"));
            exchange.getResponseHeaders().add("Content-Type", "application/javascript");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        });

        server.setExecutor(null);
        System.out.println("Server running at http://localhost:8000");
        server.start();
    }
}
