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
			System.out.println("[진행 중인 project : " + (getetfProjectsList.indexOf(n) + 1) + "] " + n);
		});
	}

	public static void successView(String s) {
		System.out.println("Issue : " + s);
	}

	public static void projectRankView(ArrayList<ETFProject> getetfProjectsList) {

		getetfProjectsList.forEach((n) -> {
			System.out.println("[ 개인 자산 등수 : " + (getetfProjectsList.indexOf(n) + 1) + "등] " + n.getEtfName());
		});

	}

	public static void customerRankView(ArrayList<ETFCustomer> rankCustomerAsset) {

		rankCustomerAsset.forEach((n) -> {
			System.out.println("[ 개인 자산 등수 : " + (rankCustomerAsset.indexOf(n) + 1) + "등] " + n.getName() + " , 자산 :"
					+ n.getAsset());
		});

	}

	public static void prcView(HashMap<ETFCustomer, Integer> prc) {

		prc.forEach((n, a) -> {
			System.out.println("구매자 : " + n.getName() + " , 총 프로젝트 구매량 : " + a);
		});

	}

	public static void prmView(HashMap<ETFManager, Integer> prm) {

		prm.forEach((n, a) -> {
			System.out.println("판매자 : " + n.getName() + " , 총 프로젝트 판매량 : " + a);
		});

	}

}
