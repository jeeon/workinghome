package test;

import java.net.*;
import java.io.*;

public class Server1 {
	public static void main(String[] args) {
		ServerSocket server = null;

		try {

			server = new ServerSocket(7775); 						// 7775번 포트를 사용하는 서버소켓 객체를 생성 아래에 추가 설명
			System.out.println("서버소켓이 생성되었습니다.");

			while (true) { 											
				System.out.println("클라이언트를 기다립니다.");
				Socket newSocket = server.accept(); 				// accept 메소드에 의해 클라이언트가 접속해 오도록 기다린다.
				System.out.println("클라이언트와 연결되었습니다.");
			} 														// 클라이언트가 접속해오면 newSocket과 연결시키고 자신은 while 문을 돌면서 기다림과 소켓 연결을 반복
		} 
		catch (IOException ie) {
			System.out.println(ie);									
		} 
		
		finally {
			
			try {
				if (server != null)
					server.close(); 								// 서버소켓을 닫고 있다. 실제로 접속해오는 클라이언트가 없기 때문에 출력결과와 같이 서버소켓은 계속해서 기다리고 있다.
			} 
			catch (IOException ie) {
			}
		}
	}
}

//21번이나 80번과 같은 포트들은 잘 알려진 포트들(Well Known Ports)이고, 
//이와 같이 시스템에서 사용하는 예약된 포트들이 있는데 1~1023 사이의 포트들이다. 
//따라서 이들 포트는 사용하지 않고 1024~65535 사이의 포트를 사용하는 것이 좋다.


