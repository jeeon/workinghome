package test;

import java.net.*;
import java.io.*;

public class Client1 {
	public static void main(String[] args) {

		Socket client = null;

		try {
			System.out.println("�������� ������ �õ��մϴ�.");
			client = new Socket("127.0.0.1", 7775); // x1
			System.out.println("����Ǿ����ϴ�.");

		} 
		catch (Exception e) {
			System.out.println("���� ����..");
		} 
		
		finally {
			try {
				if (client != null)
					client.close();
			} 
			catch (IOException ie){}
		}
	}
}