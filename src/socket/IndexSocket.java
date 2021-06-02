package socket;

import com.fasterxml.jackson.databind.JsonNode;
import models.Request;
import models.ResponseDataSuccessDecoder;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class IndexSocket {
    private ResponseDataSuccessDecoder response;
    private String hostname = "localhost";
    private int port=9812;
    public ResponseDataSuccessDecoder execute(Request request) {
        try {
            Socket socket = new Socket(hostname, port);
            System.out.println("Connected to Server Successfully");
            System.out.println();

<<<<<<< HEAD
            data = new socket.WriteThread(socket, this,new Request()).run(socket);
            return data;
=======
            response = new socket.WriteThread(socket, this,request).run(socket);
>>>>>>> 87aff286c8e9b1b74b15773c0d3f2c425dcd59e1
        } catch (UnknownHostException ex) {
            System.out.println("Server not found");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return response;
    }
}
