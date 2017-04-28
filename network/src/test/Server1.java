package test;

import java.net.*;
import java.io.*;

public class Server1 {
	public static void main(String[] args) {
		ServerSocket server = null;

		try {

			server = new ServerSocket(7775); 						// 7775�� ��Ʈ�� ����ϴ� �������� ��ü�� ���� �Ʒ��� �߰� ����
			System.out.println("���������� �����Ǿ����ϴ�.");

			while (true) { 											
				System.out.println("Ŭ���̾�Ʈ�� ��ٸ��ϴ�.");
				Socket newSocket = server.accept(); 				// accept �޼ҵ忡 ���� Ŭ���̾�Ʈ�� ������ ������ ��ٸ���.
				System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�.");
			} 														// Ŭ���̾�Ʈ�� �����ؿ��� newSocket�� �����Ű�� �ڽ��� while ���� ���鼭 ��ٸ��� ���� ������ �ݺ�
		} 
		catch (IOException ie) {
			System.out.println(ie);									
		} 
		
		finally {
			
			try {
				if (server != null)
					server.close(); 								// ���������� �ݰ� �ִ�. ������ �����ؿ��� Ŭ���̾�Ʈ�� ���� ������ ��°���� ���� ���������� ����ؼ� ��ٸ��� �ִ�.
			} 
			catch (IOException ie) {
			}
		}
	}
}

//21���̳� 80���� ���� ��Ʈ���� �� �˷��� ��Ʈ��(Well Known Ports)�̰�, 
//�̿� ���� �ý��ۿ��� ����ϴ� ����� ��Ʈ���� �ִµ� 1~1023 ������ ��Ʈ���̴�. 
//���� �̵� ��Ʈ�� ������� �ʰ� 1024~65535 ������ ��Ʈ�� ����ϴ� ���� ����.


