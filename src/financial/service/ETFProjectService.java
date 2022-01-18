package financial.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import financial.exception.DuplicationProjectException;
import financial.model.dto.ETFCustomer;
import financial.model.dto.ETFManager;
import financial.model.dto.ETFProject;

public class ETFProjectService {
	private static ETFProjectService instance = new ETFProjectService();

	/** 진행중인 Project를 저장하는 배열 */
	private ArrayList<ETFProject> etfProjectList = new ArrayList<ETFProject>();

	private ETFProjectService() {
	}

//	 전체 출력 메소드
	public static ETFProjectService getInstance() {
		return instance;
	}

	/** project 입력 기능 호출 */
	public void etfProjectInsert(ETFProject etf) throws DuplicationProjectException {
		for (ETFProject e : etfProjectList) {
			if (e.getEtfName().equals(etf.getEtfName())) {
				throw new DuplicationProjectException("이미 존재하는 프로젝트입니다.");
			}
		}
		etfProjectList.add(etf);
	}

	// 전체 project 반환
	public ArrayList<ETFProject> getetfProjectsList() {
		return etfProjectList;

	}

//	하나의 project를 조회하여 반환
	public ETFProject getetfProject(String e) {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(e)) {
				return etf;
			}
		}
		return null;

	}

// 수정 메소드 
	public boolean etfCustomerUpdate(String s, ETFCustomer etfcustomer) {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(s)) {
				etf.setProjectEtfCustomer(etfcustomer);
				return true;
			}
		}
		return false;
	}

//수정 메소드
	public boolean etfManagerUpdate(String s, ETFManager manger) {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(s)) {
				etf.setProjectEtfManager(manger);
				return true;
			}
		}
		return false;
	}

// 삭제 메소드 
	public boolean etfProjectDelete(String s) {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(s)) {
				etfProjectList.remove(etf);
				return true;
			}
		}
		return false;
	}

// 프로젝트를 정렬하는 메소드 
	public ArrayList<ETFProject> ranketfProjectList() {
		Collections.sort(etfProjectList, new ComparatorAsset());
		return etfProjectList;
	}

	// 프로젝트 참여한 구매자 자산 순위
	public ArrayList<ETFCustomer> rankCustomerAsset() {
		
		HashSet<ETFCustomer> cus = new HashSet<ETFCustomer>();
		
		for(ETFProject etf : etfProjectList) {
			cus.add(etf.getProjectEtfCustomer());
		}
        ArrayList<ETFCustomer> recus = new ArrayList<>(cus);
        Collections.sort(recus, new ComparatorCustomer());
		return recus;
	}
	
	// 구매자 별 프로젝트 구매 수
	public HashMap<ETFCustomer,Integer> prc() {
		HashMap<ETFCustomer,Integer> maps = new HashMap<ETFCustomer,Integer>();
		
		HashSet<ETFCustomer> cus = new HashSet<ETFCustomer>();
		ArrayList<ETFCustomer> arr = new ArrayList<ETFCustomer>();
		
		for(ETFProject etf : etfProjectList) {
			cus.add(etf.getProjectEtfCustomer());
			arr.add(etf.getProjectEtfCustomer());
		}
		ArrayList<ETFCustomer> recus = new ArrayList<ETFCustomer>(cus);
		
		for(ETFCustomer e:recus) {
			maps.put(e, Collections.frequency(arr,e));
		}
		return maps;
	}
	
	// 판매자 별 프로젝트 판매 수
	public HashMap<ETFManager, Integer> prm() {
		HashMap<ETFManager, Integer> maps = new HashMap<ETFManager, Integer>();
		
		HashSet<ETFManager> cus = new HashSet<ETFManager>();
		ArrayList<ETFManager> arr = new ArrayList<ETFManager>();

		for (ETFProject etf : etfProjectList) {
			cus.add(etf.getProjectEtfManager());
			arr.add(etf.getProjectEtfManager());
		}
		ArrayList<ETFManager> recus = new ArrayList<ETFManager>(cus);
		
		for(ETFManager e:recus) {
			maps.put(e, Collections.frequency(arr,e));
		}
		return maps;
	}
	


}
