package test;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server5 {
	private ServerSocket server;
	private BManager bMan = new BManager(); 														// �޽��� ����� ���� �޼����� �ٸ� Ŭ���̾�Ʈ���� �Ѹ�.

	
	public Server5() {}

	
	void startServer() {
		try {
			server = new ServerSocket(7777);
			System.out.println("���������� �����Ǿ����ϴ�.");

			while (true) {
				Socket socket = server.accept();

				new Chat_Thread(socket).start(); 													// Ŭ���̾�Ʈ�� ����ϴ� �����带 �����ϰ� �����Ų��.
				bMan.add(socket); 																	// ������� ����Ʈ�� socket�� �߰��Ѵ�.
				bMan.sendClientInfo(socket); 																// ����ڴ� ��� Ŭ���̾�Ʈ���� ���� ���� �ο��� ���� �����Ѵ�.
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	

	public static void main(String[] args) {
		Server5 server = new Server5();
		server.startServer();
	}

	
	// Ŭ���̾�Ʈ�� ����ϴ� ������ Ŭ����
	class Chat_Thread extends Thread {
		Socket socket;
		private BufferedReader reader;
		private PrintWriter writer;

		Chat_Thread(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);
				String msg;

				while ((msg = reader.readLine()) != null){ 											// �Է� ��Ʈ�����κ��� �޽����� ��´�.															
					System.out.println(msg);
					bMan.sendToAll(msg); 															// ��� Ŭ���̾�Ʈ���� �޽����� �����Ѵ�.
				}

			} 
			catch (Exception e) {} 
			finally {

				try {

					bMan.remove(socket); 															// ������� ����Ʈ���� socket�� �����Ѵ�.

					if (reader != null)
						reader.close();
					if (writer != null)
						writer.close();
					if (socket != null)
						socket.close();

					reader = null;
					writer = null;
					socket = null;

					System.out.println("Ŭ���̾�Ʈ�� �������ϴ�.");

					bMan.sendClientInfo(socket); 															// ��� Ŭ���̾�Ʈ���� ���� ���� �ο��� ���� �����Ѵ�.
				} 
				catch (Exception e) {}

			}
		}
	}

	class BManager extends Vector { 																// �޽��� ����� Ŭ����, Vector�� ����Ѵ�.

		BManager(){}

		void add(Socket sock) { 																	// ������ �߰��Ѵ�.
			super.add(sock);
		}

		void remove(Socket sock) { 																	// ������ �����Ѵ�.
			super.remove(sock);
		}

		synchronized void sendToAll(String msg) { 													// ��� Ŭ���̾�Ʈ���� msg�� �����Ѵ�. ����ȭ �޼ҵ�

			PrintWriter writer = null; 																// ��� ��Ʈ��
			Socket sock; 																			// ����

			for (int i = 0; i < size(); i++) { 														// ������ ������ŭ �ݺ� ����
				sock = (Socket) elementAt(i); 														// i��° ������ ��´�.

				try {
					writer = new PrintWriter(sock.getOutputStream(), true);							// i��° ������ ��� ��Ʈ���� ��´�.
				} 
				catch (IOException ie) {}


				if (writer != null)																	// i��° ������ ��� ��Ʈ������ msg�� ����Ѵ�.
					writer.println(msg);
			}
		}


		synchronized void sendClientInfo(Socket sock) {														// ��� Ŭ���̾�Ʈ���� ���� ä�� �ο��� ���� �����Ѵ�.
			String info = "���� ä�� �ο�: " + size() + sock.toString() ;
			System.out.println(info);
			sendToAll(info);
		}
	}
}