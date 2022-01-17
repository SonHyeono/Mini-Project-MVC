package financial.service;

import java.util.ArrayList;

import financial.model.dto.ETFCustomer;
import financial.model.dto.ETFManager;
import financial.model.dto.ETFProject;

public class ETFProjectService {
	private static ETFProjectService instance = new ETFProjectService();

	/** �������� Project�� �����ϴ� �迭 */
	private ArrayList<ETFProject> etfProjectList = new ArrayList<ETFProject>();

	private ETFProjectService() {
	}

	public static ETFProjectService getInstance() {
		return instance;
	}
	/** project ���� ��� ȣ�� */
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
		//������� ����ó��
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
