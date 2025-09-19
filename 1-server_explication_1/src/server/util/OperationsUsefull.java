package server.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OperationsUsefull extends Variables {

	public void processClientRequest(Socket clientSocket) throws Exception {
        InputStream  input  = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();
        long time = System.currentTimeMillis();

        byte[] responseDocument = ("<html><body>" +
                "Singlethreaded Server: " +
                time +
                "</body></html>").getBytes("UTF-8");

        byte[] responseHeader = ("HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html; charset=UTF-8\r\n" +
                "Content-Length: " + responseDocument.length +
                "\r\n\r\n").getBytes("UTF-8");
        
        output.write(responseHeader);
        output.write(responseDocument);
        output.close();
        input.close();
        System.out.println("Request processed: " + time);
	}
	
	protected void openServerSocket() {
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		} catch(IOException e) {
			throw new RuntimeException("Cannot open port " + serverPort, e);
		}
	}

	public synchronized void stop() {
		this.isStopped = true;
		try {
			this.serverSocket.close();
		} catch(IOException e) {
			throw new RuntimeException("Error closing server", e);
		}
	}
	
	public synchronized boolean IsStopped() {
		return this.isStopped;
	}
	
}
