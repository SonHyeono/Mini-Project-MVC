package financial.service;

import java.util.ArrayList;

import financial.model.dto.ETFCustomer;
import financial.model.dto.ETFManager;
import financial.model.dto.ETFProject;

public class ETFProjectService {
	private static ETFProjectService instance = new ETFProjectService();

	/** 진행중인 Project를 저장하는 배열 */
	private ArrayList<ETFProject> etfProjectList = new ArrayList<ETFProject>();

	private ETFProjectService() {
	}

	public static ETFProjectService getInstance() {
		return instance;
	}
	/** project 삽입 기능 호출 */
	public void etfProjectInsert(ETFProject etf) {
		etfProjectList.add(etf);
	}

	public ArrayList<ETFProject> getetfProjectsList() {
		return etfProjectList;
	}
	
	public ETFProject getetfProject(String e) {
		for(ETFProject etf : etfProjectList) {
			if(etf.getEtfName().equals(e)) {
				return etf;
			}
		}
		return null;
		
	}
	
	public ETFProject etfCustomerUpdate(String s, ETFCustomer etfcustomer) {
		for(ETFProject etf : etfProjectList) {
			if(etf.getEtfName().equals(s)) {
				etf.setProjectEtfCustomer(etfcustomer);
				return etf;
			}
		}
		//없을경우 예외처리
		return null;
	}

	public ETFProject etfManagerUpdate(String s, ETFManager manger) {
		for(ETFProject etf : etfProjectList) {
			if(etf.getEtfName().equals(s)) {
				etf.setProjectEtfManager(manger);
				return etf;
			}
		}
		return null;
	}

	public void etfProjectDelete(String s) {
		for(ETFProject etf : etfProjectList) {
			if(etf.getEtfName().equals(s)) {
				etfProjectList.remove(etf);
				break;
			}
		}
	}
}
