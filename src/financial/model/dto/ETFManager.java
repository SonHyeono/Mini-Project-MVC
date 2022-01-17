package financial.model.dto;

public class ETFManager {
	/** �Ǹ��� �̸� */
	private String Name;
	/** �Ǹ��� ���� */
	private int Age;
	/** �Ǹ��� ���� */
	private String rank;
	/** �Ǹ��� �޴��� ��ȣ */
	private String PhoneNumber;
	
	public ETFManager() {
		super();
	}

	public ETFManager(String name, int age, String rank, String phoneNumber) {
		super();
		Name = name;
		Age = age;
		this.rank = rank;
		PhoneNumber = phoneNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ETFManager [Name=");
		builder.append(Name);
		builder.append(", Age=");
		builder.append(Age);
		builder.append(", rank=");
		builder.append(rank);
		builder.append(", PhoneNumber=");
		builder.append(PhoneNumber);
		builder.append("]");
		return builder.toString();
	}
	
	
}
