package test;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;

public class PageViewer extends Frame {
	private TextField tURL = new TextField("");											 // URL�� �Է��ϴ� �ؽ�Ʈ�ʵ�


	// �� �������� �ҽ��� �����ִ� �ؽ�Ʈ����
	private TextArea tPage = new TextArea();

	private BufferedReader reader; 														// �Է� ��Ʈ��
	
	public PageViewer(String title) { 													// ������
		super(title);
		tPage.setEditable(false);
		add(tURL, "North");
		add(tPage, "Center");

		
		// tURL�� �׼� �̺�Ʈ ó��
		tURL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {

																						// tURL�� ���뿡 �ش��ϴ� URL ��ü�� �����ϴ� �� �������� �д´�.
					readPage(new URL(tURL.getText()));

				} catch (MalformedURLException ie) {
					tPage.setText("URL�� �߸��Ǿ����ϴ�.");
				}
			}
		});
	}

	
	// url ��ü�� �����ϴ� �� �������� �о���� �޼ҵ�
	void readPage(URL url) {
		tPage.setText("");
		String line;
		try {
																						
			reader = new BufferedReader(new InputStreamReader(url.openStream()));		// url�� �Է� ��Ʈ���� ��´�.

			while ((line = reader.readLine()) != null)									// �� �� ������ �о tPage�� �߰��Ѵ�.

				tPage.append(line + "\n");

		} 
		catch (IOException ie) {
			tPage.setText("����� ���ܰ� �߻��Ͽ����ϴ�.");
		} 
		finally {
			try {
				if (reader != null)
					reader.close();
			} 
			catch (Exception e) {}
		}
	}


	public static void main(String[] args) {
		PageViewer me = new PageViewer("Page Viewer");
		me.setSize(400, 400);
		me.setVisible(true);
	}
}