package test;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;

public class Client2 extends Frame {
	private TextArea msgView = new TextArea(); 												// �޽����� �����ִ� �ؽ�Ʈ����
	private TextField sendBox = new TextField(); 											// ���ڿ��� �Է��ϴ� �ؽ�Ʈ�ʵ�
	private PrintWriter writer; 															// ������ ��� ��Ʈ��
	Socket socket; 																			// ����

	public Client2(String title) { 															// ������
		super(title);
		msgView.setEditable(false); 														// �ؽ�Ʈ������ ����ڰ� ������ �� ������ �Ѵ�.
		add(msgView, "North"); 																// ������Ʈ ��ġ
		add(sendBox, "South");
																							

		sendBox.addActionListener(new ActionListener() {									// sendBox�� ���ڿ��� �Է��ϰ� ���͸� ������
			public void actionPerformed(ActionEvent ae) {									// ���ڿ��� �����Ѵ�.
																							
				writer.println(sendBox.getText());											// sendBox�� ���ڿ��� ��� ��Ʈ������ �����Ѵ�.
				
				msgView.append(sendBox.getText() + "\n");									// msgView�� ���� ���ڿ��� �߰��Ѵ�.
				
				sendBox.setText("");														// sendBox�� ������ �����.
			}
		});
		pack(); 																			// �������� ũ�⸦ �ڵ����� �����.
	}

	
	
	private void connect() { 																// ������ �����ϴ� �޼ҵ�
		try {
			msgView.append("�������� ������ �õ��մϴ�.\n");
			socket = new Socket("127.0.0.1", 7775);
			msgView.append("����Ǿ����ϴ�. ������ ���ڿ��� �Է��ϼ���.\n");

			writer = new PrintWriter(socket.getOutputStream(), true);						// socket�� ��� ��Ʈ���� ��´�.

		} 
		catch (Exception e) {
			msgView.append("���� ����..");
		}
	}


	public static void main(String[] args) {
		Client2 client = new Client2("������ ������ ������");
		client.setVisible(true);
		client.connect();
	}
}