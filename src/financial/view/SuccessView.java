package financial.view;

import java.util.ArrayList;
import java.util.HashMap;

import financial.model.dto.ETFCustomer;
import financial.model.dto.ETFManager;
import financial.model.dto.ETFProject;

public class SuccessView {

	public static void projectView(ETFProject getetfProject) {
		System.out.println(getetfProject);
	}

	public static void projectListView(ArrayList<ETFProject> getetfProjectsList) {
		getetfProjectsList.forEach((n) -> {
			System.out.println("[���� ���� project : " + (getetfProjectsList.indexOf(n) + 1) + "] " + n);
		});
	}

	public static void successView(String s) {
		System.out.println("Issue : " + s);
	}

	public static void projectRankView(ArrayList<ETFProject> getetfProjectsList) {

		getetfProjectsList.forEach((n) -> {
			System.out.println("[ ���� �ڻ� ��� : " + (getetfProjectsList.indexOf(n) + 1) + "��] " + n.getEtfName());
		});

	}

	public static void customerRankView(ArrayList<ETFCustomer> rankCustomerAsset) {

		rankCustomerAsset.forEach((n) -> {
			System.out.println("[ ���� �ڻ� ��� : " + (rankCustomerAsset.indexOf(n) + 1) + "��] " + n.getName() + " , �ڻ� :"
					+ n.getAsset());
		});

	}

	public static void prcView(HashMap<ETFCustomer, Integer> prc) {

		prc.forEach((n, a) -> {
			System.out.println("������ : " + n.getName() + " , �� ������Ʈ ���ŷ� : " + a);
		});

	}

	public static void prmView(HashMap<ETFManager, Integer> prm) {

		prm.forEach((n, a) -> {
			System.out.println("�Ǹ��� : " + n.getName() + " , �� ������Ʈ �Ǹŷ� : " + a);
		});

	}

}
