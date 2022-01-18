package financial.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import financial.model.dto.ETFCustomer;
import financial.model.dto.ETFManager;
import financial.model.dto.ETFProject;

public class SuccessView {

	public static void projectListView(ArrayList<ETFProject> getetfProjectsList) {
		int index = 1;
		for (ETFProject list : getetfProjectsList) {
			System.out.println("[���� ���� project : " + index + "] " + list);
			index++;
		}
	}

	public static void projectView(ETFProject getetfProject) {
		System.out.println(getetfProject);
	}

	public static void successView(String s) {
			System.out.println("Issue : " + s);
	}
	
	public static void projectRankView(ArrayList<ETFProject> getetfProjectsList) {
		int index = 1;
		for (ETFProject list : getetfProjectsList) {
			System.out.println("[ ���� �ڻ� ��� : " + index + "��] " + list.getEtfName());
			index++;
		}
		}

	public static void customerRankView(ArrayList<ETFCustomer> rankCustomerAsset) {
		Iterator<ETFCustomer> all = rankCustomerAsset.iterator();
		ETFCustomer v = null;
		int index =1;
		while(all.hasNext()) {
			v = all.next();
			System.out.println("[ ���� �ڻ� ��� : " + index + "��] " +v.getName() + " , �ڻ� :" + v.getAsset()); 
			index++;
	}

	}

	public static void prcView(HashMap<ETFCustomer,Integer> prc) {
		Set<Entry<ETFCustomer, Integer>> set2 = prc.entrySet(); 
		Iterator<Entry<ETFCustomer, Integer>> iterator2 = set2.iterator();

		while(iterator2.hasNext()){
			Entry<ETFCustomer,Integer> entry = iterator2.next(); 
			ETFCustomer key = entry.getKey(); 
			int value = (Integer)entry.getValue(); 
			System.out.println("������ : " +key.getName()+ " , �� ������Ʈ ���ŷ� : " + value);
		}
	}

	public static void prmView(HashMap<ETFManager, Integer> prm) {
		Set<Entry<ETFManager, Integer>> set2 = prm.entrySet(); 
		Iterator<Entry<ETFManager, Integer>> iterator2 = set2.iterator();

		while(iterator2.hasNext()){
			Entry<ETFManager,Integer> entry = iterator2.next(); 
			ETFManager key = entry.getKey(); 
			int value = (Integer)entry.getValue(); 
			System.out.println("�Ǹ��� : " +key.getName()+ " , �� ������Ʈ �Ǹŷ� : " + value);
		}
	}

}
