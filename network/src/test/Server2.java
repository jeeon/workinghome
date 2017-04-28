package test;

import java.net.*;
import java.io.*;

public class Server2 {
	private BufferedReader reader; 																// 입력을 담당한다.
	private ServerSocket server; 																// 서버소켓
	private Socket socket; 																		// 소켓

	public Server2() {} 																		// 디폴트 생성자

	void startServer() { 																		// 서버 실행 메소드
		try {
			server = new ServerSocket(7775); 													// 서버소켓을 생성한다.
			System.out.println("서버소켓이 생성되었습니다.");
			while (true) {
				System.out.println("클라이언트를 기다립니다.");
				socket = server.accept(); 														// 클라이언트가 접속하면 socket과 연결한다.
				System.out.println("클라이언트와 연결되었습니다.");

																								// socket의 입력 스트림을 얻는다.
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getMessage(); // 클라이언트가 보낸 데이터를 읽어서 화면에 출력한다.
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

	void getMessage() { 																		// 소켓으로부터 메시지를 읽는다.
		try {
			while (true) { 																		// 무한 루프
																								// 소켓의 입력 스트림으로부터 데이터를 한 라인을 읽어서 화면에 출력한다.
				System.out.println("클라이언트: " + reader.readLine());

			}
		} 
		catch (Exception e) {
		} 

		finally {
			System.out.println("클라이언트가 연결을 끊었습니다.");
			try {
				if (reader != null)
					reader.close(); 															// 소켓의 입력 스트림을 닫는다.
				if (socket != null)
					socket.close(); 															// 소켓을 닫는다.
			} 
			catch (IOException ie) {}
		}
	}

	public static void main(String[] args) {
		Server2 server = new Server2();
		server.startServer();
	}
}
