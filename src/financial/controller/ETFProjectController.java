package financial.controller;

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

	//service�� �ִ� project ���� ��� ȣ��
	public void etfProjectInsert(ETFProject etf) {
		service.etfProjectInsert(etf);
	}

	public void getetfProjectsList() {
		SuccessView.projectListView(service.getetfProjectsList());
		
	}

	public void getetfProject(String etf) {
		if(service.getetfProject(etf) != null) {
		SuccessView.projectView(service.getetfProject(etf));
		}else {
			FailView.failView("�ش� ������Ʈ�� ���������ʽ��ϴ�.");
		}
	}

	public void etfCustomerUpdate(String s, ETFCustomer customer) {
		SuccessView.projectView(service.etfCustomerUpdate(s, customer));
	}

	public void etfManagerUpdate(String s, ETFManager manger) {
		SuccessView.projectView(service.etfManagerUpdate(s,manger));
		
	}

	public void etfProjectDelete(String s) {
		service.etfProjectDelete(s);
		
	}
	

}
