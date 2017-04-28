package test;

import java.net.*;
import java.io.*;
import java.util.*;


public class Server4 {
	private ServerSocket server;
	Vector sManager = new Vector(); 													// ������ �����ϴ� ����
	Random rnd = new Random(); 															// ������ �����ϴ� ����

	public Server4() {
	}

	void startServer() {
		try {
			server = new ServerSocket(7777);
			System.out.println("���������� �����Ǿ����ϴ�.");
			while (true) {
				Socket socket = server.accept();
				System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�.");


				new KBBCom_Thread(socket).start();										// Ŭ���̾�Ʈ�� ����ϴ� �����带 �����ϰ� �����Ų��.


				sManager.add(socket);													// ���� ������ ����Ʈ�� ������ �߰��Ѵ�.


				System.out.println("���� Ŭ���̾�Ʈ ��: " + sManager.size());					// ���� �����ϰ� �ִ� Ŭ���̾�Ʈ�� ���� ȭ�鿡 ����Ѵ�.
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		Server4 server = new Server4();
		server.startServer(); 															// ������ �����Ѵ�.
	}

	

	// Ŭ���̾�Ʈ�� ����ϴ� ������ Ŭ����
	class KBBCom_Thread extends Thread {
		Socket socket; 																	// ������ ���۷���
		private DataInputStream reader; 												// ������ �Է� ��Ʈ��
		private DataOutputStream writer; 												// ������ ��� ��Ʈ��

		KBBCom_Thread(Socket socket) { 													// ������
			this.socket = socket;
		}

		public void run() {
			try {


				reader = new DataInputStream(socket.getInputStream());					// ������ �ԡ���� ��Ʈ���� ��´�.
				writer = new DataOutputStream(socket.getOutputStream());

				String msg;

				while ((msg = reader.readUTF()) != null) {								// �Է� ��Ʈ�����κ��� �޽����� ��´�.
					if (msg.equals("OK")) { 											// ���� �޽����� "OK"�̸�


						writer.writeInt(rnd.nextInt(3));								// 0���� 2������ ������ ������ Ŭ���̾�Ʈ�� �����Ѵ�.
						writer.flush();
					}
				}
			} 
			catch (Exception e) {} 
			finally { 																	// Ŭ���̾�Ʈ�� ������ ������ ���� ó��
				try {
					sManager.remove(socket); 											// ���� ������ ����Ʈ���� ������ �����Ѵ�.

																						// �ԡ���� ��Ʈ���� ������ �ݴ´�.
					if (reader != null)
						reader.close();
					if (writer != null)
						writer.close();
					if (socket != null)
						socket.close();

					reader = null;
					writer = null;
					socket = null;

																						// ������ ������ ȭ�鿡 ����Ѵ�.
					System.out.println("Ŭ���̾�Ʈ�� �������ϴ�.");
					System.out.println("���� Ŭ���̾�Ʈ ��: " + sManager.size());
				} catch (Exception e) {
				}
			}
		}
	}
}