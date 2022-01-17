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

	private ETFProjectController() {} // private로 생성자 태클걸어서 생성못하게 막기.  instance만 하게
	
	public static ETFProjectController getInstance() {
		return instance;
	}

	//service에 있는 project 삽입 기능 호출
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
			FailView.failView("해당 프로젝트는 존재하지않습니다.");
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
