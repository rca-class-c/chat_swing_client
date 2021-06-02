package socket;
import models.Request;

import java.io.*;
import java.net.Socket;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ResponseDataSuccessDecoder;
import models.UserResponseDataDecoder;
import utils.CommonUtil;
import utils.ConsoleColor;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;

public class WriteThread extends Thread {
    private PrintWriter writer;
    private BufferedReader reader;
    private Socket socket;
    private IndexSocket client;
    private Request request;
    private ObjectMapper objectMapper;
    private JsonNode data;
    public WriteThread(Socket socket, IndexSocket client, Request request) {
        this.socket = socket;
        this.client = client;
        this.request = request;
        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public JsonNode run(Socket socket) {
        try {
            objectMapper = new ObjectMapper();
            String LoginDataAsString = objectMapper.writeValueAsString(request);
            writer.println(LoginDataAsString);
            ResponseDataSuccessDecoder response = new UserResponseDataDecoder().decodedResponse(reader.readLine());
            data = objectMapper.readTree(response.getData());
            socket.close();
            return data;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }
}
