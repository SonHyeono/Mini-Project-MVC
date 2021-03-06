package financial.view;

import org.apache.log4j.Logger;

import financial.controller.ETFProjectController;
import financial.model.dto.ETF;
import financial.model.dto.ETFCustomer;
import financial.model.dto.ETFManager;
import financial.model.dto.ETFProject;

public class StartView {
	
	static Logger logger = Logger.getLogger("log4jtest.Log4jTest");

	public static void login(String id) {
		if(id.equals("login")) {
			logger.trace("trace");
			logger.debug("debug");
			logger.info("info");
			logger.warn("warn" + id);
			logger.error("error");
		}else {
			System.out.println("id 무효--------------");
		}
	}
	public static void logout(String id) {
		if(id.equals("logout")) {
			logger.trace("trace");
			logger.debug("debug");
			logger.info("info");
			logger.warn("warn" + id);
			logger.error("error");
		}else {
			System.out.println("id 무효--------------");
		}
	}
	

	public static void main(String[] args) {
			
		ETF etf1 = new ETF("의료", "KB자산운용", "1년이내", "50억미만");
		ETF etf2 = new ETF("의료", "삼성자산운용", "1년이내", "50억미만");
		ETF etf3 = new ETF("의료", "미래에셋자산운용", "1년이내", "50억미만");
		
		ETF etf4 = new ETF("금융", "KB자산운용", "3년이내", "100억~1천억미만");
		ETF etf5 = new ETF("금융", "삼성자산운용", "3년이내", "100억~1천억미만");
		ETF etf6 = new ETF("금융", "미래에셋자산운용", "3년이내", "100억~1천억미만");
		
		ETF etf7 = new ETF("IT", "KB자산운용", "3개월이내", "50억~100억미만");
		ETF etf8 = new ETF("IT", "삼성자산운용", "3개월이내", "50억~100억미만");
		ETF etf9 = new ETF("IT", "미래에셋자산운용", "3개월이내", "50억~100억미만");

		ETFCustomer etfCustomer1 = new ETFCustomer("임혜창", 26, "1억", "01071136103");
		ETFCustomer etfCustomer2 = new ETFCustomer("손현오", 26, "2억", "01012345678");
		ETFCustomer etfCustomer3 = new ETFCustomer("양지현", 27, "3억", "01077777777");
		ETFCustomer etfCustomer4 = new ETFCustomer("박지성", 27, "50억", "01055555555");
		ETFCustomer etfCustomer5 = new ETFCustomer("손흥민", 27, "300억", "01066666666");
		ETFCustomer etfCustomer6 = new ETFCustomer("강호동", 27, "20억", "01088888888");
		ETFCustomer etfCustomer7 = new ETFCustomer("은지원", 27, "10억", "01099999999");


		ETFManager etfManger1 = new ETFManager("김혜경", 29, "과장", "01012346598");
		ETFManager etfManger2 = new ETFManager("유재석", 37, "부장", "01012346598");
		ETFManager etfManger3 = new ETFManager("조세호", 33, "차장", "01012346598");
		
		ETFProject project1 = new ETFProject("프로젝트1",etf1, etfCustomer1,etfManger1,"2022년 1월 1일","금리 인상 시 수혜");
		ETFProject project2 = new ETFProject("프로젝트2",etf2, etfCustomer2,etfManger2,"2022년 1월 2일","금리 인상 시 수혜");
		ETFProject project3 = new ETFProject("프로젝트3",etf3, etfCustomer3,etfManger3,"2021년 12월 25일","금리 인상 시 수혜");
		ETFProject project4 = new ETFProject("프로젝트4",etf4, etfCustomer4,etfManger2,"2021년 12월 24일","의료기기 수요 확장 시 수혜");
		ETFProject project5 = new ETFProject("프로젝트5",etf5, etfCustomer5,etfManger3,"2021년 12월 22일","의료기기 수요 확장 시 수혜");
		ETFProject project6 = new ETFProject("프로젝트6",etf6, etfCustomer5,etfManger2,"2021년 12월 21일","의료기기 수요 확장 시 수혜");
		ETFProject project7 = new ETFProject("프로젝트7",etf7, etfCustomer5,etfManger1,"2021년 10월 29일","IT 서비스 수요 확장 시 수혜");
		ETFProject project8 = new ETFProject("프로젝트8",etf8, etfCustomer6,etfManger2,"2021년 12월 12일","IT 서비스 수요 확장 시 수혜");
		ETFProject project9 = new ETFProject("프로젝트9",etf9, etfCustomer7,etfManger3,"2021년 11월 25일","IT 서비스 수요 확장 시 수혜");

		ETFProjectController controller = ETFProjectController.getInstance();

		//ETF 프로젝트 생성하기
		System.out.println("*** 01. Project 생성 ***");
		controller.etfProjectInsert(project1);
		login("login");
		controller.etfProjectInsert(project2);
		login("login");
		controller.etfProjectInsert(project3);
		login("login");
		controller.etfProjectInsert(project4);
		login("login");
		controller.etfProjectInsert(project5);
		login("login");
		controller.etfProjectInsert(project6);
		login("login");
		controller.etfProjectInsert(project7);
		login("login");
		controller.etfProjectInsert(project8);
		login("login");
		controller.etfProjectInsert(project9);
		login("login");
		
		// 모든 Project 검색 
		System.out.println("\n*** 02. 모든 Project 검색 ***");
		controller.getetfProjectsList();		
		
		// 구매자 자산 내림차 순으로 프로젝트 정렬
		System.out.println("\n*** 구매자 자산 내림차 순으로 프로젝트 정렬");
		System.out.println("구매자 자산 등수 매기기");
		controller.ranketfProjectList();
	
		// 프로젝트 이름으로 검색 
		System.out.println("\n*** 03. '프로젝트1' Project 검색 ***");
		controller.getetfProject("프로젝트1");   
		
		// 구매자 변경하기
		System.out.println("\n*** 04. '프로젝트1' Project의 구매자 변경(수정) 후 해당 Project 검색 ***");
		controller.etfCustomerUpdate("프로젝트1", etfCustomer2);
		
		
		// 판매자 변경하기 
		System.out.println("\n*** 05. '프로젝트1' Project의 판매자 변경(수정) 후 해당 Project 검색 ***");
		controller.etfManagerUpdate("프로젝트1", etfManger2);
		
		// ETF 프로젝트 삭제하기 
		System.out.println("\n*** 06. '프로젝트1' Project 삭제 후 삭제한 Project 검색 ***");
		controller.etfProjectDelete("프로젝트1");
		controller.getetfProject("프로젝트1");
		logout("logout");
	

		// 새로운 메소드를 위해 지운 프로젝트 1을 추가
		ETFProject alive = new ETFProject("프로젝트1",etf1, etfCustomer1,etfManger1,"2022년 1월 1일","금리 인상 시 수혜");
		controller.etfProjectInsert(alive);
		login("login");
		
		// 모든 프로젝트 검색
		System.out.println("\n*** 07. 모든 Project 검색 ***");
		controller.getetfProjectsList();
		
		
		// 프로젝트 참여한 구매자 자산 순위
		System.out.println("\n*** 08. 프로젝트 참여한 구매자 자산 순위***");
		controller.rankCustomerAsset();
		
		// 구매자 별 프로젝트 구매 수
		System.out.println("\n*** 09. 구매자 별 프로젝트 구매 수***");
		controller.prc();

		// 판매자 별 프로젝트 판매 수
		System.out.println("\n*** 10. 판매자 별 프로젝트 판매 수***");
		controller.prm();

		
		
	}
}

