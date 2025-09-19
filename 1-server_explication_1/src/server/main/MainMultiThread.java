package server.main;

import server.util.MultiThread;

public class MainMultiThread {

	public static void main(String[] args) {
		MultiThreadServer();
	}

	public static void MultiThreadServer() {

		int ip = 9001;

		MultiThread mt = new MultiThread(ip);
		new Thread(mt).start();

		try {
			System.out.println("Server Started: " + ip);
			Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Stopping Server");
		mt.stop();

	}

}
