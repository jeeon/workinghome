package test;

import java.net.*;

public class IpAddress1 {
	public static void main(String[] args) {
		InetAddress ip = null;
		try {

			ip = InetAddress.getByName("naver.com");												// ���ϴ� ���ͳ� ������ �Է�.
			System.out.println("ȣ��Ʈ �̸�: " + ip.getHostName());										// �̸�.
			System.out.println("ȣ��Ʈ IP �ּ�: " + ip.getHostAddress());								// ip �ּ� ���
			System.out.println("����ȣ��Ʈ IP �ּ�: " + InetAddress.getLocalHost().getHostAddress());	// ���� �����⿡�� �Ҵ� ���� �ּ�. 

		} 
		catch (UnknownHostException ue) {

			System.out.println(ue);
		}
	}
}
