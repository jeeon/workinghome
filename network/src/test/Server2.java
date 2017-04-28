package test;

import java.net.*;
import java.io.*;

public class Server2 {
	private BufferedReader reader; 																// �Է��� ����Ѵ�.
	private ServerSocket server; 																// ��������
	private Socket socket; 																		// ����

	public Server2() {} 																		// ����Ʈ ������

	void startServer() { 																		// ���� ���� �޼ҵ�
		try {
			server = new ServerSocket(7775); 													// ���������� �����Ѵ�.
			System.out.println("���������� �����Ǿ����ϴ�.");
			while (true) {
				System.out.println("Ŭ���̾�Ʈ�� ��ٸ��ϴ�.");
				socket = server.accept(); 														// Ŭ���̾�Ʈ�� �����ϸ� socket�� �����Ѵ�.
				System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�.");

																								// socket�� �Է� ��Ʈ���� ��´�.
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getMessage(); // Ŭ���̾�Ʈ�� ���� �����͸� �о ȭ�鿡 ����Ѵ�.
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

	void getMessage() { 																		// �������κ��� �޽����� �д´�.
		try {
			while (true) { 																		// ���� ����
																								// ������ �Է� ��Ʈ�����κ��� �����͸� �� ������ �о ȭ�鿡 ����Ѵ�.
				System.out.println("Ŭ���̾�Ʈ: " + reader.readLine());

			}
		} 
		catch (Exception e) {
		} 

		finally {
			System.out.println("Ŭ���̾�Ʈ�� ������ �������ϴ�.");
			try {
				if (reader != null)
					reader.close(); 															// ������ �Է� ��Ʈ���� �ݴ´�.
				if (socket != null)
					socket.close(); 															// ������ �ݴ´�.
			} 
			catch (IOException ie) {}
		}
	}

	public static void main(String[] args) {
		Server2 server = new Server2();
		server.startServer();
	}
}
