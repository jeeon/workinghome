package tranning.first.variable;

public class variableTest {

	public static void main(String[] args) {

		// ���� ����
		boolean y;
		byte b;
		short s;
		int i;
		long l;

		float f;
		double d;

		char c;
		String st;

		// ���� �ʱ�ȭ <- �޼ҵ�(�Լ�) �ȿ��� �̰� ���ϸ� ��� �ȴ�.
		
		// System.out.println(a);
		// System.out.println(b);
		// System.out.println(s);
		// System.out.println(c); 					//�� �� ��~ �Ǵ���!?!?
		
		
		//���� �ϴ� ��! ���� �̸�(����) = �� ��(������)
		y = true; 									// or false;
		b = 1;
		s = 2;
		i = 4;
		l = 8L;										//�ܾ� �ڿ� �빮�� L

		f = 4f;										//�ܾ� �ڿ� �ҹ��� f
		d = 8.000011;
		c = '2';									// �̰� ���� �̰� �ƴ� �ܾ� '2' ��.
		st = "input word";
		
		System.out.println(y);						//System.out.println�� ȭ�鿡 ���!!!��!��! ���ִ� ����.
		System.out.println(b);						//���پ� ��� 
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);

		System.out.println();						//��ü �����ε� ���� ���� ����.

		System.out.print(y);						//System.out.print�� ȭ�鿡 ���!!!��!��! ���ִ� ����.
		System.out.print(b);						//��¹� ���� ���
		System.out.print(s);
		System.out.print(i);
		System.out.print(l);

		System.out.println();
		System.out.println();
		
		System.out.printf("%.5f",d);				//�Ҽ��� �ڸ��� ó�����!!!!! �̰� �� �ܿ�. ������.
		
		System.out.println();
		System.out.println();
		
		//�������� �����!!!!
		System.out.println(i+i);							//int+int 		4+4 -> 8 �� ���
		System.out.println(b+s);							//byte+short 	1+2 -> 3 �� ��� (�� ��ȯ short?? �̰� ����..;;)
		System.out.println(i+f);							//int+float		4+4.0 ->8 ��� (�� ��ȯ float)
		
		// ���� ���ڿ� ������ ������ ���� ������� ���.
				
		//System.out.println(y+i);							//�ϴ� boolean�� ���ϴ°� �ȴ�.

		System.out.println(c+i);							//char+int		char�� �����ڵ尪 50���� ��ȯ �� ���ڳ��� ���� �� ��� 54.

		c=(char)((int)c+i);									//1. c�� ���� �����ڵ�� ��ȯ	2. ���� 2�� ����.	3. ���� ���� �����ڵ�� �̿��ؼ� �ٽ� char���·� ����. ->  
		System.out.println(c);								//6 ���.(unicode : 54),  ���� �� �� = 2 (unicode : 50)
		
		System.out.println(st+i);							//string+int �� ���ڰ� ���� �� ��ȯ���� ����ȭ �Ǿ �ν� ->	input word4 ���

		System.out.println(s+i+c+b+st);						//�� ���� ���	1. short + int 				= (int)		6, 
															//  		2. 6 + char(unicode : 54) 	= (int)		60, 
															//			3. 60+byte 					= (int)		61 
															//			4. 61 + string 				= (String)	61input world 

															//			���� String �� ¯��. ���۷��� ��, ���� ������~
		
	}

}