package financial.controller;

import financial.exception.DuplicationProjectException;
import financial.exception.ProjectNotFoundException;
import financial.model.dto.ETFCustomer;
import financial.model.dto.ETFManager;
import financial.model.dto.ETFProject;
import financial.service.ETFProjectService;
import financial.view.FailView;
import financial.view.SuccessView;

public class ETFProjectController {

	private static ETFProjectController instance = new ETFProjectController();

	private ETFProjectService service = ETFProjectService.getInstance();

	private ETFProjectController() {
	} // private�� ������ ��Ŭ�ɾ �������ϰ� ����. instance�� �ϰ�

	public static ETFProjectController getInstance() {
		return instance;
	}

	// service�� �ִ� project �Է� ��� ȣ��
	public void etfProjectInsert(ETFProject etf) {
		if (etf != null) {
			try {
				service.etfProjectInsert(etf);
			} catch (DuplicationProjectException e) {
				e.printStackTrace();
				FailView.failView(e.getMessage());
			}
		} else {
			FailView.failView("�Է� ��ɿ� null ���� �ԷµǾ����ϴ�.");
		}
	}

	public void getetfProjectsList() {
		try {
			SuccessView.projectListView(service.getetfProjectsList());
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			FailView.failView(e.getMessage());
		}
	}

	// Project �Ѱ� ����ϱ� ���� �޼ҵ� , ���԰��� null�� ��� ����ó��
	public void getetfProject(String etf) {
		if (etf != null) {
			try {
				SuccessView.projectView(service.getetfProject(etf));
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				FailView.failView(e.getMessage());
			}
		} else {
			FailView.failView("null ���� �ԷµǾ����ϴ�.");
		}
	}

	/*
	 * Project customer �����ϱ� ���� �޼ҵ� 1. s Ȥ�� customer�� null �� ��� ����ó�� 2. ������ project��
	 * �̸��� ������ �� ����ó�� 3. true�� ���� false�� ����
	 */
	public void etfCustomerUpdate(String s, ETFCustomer customer) {
		if (s == null || customer == null) {
			FailView.failView("Update�޼ҵ忡 null���� �ԷµǾ����ϴ�.");
		} else {
			try {
				service.etfCustomerUpdate(s, customer);
				SuccessView.successView("Update�� �ϼ��Ǿ����ϴ�.");
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				FailView.failView(e.getMessage());
			}
		}
	}

	/*
	 * Project manager �����ϱ� ���� �޼ҵ� 1. s Ȥ�� manager�� null �� ��� ����ó�� 2. ������ project��
	 * �̸��� ������ �� ����ó�� 3. true�� ���� false�� ����
	 */
	public void etfManagerUpdate(String s, ETFManager manger) {
		if (s == null || manger == null) {
			FailView.failView("Update�޼ҵ忡 null���� �ԷµǾ����ϴ�.");
		} else {
			try {
				service.etfManagerUpdate(s, manger);
				SuccessView.successView("Update�� �ϼ��Ǿ����ϴ�.");
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				FailView.failView(e.getMessage());
			}
		}
	}

	/*
	 * ������Ʈ�� �����ϱ� ���� �޼ҵ� 1. s�� null �Է� �� ���� 2. s�� �����ϴ� project ���� �� ���� 3. true�� ����
	 * false�� ����
	 * 
	 */
	public void etfProjectDelete(String s) {
		if (s == null) {
			FailView.failView("Delete�޼ҵ忡 null���� �ԷµǾ����ϴ�.");
		} else {
			try {
				service.etfProjectDelete(s);
				SuccessView.successView("������ �����߽��ϴ�.");
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				FailView.failView(e.getMessage());
			}
		}
	}

//	������Ʈ ���� �ڻ� ����
	public void ranketfProjectList() {
		try {
			SuccessView.projectRankView(service.ranketfProjectList());
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			FailView.failView(e.getMessage());
		}
	}

// ������ �ڻ� ����
	public void rankCustomerAsset() {
		try {
			SuccessView.customerRankView(service.rankCustomerAsset());
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			FailView.failView(e.getMessage());
		}
	}

	// ������ �� ������Ʈ ���� ��
	public void prc() {
		try {
			SuccessView.prcView(service.prc());
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			FailView.failView(e.getMessage());
		}
	}

	// �Ǹ��� �� ������Ʈ �Ǹ� ��
	public void prm() {
		try {
			SuccessView.prmView(service.prm());
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			FailView.failView(e.getMessage());
		}
	}
}
