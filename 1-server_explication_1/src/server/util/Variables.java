package server.util;

import java.net.ServerSocket;

public abstract class Variables {

	protected int serverPort = 8080;
	protected ServerSocket serverSocket = null;
	protected boolean isStopped = false;
	protected Thread runningThread = null;
	
}
