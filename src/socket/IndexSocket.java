package socket;

import com.fasterxml.jackson.databind.JsonNode;
import models.Request;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class IndexSocket {
    private JsonNode data;
    private String hostname = "localhost";
    private int port=9812;
    public JsonNode execute() {
        try {
            Socket socket = new Socket(hostname, port);
            System.out.println("Connected to Server Successfully");
            System.out.println();

            data = new socket.WriteThread(socket, this,new Request()).run(socket);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return data;
    }
}
