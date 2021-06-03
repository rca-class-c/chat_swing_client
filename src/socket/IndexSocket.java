package socket;

import models.Request;
import models.ResponseDataSuccessDecoder;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class IndexSocket {
    private ResponseDataSuccessDecoder response;
    private String hostname = "192.168.0.90";
    private int port=9812;
    public ResponseDataSuccessDecoder execute(Request request) {
        try {
            Socket socket = new Socket(hostname, port);
            System.out.println("Connected to Server Successfully");
            System.out.println();

            response = new socket.WriteThread(socket, this,request).run(socket);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return response;
    }
}
