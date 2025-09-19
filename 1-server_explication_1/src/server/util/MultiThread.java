package server.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MultiThread extends OperationsUsefull implements Runnable {

	public MultiThread(int port) {
		this.serverPort = port;
	}
	
	@Override
	public void run() {
		synchronized (this) {
			this.runningThread = Thread.currentThread();
		}

		openServerSocket();
		while (!IsStopped()) {
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
			} catch (IOException e) {
				if (IsStopped()) {
					System.out.println("Server Stopped.");
					return;
				}
				throw new RuntimeException("Error accepting client connection", e);
			}
			new Thread(new MultiWorkerRunnable(clientSocket, "Multithreaded Server")).start();
		}
		System.out.println("Server Stopped.");
	}

}

class MultiWorkerRunnable extends OperationsUsefull implements Runnable {
	
	protected Socket clientSocket = null;
	protected String serverText = null;
	
	public MultiWorkerRunnable(Socket clientSocket, String serverText) {
		this.clientSocket = clientSocket;
		this.serverText = serverText;
	}
	
	@Override
	public void run() {
		try {
			InputStream input = clientSocket.getInputStream();
			OutputStream output = clientSocket.getOutputStream();
			long time = System.currentTimeMillis();
			
			byte[] responseDocument = (
					"HTTP/1.1 200 OK\n\nWorkerRunnable: " +
					this.serverText + " - " + time + "").getBytes("UTF-8"); 
			
			output.write(responseDocument);
			output.close();
			input.close();
			System.out.println("Request processed: " + time);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}

