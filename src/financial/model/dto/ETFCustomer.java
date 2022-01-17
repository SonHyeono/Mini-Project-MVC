package financial.model.dto;

public class ETFCustomer {
	/** ������ �̸� */
	private String Name;
	
	/** ������ ���� */
	private int Age;
	
	/** ������ �ڻ� */
	private String asset;
	
	/** ������ �޴�����ȣ */
	private String PhoneNumber;
	
	public ETFCustomer() {
		super();
	}
	public ETFCustomer(String name, int age, String asset, String phoneNumber) {
		super();
		Name = name;
		Age = age;
		this.asset = asset;
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
	public String getAsset() {
		return asset;
	}
	public void setAsset(String asset) {
		this.asset = asset;
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
		builder.append("ETFCustomer [Name=");
		builder.append(Name);
		builder.append(", Age=");
		builder.append(Age);
		builder.append(", asset=");
		builder.append(asset);
		builder.append(", PhoneNumber=");
		builder.append(PhoneNumber);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
