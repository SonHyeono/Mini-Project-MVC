package financial.controller;

import java.util.ArrayList;

import financial.exception.DuplicationProjectException;
import financial.model.dto.ETFCustomer;
import financial.model.dto.ETFManager;
import financial.model.dto.ETFProject;
import financial.service.ETFProjectService;
import financial.view.FailView;
import financial.view.SuccessView;

public class ETFProjectController {

	private static ETFProjectController instance = new ETFProjectController();
	
	
	private ETFProjectService service = ETFProjectService.getInstance();

	private ETFProjectController() {} // private�� ������ ��Ŭ�ɾ �������ϰ� ����.  instance�� �ϰ�
	
	public static ETFProjectController getInstance() {
		return instance;
	}

	//service�� �ִ� project �Է� ��� ȣ��
	public void etfProjectInsert(ETFProject etf) {
		if(etf != null) {
			try {
				service.etfProjectInsert(etf);
			} catch (DuplicationProjectException e) {
				e.printStackTrace();
				FailView.failView(e.getMessage());
			}
		}else {
			FailView.failView("null ���� �ԷµǾ����ϴ�.");
		}
	}

	// Project ��ü ��� , Project�� ������� �� ����ó��
	public void getetfProjectsList() {
		ArrayList<ETFProject> e = service.getetfProjectsList();
		if(e != null) {  //null�̸� ���� �Ȱɷ���.
			SuccessView.projectListView(e);
		}else {
			FailView.failView("Project�� ������ϴ�.");
		}
		
		
	}
	// Project �Ѱ� ����ϱ� ���� �޼ҵ� , ���԰��� null�� ��� ����ó��
	public void getetfProject(String etf) {
		if(service.getetfProject(etf) != null) {
		SuccessView.projectView(service.getetfProject(etf));
		}else {
			FailView.failView("�ش� ������Ʈ�� ���������ʽ��ϴ�.");
		}
	}

/*
 * 	Project customer �����ϱ� ���� �޼ҵ� 
 * 1. s Ȥ�� customer�� null �� ��� ����ó��
 * 2. ������ project�� �̸��� ������ �� ����ó��
 * 3. true�� ���� false�� ���� 
 */
	public void etfCustomerUpdate(String s, ETFCustomer customer) {
		if (s == null || customer == null) {
			FailView.failView("Update�޼ҵ忡 null���� �ԷµǾ����ϴ�.");
		} else {
			boolean tf = service.etfCustomerUpdate(s, customer);
			if (tf == true) {
				SuccessView.successView("Update�� �ϼ��Ǿ����ϴ�.");
			} else {
				FailView.failView("Update�� �����߽��ϴ�.");
			}
		}
	}
	/*
	 * 	Project manager �����ϱ� ���� �޼ҵ� 
	 * 1. s Ȥ�� manager�� null �� ��� ����ó��
	 * 2. ������ project�� �̸��� ������ �� ����ó��
	 * 3. true�� ���� false�� ���� 
	 */
	public void etfManagerUpdate(String s, ETFManager manger) {
		if (s == null || manger == null) {
			FailView.failView("Update�޼ҵ忡 null���� �ԷµǾ����ϴ�.");
		} else {
			boolean tf = service.etfManagerUpdate(s, manger);
			if (tf == true) {
				SuccessView.successView("Update�� �ϼ��Ǿ����ϴ�.");
			} else {
				FailView.failView("Update�� �����߽��ϴ�.");
			}
		}
	}
/* ������Ʈ�� �����ϱ� ���� �޼ҵ�
 * 1. s�� null �Է� �� ����
 * 2. s�� �����ϴ� project ���� �� ����
 * 3. true�� ���� false�� ����
 * 
 */
	public void etfProjectDelete(String s) {
		if (s == null) {
			FailView.failView("Delete�޼ҵ忡 null���� �ԷµǾ����ϴ�.");
		} else {
			boolean b = service.etfProjectDelete(s);
			if(b == true) {
				SuccessView.successView("������ �����Ͽ����ϴ�.");
			}else {
				FailView.failView("������ �����߽��ϴ�.");
			}
		}
	}
	
//	������Ʈ ���� �ڻ� ����
	public void ranketfProjectList() {
		SuccessView.projectRankView(service.ranketfProjectList());
	}
// ������ �ڻ� ����
	public void rankCustomerAsset() {
		SuccessView.customerRankView(service.rankCustomerAsset());
	}
	// ������ �� ������Ʈ ���� ��
	public void prc() {
		SuccessView.prcView(service.prc());
	}
	// �Ǹ��� �� ������Ʈ �Ǹ� ��
	public void prm() {
		SuccessView.prmView(service.prm());
		
	}

}
