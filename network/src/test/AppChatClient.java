package test;

import java.awt.*;
import java.applet.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;

// Server5.java �� ����!!!! 

public class AppChatClient extends Applet implements Runnable {
	private TextField nameBox = new TextField("<�̸�>");
	private TextArea msgView = new TextArea();
	private TextField sendBox = new TextField();
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket socket;
	private Thread chatThread;
	private boolean loop = true; 															// �����带 ���߰� �ϴ� ����


	public void init() { 																	// ���ø� �ʱ�ȭ
		msgView.setEditable(false);
		setLayout(new BorderLayout());
		add(nameBox, "North");
		add(msgView, "Center");
		add(sendBox, "South");
		sendBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					writer.println(nameBox.getText() + " : " + sendBox.getText());
					sendBox.setText("");
				} 
				catch (Exception ie) {}
			}
		});
	}

	
	public void run() {
		while (loop) { 																		// loop�� false�� �Ǹ� �����尡 �����.
			try {
				msgView.append(reader.readLine() + "\n");
			} catch (IOException ie) {
			}
		}
	}

	
	public void start() { 																	// ���ø� ����
		try {
			msgView.append("�������ϰ��� ������ �õ��մϴ�.\n");
			socket = new Socket("127.0.0.1", 7777);
			msgView.append("ä�� �غ� �Ϸ�Ǿ����ϴ�.\n");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			chatThread = new Thread(this);
			chatThread.start();
		} 
		catch (Exception e) {
			msgView.append("���� ����..");
		}
	}

	
	private void stopThread() { 															// �����带 ���߰� �Ѵ�.
		loop = false;
	}


	public void stop() { 																	// ���ø� ������ ���߰� �Ѵ�.
		stopThread();
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