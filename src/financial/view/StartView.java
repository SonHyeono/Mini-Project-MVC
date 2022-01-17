package financial.view;

import financial.controller.ETFProjectController;
import financial.model.dto.ETF;
import financial.model.dto.ETFCustomer;
import financial.model.dto.ETFManager;
import financial.model.dto.ETFProject;

public class StartView {

	public static void main(String[] args) {
		System.out.println(1);
		ETF etf1 = new ETF("�Ƿ�", "DB�ڻ���", "1���̳�", "50��̸�");
		ETF etf2 = new ETF("����", "�Ｚ�ڻ���", "3���̳�", "100��~1õ��̸�");
		ETF etf3 = new ETF("IT", "����ڻ���", "3�����̳�", "50��~100��̸�");

		ETFCustomer etfCustomer1 = new ETFCustomer("����â", 26, "1õ��", "01071136103");
		ETFCustomer etfCustomer2 = new ETFCustomer("������", 26, "2õ��", "01012345678");
		ETFCustomer etfCustomer3 = new ETFCustomer("������", 27, "3õ��", "01077777777");

		ETFManager etfManger1 = new ETFManager("������", 29, "����", "01012346598");
		ETFManager etfManger2 = new ETFManager("���缮", 37, "����", "01012346598");
		ETFManager etfManger3 = new ETFManager("����ȣ", 33, "����", "01012346598");
		
		ETFProject Keynes = new ETFProject("������",etf1, etfCustomer1,etfManger1,"2021�� 1�� 1��","���� �о��� �ֽİ� �ݵ� ȥ��");
		ETFProject  nightingale = new ETFProject("�����ð���",etf2, etfCustomer2,etfManger2,"2022�� 1�� 1��","�Ƿ� �о��� �ֽİ� �ݵ� ȥ��");
		ETFProject  Wifi = new ETFProject("��������",etf3, etfCustomer3,etfManger3,"2021�� 12�� 25��","IT �о��� �ֽİ� �ݵ� ȥ��");

		ETFProjectController controller = ETFProjectController.getInstance();

		
		//ETF ������Ʈ �����ϱ�
		System.out.println("*** 01. Project ���� ***");
		controller.etfProjectInsert(Keynes);
		controller.etfProjectInsert(nightingale);
		controller.etfProjectInsert(Wifi);
	
		System.out.println("\n*** 02. ��� Project �˻� ***");
		controller.getetfProjectsList();		
	
		
		System.out.println("\n*** 03. '������' Project �˻� ***");
		controller.getetfProject("������");
		
		//������ �����ϱ�
		System.out.println("\n*** 04. '������' Project�� ������ ����(����) �� �ش� Project �˻� ***");
		controller.etfCustomerUpdate("������", etfCustomer2);
		
		
//		�Ǹ��� �����ϱ� 
		System.out.println("\n*** 05. '������' Project�� �Ǹ��� ����(����) �� �ش� Project �˻� ***");
		controller.etfManagerUpdate("������", etfManger2);
		
//		ETF ������Ʈ �����ϱ� 
		System.out.println("\n*** 06. '������' Project ���� �� ������ Project �˻� ***");
		controller.etfProjectDelete("������");
		controller.getetfProject("������");
	
		System.out.println("\n*** 02. ��� Project �˻� ***");
		controller.getetfProjectsList();
		
		
	}
}

