package test;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server5 {
	private ServerSocket server;
	private BManager bMan = new BManager(); 														// 메시지 방송자 받은 메세지를 다른 클라이언트에게 뿌림.

	
	public Server5() {}

	
	void startServer() {
		try {
			server = new ServerSocket(7777);
			System.out.println("서버소켓이 생성되었습니다.");

			while (true) {
				Socket socket = server.accept();

				new Chat_Thread(socket).start(); 													// 클라이언트와 통신하는 스레드를 생성하고 실행시킨다.
				bMan.add(socket); 																	// 방송자의 리스트에 socket을 추가한다.
				bMan.sendClientInfo(socket); 																// 방송자는 모든 클라이언트에게 현재 접속 인원의 수를 전송한다.
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	

	public static void main(String[] args) {
		Server5 server = new Server5();
		server.startServer();
	}

	
	// 클라이언트와 통신하는 스레드 클래스
	class Chat_Thread extends Thread {
		Socket socket;
		private BufferedReader reader;
		private PrintWriter writer;

		Chat_Thread(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);
				String msg;

				while ((msg = reader.readLine()) != null){ 											// 입력 스트림으로부터 메시지를 얻는다.															
					System.out.println(msg);
					bMan.sendToAll(msg); 															// 모든 클라이언트에게 메시지를 전송한다.
				}

			} 
			catch (Exception e) {} 
			finally {

				try {

					bMan.remove(socket); 															// 방송자의 리스트에서 socket을 제거한다.

					if (reader != null)
						reader.close();
					if (writer != null)
						writer.close();
					if (socket != null)
						socket.close();

					reader = null;
					writer = null;
					socket = null;

					System.out.println("클라이언트가 나갔습니다.");

					bMan.sendClientInfo(socket); 															// 모든 클라이언트에게 현재 접속 인원의 수를 전송한다.
				} 
				catch (Exception e) {}

			}
		}
	}

	class BManager extends Vector { 																// 메시지 방송자 클래스, Vector를 상속한다.

		BManager(){}

		void add(Socket sock) { 																	// 소켓을 추가한다.
			super.add(sock);
		}

		void remove(Socket sock) { 																	// 소켓을 제거한다.
			super.remove(sock);
		}

		synchronized void sendToAll(String msg) { 													// 모든 클라이언트에게 msg를 전송한다. 동기화 메소드

			PrintWriter writer = null; 																// 출력 스트림
			Socket sock; 																			// 소켓

			for (int i = 0; i < size(); i++) { 														// 소켓의 개수만큼 반복 실행
				sock = (Socket) elementAt(i); 														// i번째 소켓을 얻는다.

				try {
					writer = new PrintWriter(sock.getOutputStream(), true);							// i번째 소켓의 출력 스트림을 얻는다.
				} 
				catch (IOException ie) {}


				if (writer != null)																	// i번째 소켓의 출력 스트림으로 msg를 출력한다.
					writer.println(msg);
			}
		}


		synchronized void sendClientInfo(Socket sock) {														// 모든 클라이언트에게 현재 채팅 인원의 수를 전송한다.
			String info = "현재 채팅 인원: " + size() + sock.toString() ;
			System.out.println(info);
			sendToAll(info);
		}
	}
}