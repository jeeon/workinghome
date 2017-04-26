package tranning.second.operators;

public class Operators {

	public static void main(String[] args) {
		// ������ ���� ���� ���Ͽ� int �� �̿��ϰڽ�.

		int number = 10;
		int value = 20;
		int score = 30;
		char word = 'c';

		// ���� ������ +, -
		System.out.println(-number);
		System.out.println(+number);
		System.out.println(number);

		System.out.println();
		System.out.println();

		// ���� ������ ++,--
		System.out.println(++value);
		System.out.println(--value);
		System.out.println(value++);
		System.out.println(value--);
		System.out.println(value); // ++ �Ǵ� -- �� ���� ��ġ�� ���� ���� ���ϴ� ������ �޶���!!!

		System.out.println();
		System.out.println();

		// ���� ������ +, -, *, / %
		System.out.println(score + score); // �˴� ���� ���ڿ� ������ ���� ���� ���.
		System.out.println(score - score); // ����
		System.out.println(score * score); // ���ϱ�
		System.out.println(score / score); // ������
		System.out.println(score % value); // �������� ������ ��
		System.out.println(word + word); // char + char -> 198 ���.
											// �ҹ��� c �� �����ڵ�� 99
		System.out.println();
		System.out.println();

		// �� ������ >, <, <=, >=, ==, != //ũ�ų�, �۰ų�, ũ�� ���ų�, �۰� ���ų�, ���ų�, ���� �ʰų�
		// �� ������ && || //&&- ������, || - ������

		//�ϴ� ��� for���� �� �������� ���̶� ��� Ȯ�� �غ���.

		for (int i = 10; i <= 20; i++) {			//���� 10~20���� ����. ���� �ȵǸ� �ܿ�!
			if (12 < i && i < 18) {					//12���� ũ�� 18���� ����
				System.out.print(i+", ");
			}
		}
		System.out.println();


		for (int i = 10; i < 20; i++) {
			if (12 <= i && i <= 18) {				//12�� ũ�ų� ���� 18���� �۰ų� ����
				System.out.print(i+", ");
			}
		}
		System.out.println();


		for (int i = 10; i < 20; i++) {
			if (12 < i || i < 18) {					//12���� ũ���� 18���� �۴���
				System.out.print(i+", ");
			}
		}
		System.out.println();


		for (int i = 10; i < 20; i++) {
			if (12 > i || i > 18) {					//12���� �۰ų� 18���� ũ�ų�
				System.out.print(i+", ");
			}
		}

		System.out.println();
		System.out.println();

		// ���� ������. (���ǽ�)? �� ��: ���� ��; �ܿ�. ����� ����.
		System.out.println((number > score) ? "�´�" : "Ʋ����");

		String st = (score > value) ? "�´�" : "Ʋ����"; 		// ��ȯ�ȴ� ���� �Է��� �ִ� ������ �Լ�
															// �ʿ�!!!!!
		System.out.println(st);

		System.out.println();
		System.out.println();
		
		//���Կ�����.
		number+=number;									//number = number+number
		System.out.println(number);						//10+10  = 20

		number*=score;									//number = number*score
		System.out.println(number);						//20*30  = 600

		number/=score;									//number = number/score
		System.out.println(number);						//600/30 = 20
		
		number-=number;									//number = number+number
		System.out.println(number);						//20 -20 = 0

		System.out.println();
		
		//�� �� �� ����~
	}
}