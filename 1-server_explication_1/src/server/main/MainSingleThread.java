package server.main;

import server.util.SingleThread;

public class MainSingleThread {

	public static void main(String[] args) {
		SingleThreadServer();
	}

	private static void SingleThreadServer() {

		int ip = 9000;

		SingleThread st = new SingleThread(ip);
		new Thread(st).start();

		try {
			System.out.println("Server Started: " + ip);
			Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Stopping Server");
		st.stop();
	}
}
