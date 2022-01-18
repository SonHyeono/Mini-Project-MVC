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
	} // private로 생성자 태클걸어서 생성못하게 막기. instance만 하게

	public static ETFProjectController getInstance() {
		return instance;
	}

	// service에 있는 project 입력 기능 호출
	public void etfProjectInsert(ETFProject etf) {
		if (etf != null) {
			try {
				service.etfProjectInsert(etf);
			} catch (DuplicationProjectException e) {
				e.printStackTrace();
				FailView.failView(e.getMessage());
			}
		} else {
			FailView.failView("입력 기능에 null 값이 입력되었습니다.");
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

	// Project 한개 출력하기 위한 메소드 , 대입값이 null일 경우 예외처리
	public void getetfProject(String etf) {
		if (etf != null) {
			try {
				SuccessView.projectView(service.getetfProject(etf));
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				FailView.failView(e.getMessage());
			}
		} else {
			FailView.failView("null 값이 입력되었습니다.");
		}
	}

	/*
	 * Project customer 수정하기 위한 메소드 1. s 혹은 customer가 null 일 경우 예외처리 2. 수정할 project의
	 * 이름이 미존재 시 예외처리 3. true면 성공 false면 실패
	 */
	public void etfCustomerUpdate(String s, ETFCustomer customer) {
		if (s == null || customer == null) {
			FailView.failView("Update메소드에 null값이 입력되었습니다.");
		} else {
			try {
				service.etfCustomerUpdate(s, customer);
				SuccessView.successView("Update가 완성되었습니다.");
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				FailView.failView(e.getMessage());
			}
		}
	}

	/*
	 * Project manager 수정하기 위한 메소드 1. s 혹은 manager가 null 일 경우 예외처리 2. 수정할 project의
	 * 이름이 미존재 시 예외처리 3. true면 성공 false면 실패
	 */
	public void etfManagerUpdate(String s, ETFManager manger) {
		if (s == null || manger == null) {
			FailView.failView("Update메소드에 null값이 입력되었습니다.");
		} else {
			try {
				service.etfManagerUpdate(s, manger);
				SuccessView.successView("Update가 완성되었습니다.");
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				FailView.failView(e.getMessage());
			}
		}
	}

	/*
	 * 프로젝트를 삭제하기 위한 메소드 1. s에 null 입력 시 실패 2. s에 대응하는 project 없을 시 실패 3. true면 성공
	 * false면 실패
	 * 
	 */
	public void etfProjectDelete(String s) {
		if (s == null) {
			FailView.failView("Delete메소드에 null값이 입력되었습니다.");
		} else {
			try {
				service.etfProjectDelete(s);
				SuccessView.successView("삭제를 성공했습니다.");
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				FailView.failView(e.getMessage());
			}
		}
	}

//	프로젝트 개인 자산 정렬
	public void ranketfProjectList() {
		try {
			SuccessView.projectRankView(service.ranketfProjectList());
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			FailView.failView(e.getMessage());
		}
	}

// 구매자 자산 순위
	public void rankCustomerAsset() {
		try {
			SuccessView.customerRankView(service.rankCustomerAsset());
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			FailView.failView(e.getMessage());
		}
	}

	// 구매자 별 프로젝트 구매 수
	public void prc() {
		try {
			SuccessView.prcView(service.prc());
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			FailView.failView(e.getMessage());
		}
	}

	// 판매자 별 프로젝트 판매 수
	public void prm() {
		try {
			SuccessView.prmView(service.prm());
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			FailView.failView(e.getMessage());
		}
	}
}
