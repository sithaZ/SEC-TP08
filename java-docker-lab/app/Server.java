import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) throws IOException {
        // Create a server on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        
        server.createContext("/", new MyHandler());
        
        server.setExecutor(null); 
        System.out.println("Java Server started on port 8080...");
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException { 
            String response = "Hello from Java Container! The Banking System is Active.";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}