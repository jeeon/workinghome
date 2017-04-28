package test;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;


public class Client3 extends Frame {
	private TextArea msgView = new TextArea(); 											// 파일을 보여주는 텍스트영역
	private TextField sendBox = new TextField(); 										// 파일이름을 입력하는 텍스트필드
	private DataInputStream reader; 													// 입력 스트림
	private DataOutputStream writer; 													// 출력 스트림
	Socket socket; 																		// 소킷

	
	public Client3(String title) { 														// 생성자
		super(title);
		msgView.setEditable(false);
		add(msgView, "Center");
		add(sendBox, "South");

																						// sendBox 액션 이벤트 처리
		sendBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {

					writer.writeUTF(sendBox.getText());									// 파일이름을 서버로 전송한다.
					writer.flush();


					String fileInfo = reader.readUTF();									// 소켓의 입력 스트림으로부터 파일의 내용을 얻는다.
					msgView.setText("< " + sendBox.getText() + "의 내용 >\n\n");
					msgView.append(fileInfo);

					sendBox.setText("");
				} 
				catch (Exception ie) {}
			}
		});
		pack();
	}


	private void connect() { 															// 서버와 연결하는 메소드
		try {
			msgView.append("서버와의 연결을 시도합니다.\n");
			socket = new Socket("127.0.0.1", 7775);
			msgView.append("연결 완료... 보고싶은 파일의 이름을 입력하세요.\n");

																						// 소켓의 입·출력 스트림을 얻는다.
			reader = new DataInputStream(socket.getInputStream());
			writer = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			msgView.append("연결 실패..");
		}
	}

	public static void main(String[] args) {
		Client3 client = new Client3("서버 시스템 파일 보기");
		client.setVisible(true);
		client.connect(); 																// 서버와 연결한다.
	}
}
