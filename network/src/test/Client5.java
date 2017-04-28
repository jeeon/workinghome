package test;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;

public class Client5 extends Frame implements Runnable {
	private TextField nameBox = new TextField("�ڸ��"); 															// ����� �̸��� ��Ÿ����.
	private TextArea msgView = new TextArea();
	private TextField sendBox = new TextField();
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket socket;

	
	public Client5(String title) {
		super(title);
		msgView.setEditable(false);

		
																												// ��Ʈ�ѵ��� ��ġ�Ѵ�.	
		add(nameBox, "North");
		add(msgView, "Center");
		add(sendBox, "South");

		
		// sendBox �׼� �̺�Ʈ ó��
		sendBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					writer.println(nameBox.getText() + " : " + sendBox.getText());								// ������� �̸��� �޽��� ������ �����Ѵ�.
					sendBox.setText(""); 																		// sendBox�� ������ �����.
				} 
				catch (Exception ie) {}
			}
		});
		pack();
	}

	
	public void run() {
		while (true) {
			try {
				// �Է� ��Ʈ�����κ��� �����͸� �о msgView�� �߰��Ѵ�.
				msgView.append(reader.readLine() + "\n");
			} 
			catch (IOException ie) {}
		}
	}


	private void connect() {
		try {
			msgView.append("�������ϰ��� ������ �õ��մϴ�.\n");
			socket = new Socket("127.0.0.1", 7777);
			msgView.append("ä�� �غ� �Ϸ�Ǿ����ϴ�.\n");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);

			new Thread(this).start();

		} 
		catch (Exception e) {
			msgView.append("���� ����..");
		}
	}

	
	public static void main(String[] args) {
		Client5 client = new Client5("ä��");
		client.setVisible(true);
		client.connect();
	}
}