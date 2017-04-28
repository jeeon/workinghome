package test;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;


public class Client3 extends Frame {
	private TextArea msgView = new TextArea(); 											// ������ �����ִ� �ؽ�Ʈ����
	private TextField sendBox = new TextField(); 										// �����̸��� �Է��ϴ� �ؽ�Ʈ�ʵ�
	private DataInputStream reader; 													// �Է� ��Ʈ��
	private DataOutputStream writer; 													// ��� ��Ʈ��
	Socket socket; 																		// ��Ŷ

	
	public Client3(String title) { 														// ������
		super(title);
		msgView.setEditable(false);
		add(msgView, "Center");
		add(sendBox, "South");

																						// sendBox �׼� �̺�Ʈ ó��
		sendBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {

					writer.writeUTF(sendBox.getText());									// �����̸��� ������ �����Ѵ�.
					writer.flush();


					String fileInfo = reader.readUTF();									// ������ �Է� ��Ʈ�����κ��� ������ ������ ��´�.
					msgView.setText("< " + sendBox.getText() + "�� ���� >\n\n");
					msgView.append(fileInfo);

					sendBox.setText("");
				} 
				catch (Exception ie) {}
			}
		});
		pack();
	}


	private void connect() { 															// ������ �����ϴ� �޼ҵ�
		try {
			msgView.append("�������� ������ �õ��մϴ�.\n");
			socket = new Socket("127.0.0.1", 7775);
			msgView.append("���� �Ϸ�... ������� ������ �̸��� �Է��ϼ���.\n");

																						// ������ �ԡ���� ��Ʈ���� ��´�.
			reader = new DataInputStream(socket.getInputStream());
			writer = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			msgView.append("���� ����..");
		}
	}

	public static void main(String[] args) {
		Client3 client = new Client3("���� �ý��� ���� ����");
		client.setVisible(true);
		client.connect(); 																// ������ �����Ѵ�.
	}
}
