package financial.view;

import financial.controller.ETFProjectController;
import financial.model.dto.ETF;
import financial.model.dto.ETFCustomer;
import financial.model.dto.ETFManager;
import financial.model.dto.ETFProject;

public class StartView {

	public static void main(String[] args) {
			
		ETF etf1 = new ETF("�Ƿ�", "KB�ڻ���", "1���̳�", "50��̸�");
		ETF etf2 = new ETF("�Ƿ�", "�Ｚ�ڻ���", "1���̳�", "50��̸�");
		ETF etf3 = new ETF("�Ƿ�", "�̷������ڻ���", "1���̳�", "50��̸�");
		
		ETF etf4 = new ETF("����", "KB�ڻ���", "3���̳�", "100��~1õ��̸�");
		ETF etf5 = new ETF("����", "�Ｚ�ڻ���", "3���̳�", "100��~1õ��̸�");
		ETF etf6 = new ETF("����", "�̷������ڻ���", "3���̳�", "100��~1õ��̸�");
		
		ETF etf7 = new ETF("IT", "KB�ڻ���", "3�����̳�", "50��~100��̸�");
		ETF etf8 = new ETF("IT", "�Ｚ�ڻ���", "3�����̳�", "50��~100��̸�");
		ETF etf9 = new ETF("IT", "�̷������ڻ���", "3�����̳�", "50��~100��̸�");

		ETFCustomer etfCustomer1 = new ETFCustomer("����â", 26, "1��", "01071136103");
		ETFCustomer etfCustomer2 = new ETFCustomer("������", 26, "2��", "01012345678");
		ETFCustomer etfCustomer3 = new ETFCustomer("������", 27, "3��", "01077777777");
		ETFCustomer etfCustomer4 = new ETFCustomer("������", 27, "50��", "01055555555");
		ETFCustomer etfCustomer5 = new ETFCustomer("�����", 27, "300��", "01066666666");
		ETFCustomer etfCustomer6 = new ETFCustomer("��ȣ��", 27, "20��", "01088888888");
		ETFCustomer etfCustomer7 = new ETFCustomer("������", 27, "10��", "01099999999");


		ETFManager etfManger1 = new ETFManager("������", 29, "����", "01012346598");
		ETFManager etfManger2 = new ETFManager("���缮", 37, "����", "01012346598");
		ETFManager etfManger3 = new ETFManager("����ȣ", 33, "����", "01012346598");
		
		ETFProject project1 = new ETFProject("������Ʈ1",etf1, etfCustomer1,etfManger1,"2022�� 1�� 1��","�ݸ� �λ� �� ����");
		ETFProject project2 = new ETFProject("������Ʈ2",etf2, etfCustomer2,etfManger2,"2022�� 1�� 2��","�ݸ� �λ� �� ����");
		ETFProject project3 = new ETFProject("������Ʈ3",etf3, etfCustomer3,etfManger3,"2021�� 12�� 25��","�ݸ� �λ� �� ����");
		ETFProject project4 = new ETFProject("������Ʈ4",etf4, etfCustomer4,etfManger2,"2021�� 12�� 24��","�Ƿ��� ���� Ȯ�� �� ����");
		ETFProject project5 = new ETFProject("������Ʈ5",etf5, etfCustomer5,etfManger3,"2021�� 12�� 22��","�Ƿ��� ���� Ȯ�� �� ����");
		ETFProject project6 = new ETFProject("������Ʈ6",etf6, etfCustomer5,etfManger2,"2021�� 12�� 21��","�Ƿ��� ���� Ȯ�� �� ����");
		ETFProject project7 = new ETFProject("������Ʈ7",etf7, etfCustomer5,etfManger1,"2021�� 10�� 29��","IT ���� ���� Ȯ�� �� ����");
		ETFProject project8 = new ETFProject("������Ʈ8",etf8, etfCustomer6,etfManger2,"2021�� 12�� 12��","IT ���� ���� Ȯ�� �� ����");
		ETFProject project9 = new ETFProject("������Ʈ9",etf9, etfCustomer7,etfManger3,"2021�� 11�� 25��","IT ���� ���� Ȯ�� �� ����");

		ETFProjectController controller = ETFProjectController.getInstance();

		//ETF ������Ʈ �����ϱ�
		System.out.println("*** 01. Project ���� ***");
		controller.etfProjectInsert(project1);
		controller.etfProjectInsert(project2);
		controller.etfProjectInsert(project3);
		controller.etfProjectInsert(project4);
		controller.etfProjectInsert(project5);
		controller.etfProjectInsert(project6);
		controller.etfProjectInsert(project7);
		controller.etfProjectInsert(project8);
		controller.etfProjectInsert(project9);
	
		// ��� Project �˻� 
		System.out.println("\n*** 02. ��� Project �˻� ***");
		controller.getetfProjectsList();		
		
		// ������ �ڻ� ������ ������ ������Ʈ ����
		System.out.println("\n*** ������ �ڻ� ������ ������ ������Ʈ ����");
		System.out.println("������ �ڻ� ��� �ű��");
		controller.ranketfProjectList();
	
		// ������Ʈ �̸����� �˻� 
		System.out.println("\n*** 03. '������Ʈ1' Project �˻� ***");
		controller.getetfProject("������Ʈ1");   
		
		// ������ �����ϱ�
		System.out.println("\n*** 04. '������Ʈ1' Project�� ������ ����(����) �� �ش� Project �˻� ***");
		controller.etfCustomerUpdate("������Ʈ1", etfCustomer2);
		
		
		// �Ǹ��� �����ϱ� 
		System.out.println("\n*** 05. '������Ʈ1' Project�� �Ǹ��� ����(����) �� �ش� Project �˻� ***");
		controller.etfManagerUpdate("������Ʈ1", etfManger2);
		
		// ETF ������Ʈ �����ϱ� 
		System.out.println("\n*** 06. '������Ʈ1' Project ���� �� ������ Project �˻� ***");
		controller.etfProjectDelete("������Ʈ1");
		controller.getetfProject("������Ʈ1");
	

		// ���ο� �޼ҵ带 ���� ���� ������Ʈ 1�� �߰�
		ETFProject alive = new ETFProject("������Ʈ1",etf1, etfCustomer1,etfManger1,"2022�� 1�� 1��","�ݸ� �λ� �� ����");
		controller.etfProjectInsert(alive);
		
		// ��� ������Ʈ �˻�
		System.out.println("\n*** 07. ��� Project �˻� ***");
		controller.getetfProjectsList();
		
		
		// ������Ʈ ������ ������ �ڻ� ����
		System.out.println("\n*** 08. ������Ʈ ������ ������ �ڻ� ����***");
		controller.rankCustomerAsset();
		
		// ������ �� ������Ʈ ���� ��
		System.out.println("\n*** 09. ������ �� ������Ʈ ���� ��***");
		controller.prc();

		// �Ǹ��� �� ������Ʈ �Ǹ� ��
		System.out.println("\n*** 10. �Ǹ��� �� ������Ʈ �Ǹ� ��***");
		controller.prm();

		
		
	}
}

