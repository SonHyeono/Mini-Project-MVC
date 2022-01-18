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

	/** �������� Project�� �����ϴ� �迭 */
	private ArrayList<ETFProject> etfProjectList = new ArrayList<ETFProject>();

	private ETFProjectService() {
	}

//	 ��ü ��� �޼ҵ�
	public static ETFProjectService getInstance() {
		return instance;
	}

	/** project �Է� ��� ȣ�� */
	public void etfProjectInsert(ETFProject etf) throws DuplicationProjectException {
		for (ETFProject e : etfProjectList) {
			if (e.getEtfName().equals(etf.getEtfName())) {
				throw new DuplicationProjectException("�̹� �����ϴ� ������Ʈ�Դϴ�.");
			}
		}
		etfProjectList.add(etf);
	}


//  ��ü project ��ȸ	
	public ArrayList<ETFProject> getetfProjectsList() throws ProjectNotFoundException {
		if (etfProjectList.size() == 0) {
			throw new ProjectNotFoundException("Project�� ������ϴ�.");
		} else {
			return etfProjectList;
		}

	}

//	�ϳ��� project�� ��ȸ�Ͽ� ��ȯ
	public ETFProject getetfProject(String e) throws ProjectNotFoundException {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(e)) {
				return etf;
			}
		}
		throw new ProjectNotFoundException("�ش� ������Ʈ�� �������� �ʽ��ϴ�.");
	}

// ���� �޼ҵ� 
	public void etfCustomerUpdate(String s, ETFCustomer etfcustomer) throws ProjectNotFoundException {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(s)) {
				etf.setProjectEtfCustomer(etfcustomer);
				return;
			}
		}
		throw new ProjectNotFoundException("�� �����ϴ� ������Ʈ ���� �õ��Դϴ�.");
	}

//���� �޼ҵ�
	public void etfManagerUpdate(String s, ETFManager manger) throws ProjectNotFoundException {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(s)) {
				etf.setProjectEtfManager(manger);
				return;
			}
		}
		throw new ProjectNotFoundException("�� �����ϴ� ������Ʈ ���� �õ��Դϴ�.");
	}

// ���� �޼ҵ� 
	public void etfProjectDelete(String s) throws ProjectNotFoundException {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(s)) {
				etfProjectList.remove(etf);
				return;
			}
		}
		throw new ProjectNotFoundException("�� �����ϴ� ������Ʈ ���� �õ��Դϴ�.");
	}

// ������Ʈ�� �����ϴ� �޼ҵ� 
	public ArrayList<ETFProject> ranketfProjectList() throws ProjectNotFoundException {
		if (etfProjectList.size() == 0)
			throw new ProjectNotFoundException("�Էµ� Project�� �����ϴ�.");
		Collections.sort(etfProjectList, new ComparatorAsset());
		return etfProjectList;
	}

	/** ������Ʈ ������ ������ �ڻ� ���� */
	public ArrayList<ETFCustomer> rankCustomerAsset() throws ProjectNotFoundException {
		if (etfProjectList.size() == 0)
			throw new ProjectNotFoundException("�Էµ� Project�� �����ϴ�.");
		HashSet<ETFCustomer> cus = new HashSet<ETFCustomer>();
		for (ETFProject etf : etfProjectList) {
			cus.add(etf.getProjectEtfCustomer());
		}
		ArrayList<ETFCustomer> recus = new ArrayList<>(cus);
		Collections.sort(recus, new ComparatorCustomer());
		return recus;
	}

	/**
	 * ������ �� ������Ʈ ���� �� etfProjectList���� customer�� �ݵ�� �ʿ��ϴϱ� project�� �ִµ�
	 * ETFCustomer��ü�� null�ΰ��� �����ϴ� ���� Dead Code�̴�.
	 */
	public HashMap<ETFCustomer, Integer> prc() throws ProjectNotFoundException {
		if (etfProjectList.size() == 0)
			throw new ProjectNotFoundException("�Էµ� Project�� �����ϴ�.");
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

	// �Ǹ��� �� ������Ʈ �Ǹ� ��
	/**
	 * �Ǹ��� �� ������Ʈ ���� �� etfProjectList���� Manger�� �ݵ�� �ʿ��ϴϱ� project�� �ִµ� ETFManagerü��
	 * null�ΰ��� �����ϴ� ���� Dead Code�̴�.
	 */

	public HashMap<ETFManager, Integer> prm() throws ProjectNotFoundException {
		if (etfProjectList.size() == 0)
			throw new ProjectNotFoundException("�Էµ� Project�� �����ϴ�.");
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
