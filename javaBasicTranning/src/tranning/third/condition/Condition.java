package tranning.third.condition;

public class Condition {
//---------------------------------------���ǹ� if, if-else, switch-case------------------------------------
	public static void main(String[] args) {
		//if ��
		int a =7;

		if(a<10){											//����
			System.out.println("number is "+a);				//�� �̸� ���� 
		}

		
		
		//if - else ��
		
		if(a<10){											//����
			System.out.println(true);						//���̸� ����
		}
		else{												//�����̸� ����
			System.out.println(false);
		}
		
			// ��๮
		if(a<10)											
			System.out.println(true);						
		else												
			System.out.println(false);						//���๮�� 1���� ��� 
															//(; �� 1�� �� ���) {�߰���}�� �ʿ� ����.
			//���� 1.
		if(a<10)
			;						
		else												
			System.out.println(false);						//�����϶��� ���ǹ��� �������. 

			//���� 2. 
		System.out.println((a<10)? true :false);			//if - else ���� 1.�� ���� ��� syso �ȿ� ��밡��.

		System.out.println();
		System.out.println();
		

	
		
		//if-else if ��										��������.

		int no=3;
		
		if(no==1){											//���϶� ����
			System.out.println("1 �̴�");
		}
		else if(no==2){										//�� if �� �ƴ� �� 
			System.out.println("2 �̴�");
		}
		else if(no==3){										//�� else if�� �ƴ� ��
			System.out.println("3 �̴�");	
		}
		else{												//���� ��� ������ �� �ƴ� ��.
			System.out.println("�� ū ����");
		}
		

			//��๮
		if(no==1)											
			System.out.println("1 �̴�");
		else if(no==2)										
			System.out.println("2 �̴�");
		else if(no==3)										
			System.out.println("3 �̴�");	
		else												
			System.out.println("�� ū ����");					//{�߰��� �� ��.}

		

		
		//���� ���     ---------------------------------------------------------------

		if(0<no&&no<10){									// �� : 0<no<10
			System.out.println(no);				
		}
		

		
		
		//������ 1. ---------------------------------------------------------------

		if(0<no){											// �� : 0<no
			if(no<10){										// �� : no<10
				System.out.println(no);								
			}
		}

		
		
		
		//������ 2. ---------------------------------------------------------------

		if(0<no){											// �� : 0<no
			if(no<10){										// �� : 0<no<10
				System.out.println(no);								
			}
			else{											//�� : 0<no, 10<=no
				
			}
		}
		else{												//�� : 0>no

		}

		System.out.println();
		System.out.println();
		System.out.println();

		//switch-case ��										// if-else if ���� ����!
															// {�߰���} �� �� �ʿ䰡 ����.
															// break �� ���ö� ���� ����.
		
		char word = 'a';

		switch(word){
		case 'a': 	System.out.println("a choose!");		//������ ������ ����
			break;											//switch �� ������ ���� ����. ���ٸ� �ؿ� case�� ����.

		case 'b':	System.out.println("a choose!");
			break;
		
		case 'c':	System.out.println("a choose!");
			break;
		
		case 'd':	System.out.println("a choose!");
			break;	
		
		default:
		}
		
//-----------------------------------------------------------------------------------------------------------------------------		
		//switch-case �� + if-else if ��
		
		String str = "��";
		int mari = 2;
		switch(str){
		
		case "��" :	
			System.out.println("��"); 
			if(mari==1){
				System.out.println("�Ѹ���");
			}
			else if(mari ==2){
				System.out.println("�θ���");				
			}
			else if(mari == 3){
				System.out.println("������");				
			}
			else{
				System.out.println("���� ����");				
			} 
			break;


		case "��" :	
			System.out.println("��"); 
			if(mari==1){
				System.out.println("�Ѹ���");
			}
			else if(mari ==2){
				System.out.println("�θ���");				
			}
			else if(mari == 3){
				System.out.println("������");				
			}
			else{
				System.out.println("���� ����");				
			} 
			break;

		
		case "��" : System.out.println("��");
			if(mari==1){
				System.out.println("�Ѹ���");
			}
			else if(mari ==2){
				System.out.println("�θ���");				
			}
			else if(mari == 3){
				System.out.println("������");				
			}
			else{
				System.out.println("���� ����");				
			} 
			break;

		
		case "��" : System.out.println("��");
			if(mari==1){
				System.out.println("�Ѹ���");
			}
			else if(mari ==2){
				System.out.println("�θ���");				
			}
			else if(mari == 3){
				System.out.println("������");				
			}
			else{
				System.out.println("���� ����");				
			} 
			break;

		
		case "��" : System.out.println("��");
			if(mari==1){
				System.out.println("�Ѹ���");
			}
			else if(mari ==2){
				System.out.println("�θ���");				
			}
			else if(mari == 3){
				System.out.println("������");				
			}
			else{
				System.out.println("���� ����");				
			} 
			break;			
		}

//----------------------------------------------------------------------------------------------------------------------------
//�ǽ� 1.: �� switch-case��  + if-else ���� ���¸� �Ųٷ� if-else�� + switch-case������ �ٲٽÿ�
//�ǽ� 2.: if-else�� + if-else������ �ٲٽÿ�
//�ǽ� 3.: �� switch-case��  + switch-case������ �ٲٽÿ�
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
	}	
}		
