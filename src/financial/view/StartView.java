package financial.view;

import financial.controller.ETFProjectController;
import financial.model.dto.ETF;
import financial.model.dto.ETFCustomer;
import financial.model.dto.ETFManager;
import financial.model.dto.ETFProject;

public class StartView {

	public static void main(String[] args) {
		System.out.println(1);
		ETF etf1 = new ETF("의료", "DB자산운용", "1년이내", "50억미만");
		ETF etf2 = new ETF("금융", "삼성자산운용", "3년이내", "100억~1천억미만");
		ETF etf3 = new ETF("IT", "대신자산운용", "3개월이내", "50억~100억미만");

		ETFCustomer etfCustomer1 = new ETFCustomer("임혜창", 26, "1천억", "01071136103");
		ETFCustomer etfCustomer2 = new ETFCustomer("손현오", 26, "2천억", "01012345678");
		ETFCustomer etfCustomer3 = new ETFCustomer("양지현", 27, "3천억", "01077777777");

		ETFManager etfManger1 = new ETFManager("김혜경", 29, "과장", "01012346598");
		ETFManager etfManger2 = new ETFManager("유재석", 37, "부장", "01012346598");
		ETFManager etfManger3 = new ETFManager("조세호", 33, "차장", "01012346598");
		
		ETFProject Keynes = new ETFProject("케인즈",etf1, etfCustomer1,etfManger1,"2021년 1월 1일","금융 분야의 주식과 펀드 혼합");
		ETFProject  nightingale = new ETFProject("나이팅게일",etf2, etfCustomer2,etfManger2,"2022년 1월 1일","의료 분야의 주식과 펀드 혼합");
		ETFProject  Wifi = new ETFProject("와이파이",etf3, etfCustomer3,etfManger3,"2021년 12월 25일","IT 분야의 주식과 펀드 혼합");

		ETFProjectController controller = ETFProjectController.getInstance();

		
		//ETF 프로젝트 생성하기
		System.out.println("*** 01. Project 생성 ***");
		controller.etfProjectInsert(Keynes);
		controller.etfProjectInsert(nightingale);
		controller.etfProjectInsert(Wifi);
	
		System.out.println("\n*** 02. 모든 Project 검색 ***");
		controller.getetfProjectsList();		
	
		
		System.out.println("\n*** 03. '케인즈' Project 검색 ***");
		controller.getetfProject("케인즈");
		
		//구매자 변경하기
		System.out.println("\n*** 04. '케인즈' Project의 구매자 변경(수정) 후 해당 Project 검색 ***");
		controller.etfCustomerUpdate("케인즈", etfCustomer2);
		
		
//		판매자 변경하기 
		System.out.println("\n*** 05. '케인즈' Project의 판매자 변경(수정) 후 해당 Project 검색 ***");
		controller.etfManagerUpdate("케인즈", etfManger2);
		
//		ETF 프로젝트 삭제하기 
		System.out.println("\n*** 06. '케인즈' Project 삭제 후 삭제한 Project 검색 ***");
		controller.etfProjectDelete("케인즈");
		controller.getetfProject("케인즈");
	
		System.out.println("\n*** 02. 모든 Project 검색 ***");
		controller.getetfProjectsList();
		
		
	}
}

