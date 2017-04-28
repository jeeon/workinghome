package test;

import java.net.*;

public class IpAddress1 {
	public static void main(String[] args) {
		InetAddress ip = null;
		try {

			ip = InetAddress.getByName("naver.com");												// 원하는 인터넷 도메인 입력.
			System.out.println("호스트 이름: " + ip.getHostName());										// 이름.
			System.out.println("호스트 IP 주소: " + ip.getHostAddress());								// ip 주소 출력
			System.out.println("로컬호스트 IP 주소: " + InetAddress.getLocalHost().getHostAddress());	// 내가 공유기에서 할당 받은 주소. 

		} 
		catch (UnknownHostException ue) {

			System.out.println(ue);
		}
	}
}
