package test;

import java.net.*;
import java.io.*;

public class Client1 {
	public static void main(String[] args) {

		Socket client = null;

		try {
			System.out.println("서버와의 연결을 시도합니다.");
			client = new Socket("127.0.0.1", 7775); // x1
			System.out.println("연결되었습니다.");

		} 
		catch (Exception e) {
			System.out.println("연결 실패..");
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