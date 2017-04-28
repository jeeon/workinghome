package test;

import java.awt.*;
import java.applet.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;

// Server5.java 와 연동!!!! 

public class AppChatClient extends Applet implements Runnable {
	private TextField nameBox = new TextField("<이름>");
	private TextArea msgView = new TextArea();
	private TextField sendBox = new TextField();
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket socket;
	private Thread chatThread;
	private boolean loop = true; 															// 스레드를 멈추게 하는 변수


	public void init() { 																	// 애플릿 초기화
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
		while (loop) { 																		// loop가 false로 되면 스레드가 멈춘다.
			try {
				msgView.append(reader.readLine() + "\n");
			} catch (IOException ie) {
			}
		}
	}

	
	public void start() { 																	// 애플릿 시작
		try {
			msgView.append("서버소켓과의 연결을 시도합니다.\n");
			socket = new Socket("127.0.0.1", 7777);
			msgView.append("채팅 준비가 완료되었습니다.\n");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			chatThread = new Thread(this);
			chatThread.start();
		} 
		catch (Exception e) {
			msgView.append("연결 실패..");
		}
	}

	
	private void stopThread() { 															// 스레드를 멈추게 한다.
		loop = false;
	}


	public void stop() { 																	// 애플릿 실행을 멈추게 한다.
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