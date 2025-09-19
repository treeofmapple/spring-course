package server.util;

import java.io.IOException;
import java.net.Socket;

public class SingleThread extends OperationsUsefull implements Runnable {
	
	public SingleThread(int port) {
		 this.serverPort = port;
	}
	
	@Override
	public void run() {
		synchronized (this) {
			this.runningThread = Thread.currentThread();
		}
		
		openServerSocket();
		
		while(!IsStopped()) {
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
			} catch (IOException e) {
				if(IsStopped()) {
					System.out.println("Server Stopped");
					return;
				}
				throw new RuntimeException("Error Accepting the connection", e);
			}
			try {
				processClientRequest(clientSocket);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println("Server Stopped");
	}
	
}

