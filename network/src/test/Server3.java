package test;

import java.net.*;
import java.io.*;

public class Server3 {
	private DataInputStream reader; 										// �Է� ��Ʈ��
	private DataOutputStream writer; 										// ��� ��Ʈ��
	private ServerSocket server;  											// ��������
	private Socket socket;  												// ����

	public Server3() {}

	void startServer() { 													// ������ ���۽�Ų��.
		try {
			server = new ServerSocket(7775);
			System.out.println("���������� �����Ǿ����ϴ�.");
			
			while (true) {
				System.out.println("Ŭ���̾�Ʈ�� ��ٸ��ϴ�.");
				socket = server.accept();
				System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�.");

																			// socket�� �Է� ��Ʈ���� ��� ��Ʈ���� ��´�.
				reader = new DataInputStream(socket.getInputStream());
				writer = new DataOutputStream(socket.getOutputStream());

				getCommand(); 												// Ŭ���̾�Ʈ�� ����Ѵ�.
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

	// Ŭ���̾�Ʈ�� ��û�� ������ �����ϴ� �޼ҵ�
	void getCommand() {

		try {
			while (true) {
				String fileName = reader.readUTF(); 						// �����̸��� ��´�.

														
				writer.writeUTF(getFileInfo(fileName));						// �ش� ������ ������ Ŭ���̾�Ʈ ���� �������� �����Ѵ�.
				writer.flush();

				System.out.println(fileName + "�� ���� ���� �Ϸ�");
			}
		} 
		catch (Exception e) {}
		
		finally {
			System.out.println("Ŭ���̾�Ʈ���� ������ ������ϴ�.");

			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
				if (socket != null)
					socket.close();
				reader = null;
				writer = null;
				socket = null;
			} 
			catch (IOException ie) {}
		}
	}

	
	// fileName�� �ش��ϴ� ������ ������ ��ȯ�ϴ� �޼ҵ�
	String getFileInfo(String fileName) {
		String fileInfo = "";
		
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String temp;
			while ((temp = br.readLine()) != null)
				fileInfo += temp + "\n";
			br.close();
		} 
		catch (FileNotFoundException fe) {
			fileInfo = "������ �����ϴ�.";
		} 
		catch (IOException ie) {
		}
		return fileInfo;
	}

	public static void main(String[] args) {
		Server3 server = new Server3();
		server.startServer();
	}
}