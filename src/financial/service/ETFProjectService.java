package financial.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

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

		boolean anyMatch = etfProjectList.stream().anyMatch(s -> s.getEtfName().equals(etf.getEtfName()));

		if (anyMatch) {
			throw new DuplicationProjectException("�̹� �����ϴ� ������Ʈ�Դϴ�.");
		} else {
			etfProjectList.add(etf);
		}
	}

//  ��ü project ��ȸ	
	public ArrayList<ETFProject> getetfProjectsList() throws ProjectNotFoundException {

		int x = etfProjectList.size();        //int x = (int) etfProjectList.stream().count();
		
		if (x != 0) {
			return etfProjectList;
		} else {
			throw new ProjectNotFoundException("Project�� ������ϴ�.");
		}

	}

//	�ϳ��� project�� ��ȸ�Ͽ� ��ȯ
	public ETFProject getetfProject(String e) throws ProjectNotFoundException {
		
		Optional<ETFProject> etf = etfProjectList.stream().filter(s -> s.getEtfName().equals(e)).findAny();
		
		if(!etf.isPresent()) {
			throw new ProjectNotFoundException("�ش� ������Ʈ�� �������� �ʽ��ϴ�.");
		}
		return etf.get();
	}

// ���� �޼ҵ� 
	public void etfCustomerUpdate(String s, ETFCustomer etfcustomer) throws ProjectNotFoundException {

		Optional<ETFProject> etf = etfProjectList.stream().filter(e -> e.getEtfName().equals(s)).findAny();
		
		if(!etf.isPresent()) {
			throw new ProjectNotFoundException("�� �����ϴ� ������Ʈ ���� �õ��Դϴ�.");
		}
		etf.get().setProjectEtfCustomer(etfcustomer);
	}

//���� �޼ҵ�
	public void etfManagerUpdate(String s, ETFManager manger) throws ProjectNotFoundException {
		
		Optional<ETFProject> etf = etfProjectList.stream().filter(e -> e.getEtfName().equals(s)).findAny();

		if(!etf.isPresent()) {
			throw new ProjectNotFoundException("�� �����ϴ� ������Ʈ ���� �õ��Դϴ�.");
		}
		etf.get().setProjectEtfManager(manger);
		
	}

// ���� �޼ҵ� 
	public void etfProjectDelete(String s) throws ProjectNotFoundException {
		Optional<ETFProject> etf = etfProjectList.stream().filter(e -> e.getEtfName().equals(s)).findAny();

		if(!etf.isPresent()) {
			throw new ProjectNotFoundException("�� �����ϴ� ������Ʈ ���� �õ��Դϴ�.");
		}
		etfProjectList.remove(etf.get());
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
		
		etfProjectList.stream().forEach(n -> cus.add(n.getProjectEtfCustomer()));

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

		etfProjectList.stream().forEach(n -> { 
			cus.add(n.getProjectEtfCustomer());
			arr.add(n.getProjectEtfCustomer());
		});
		
		ArrayList<ETFCustomer> recus = new ArrayList<ETFCustomer>(cus);

		recus.stream().forEach(e ->maps.put(e, Collections.frequency(arr, e)));
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

		etfProjectList.stream().forEach(n -> { 
			cus.add(n.getProjectEtfManager());
			arr.add(n.getProjectEtfManager());
		});
		ArrayList<ETFManager> recus = new ArrayList<ETFManager>(cus);

		recus.stream().forEach(e ->maps.put(e, Collections.frequency(arr, e)));
		
		return maps;
	}

}
