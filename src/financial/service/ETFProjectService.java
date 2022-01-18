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

	// ��ü project ��ȯ
	public ArrayList<ETFProject> getetfProjectsList() {
		return etfProjectList;

	}

//	�ϳ��� project�� ��ȸ�Ͽ� ��ȯ
	public ETFProject getetfProject(String e) {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(e)) {
				return etf;
			}
		}
		return null;

	}

// ���� �޼ҵ� 
	public boolean etfCustomerUpdate(String s, ETFCustomer etfcustomer) {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(s)) {
				etf.setProjectEtfCustomer(etfcustomer);
				return true;
			}
		}
		return false;
	}

//���� �޼ҵ�
	public boolean etfManagerUpdate(String s, ETFManager manger) {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(s)) {
				etf.setProjectEtfManager(manger);
				return true;
			}
		}
		return false;
	}

// ���� �޼ҵ� 
	public boolean etfProjectDelete(String s) {
		for (ETFProject etf : etfProjectList) {
			if (etf.getEtfName().equals(s)) {
				etfProjectList.remove(etf);
				return true;
			}
		}
		return false;
	}

// ������Ʈ�� �����ϴ� �޼ҵ� 
	public ArrayList<ETFProject> ranketfProjectList() {
		Collections.sort(etfProjectList, new ComparatorAsset());
		return etfProjectList;
	}

	// ������Ʈ ������ ������ �ڻ� ����
	public ArrayList<ETFCustomer> rankCustomerAsset() {
		
		HashSet<ETFCustomer> cus = new HashSet<ETFCustomer>();
		
		for(ETFProject etf : etfProjectList) {
			cus.add(etf.getProjectEtfCustomer());
		}
        ArrayList<ETFCustomer> recus = new ArrayList<>(cus);
        Collections.sort(recus, new ComparatorCustomer());
		return recus;
	}
	
	// ������ �� ������Ʈ ���� ��
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
	
	// �Ǹ��� �� ������Ʈ �Ǹ� ��
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
