package financial.service;
import java.util.Comparator;


import financial.model.dto.ETFCustomer;

public class ComparatorCustomer implements Comparator<ETFCustomer>{
	@Override
	public int compare(ETFCustomer o1, ETFCustomer o2) {

		int result = 1;
		if (Integer.parseInt(o1.getAsset().replaceAll("[^\\d]", "")) >= Integer
				.parseInt(o2.getAsset().replaceAll("[^\\d]", "")))
			result = -1;
		return result;
	}
}
