package financial.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import financial.exception.DuplicationProjectException;
import financial.exception.ProjectNotFoundException;
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


//  전체 project 조회	
	public ArrayList<ETFProject> getetfProjectsList() throws ProjectNotFoundException {
		if (etfProjectList.size() == 0) {
			throw new ProjectNotFoundException("Project가 비었습니다.");
		} else {
			return etfProjectList;
		}

	}

//	하나의 project를 조회하여 반환
	public ETFProject getetfProject(String e) throws ProjectNotFoundException {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(e)) {
				return etf;
			}
		}
		throw new ProjectNotFoundException("해당 프로젝트가 존재하지 않습니다.");
	}

// 수정 메소드 
	public void etfCustomerUpdate(String s, ETFCustomer etfcustomer) throws ProjectNotFoundException {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(s)) {
				etf.setProjectEtfCustomer(etfcustomer);
				return;
			}
		}
		throw new ProjectNotFoundException("미 존재하는 프로젝트 수정 시도입니다.");
	}

//수정 메소드
	public void etfManagerUpdate(String s, ETFManager manger) throws ProjectNotFoundException {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(s)) {
				etf.setProjectEtfManager(manger);
				return;
			}
		}
		throw new ProjectNotFoundException("미 존재하는 프로젝트 수정 시도입니다.");
	}

// 삭제 메소드 
	public void etfProjectDelete(String s) throws ProjectNotFoundException {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(s)) {
				etfProjectList.remove(etf);
				return;
			}
		}
		throw new ProjectNotFoundException("미 존재하는 프로젝트 삭제 시도입니다.");
	}

// 프로젝트를 정렬하는 메소드 
	public ArrayList<ETFProject> ranketfProjectList() throws ProjectNotFoundException {
		if (etfProjectList.size() == 0)
			throw new ProjectNotFoundException("입력된 Project가 없습니다.");
		Collections.sort(etfProjectList, new ComparatorAsset());
		return etfProjectList;
	}

	/** 프로젝트 참여한 구매자 자산 순위 */
	public ArrayList<ETFCustomer> rankCustomerAsset() throws ProjectNotFoundException {
		if (etfProjectList.size() == 0)
			throw new ProjectNotFoundException("입력된 Project가 없습니다.");
		HashSet<ETFCustomer> cus = new HashSet<ETFCustomer>();
		for (ETFProject etf : etfProjectList) {
			cus.add(etf.getProjectEtfCustomer());
		}
		ArrayList<ETFCustomer> recus = new ArrayList<>(cus);
		Collections.sort(recus, new ComparatorCustomer());
		return recus;
	}

	/**
	 * 구매자 별 프로젝트 구매 수 etfProjectList에는 customer가 반드시 필요하니깐 project가 있는데
	 * ETFCustomer객체가 null인것을 생각하는 것은 Dead Code이다.
	 */
	public HashMap<ETFCustomer, Integer> prc() throws ProjectNotFoundException {
		if (etfProjectList.size() == 0)
			throw new ProjectNotFoundException("입력된 Project가 없습니다.");
		HashMap<ETFCustomer, Integer> maps = new HashMap<ETFCustomer, Integer>();

		HashSet<ETFCustomer> cus = new HashSet<ETFCustomer>();
		ArrayList<ETFCustomer> arr = new ArrayList<ETFCustomer>();

		for (ETFProject etf : etfProjectList) {
			cus.add(etf.getProjectEtfCustomer());
			arr.add(etf.getProjectEtfCustomer());
		}
		ArrayList<ETFCustomer> recus = new ArrayList<ETFCustomer>(cus);

		for (ETFCustomer e : recus) {
			maps.put(e, Collections.frequency(arr, e));
		}
		return maps;
	}

	// 판매자 별 프로젝트 판매 수
	/**
	 * 판매자 별 프로젝트 구매 수 etfProjectList에는 Manger가 반드시 필요하니깐 project가 있는데 ETFManager체가
	 * null인것을 생각하는 것은 Dead Code이다.
	 */

	public HashMap<ETFManager, Integer> prm() throws ProjectNotFoundException {
		if (etfProjectList.size() == 0)
			throw new ProjectNotFoundException("입력된 Project가 없습니다.");
		HashMap<ETFManager, Integer> maps = new HashMap<ETFManager, Integer>();
		HashSet<ETFManager> cus = new HashSet<ETFManager>();
		ArrayList<ETFManager> arr = new ArrayList<ETFManager>();

		for (ETFProject etf : etfProjectList) {
			cus.add(etf.getProjectEtfManager());
			arr.add(etf.getProjectEtfManager());
		}
		ArrayList<ETFManager> recus = new ArrayList<ETFManager>(cus);

		for (ETFManager e : recus) {
			maps.put(e, Collections.frequency(arr, e));
		}
		return maps;
	}

}
