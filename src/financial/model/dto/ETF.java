package financial.model.dto;

public class ETF {
	/** ETF Ÿ�� */
	private String etfType;
	
	/** ETF ���� */
	private String etfComPany;
	
	/** ETF �����Ⱓ */
	private String etfPeriod;
	
	/** ETF ���ڻ� */
	private String asset;
	
	
	public ETF() {
		super();
	}

	public ETF(String etfType, String etfComPany, String etfPeriod, String asset) {
		super();
		this.etfType = etfType;
		this.etfComPany = etfComPany;
		this.etfPeriod = etfPeriod;
		this.asset = asset;
	}

	public String getEtfType() {
		return etfType;
	}

	public void setEtfType(String etfType) {
		this.etfType = etfType;
	}

	public String getEtfComPany() {
		return etfComPany;
	}

	public void setEtfComPany(String etfComPany) {
		this.etfComPany = etfComPany;
	}

	public String getEtfPeriod() {
		return etfPeriod;
	}

	public void setEtfPeriod(String etfPeriod) {
		this.etfPeriod = etfPeriod;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ETF [etfType=");
		builder.append(etfType);
		builder.append(", etfComPany=");
		builder.append(etfComPany);
		builder.append(", etfPeriod=");
		builder.append(etfPeriod);
		builder.append(", asset=");
		builder.append(asset);
		builder.append("]");
		return builder.toString();
	}
	
}
