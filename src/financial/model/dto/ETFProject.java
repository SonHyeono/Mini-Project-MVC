package financial.model.dto;

public class ETFProject {
	/** ETF �̸� */
	private String etfName;
	
	/** ETF DTO */
	private ETF projectEtf;

	/** ETF ������ */
	private ETFCustomer projectEtfCustomer;
	
	/** ETF �Ǹ��� */
	private ETFManager projectEtfManager;
	
	/** ������Ʈ ������ */
	private String startDate;

	/** ����Ǵ� project�� �� ���� */
	private String EtfProjectDetail;

	public ETFProject() {
		super();
	}

	public ETFProject(String etfName, ETF projectEtf, ETFCustomer projectEtfCustomer, ETFManager projectEtfManager,
			String startDate, String etfProjectDetail) {
		super();
		this.etfName = etfName;
		this.projectEtf = projectEtf;
		this.projectEtfCustomer = projectEtfCustomer;
		this.projectEtfManager = projectEtfManager;
		this.startDate = startDate;
		EtfProjectDetail = etfProjectDetail;
	}

	public String getEtfName() {
		return etfName;
	}

	public void setEtfName(String etfName) {
		this.etfName = etfName;
	}

	public ETF getProjectEtf() {
		return projectEtf;
	}

	public void setProjectEtf(ETF projectEtf) {
		this.projectEtf = projectEtf;
	}

	public ETFCustomer getProjectEtfCustomer() {
		return projectEtfCustomer;
	}

	public void setProjectEtfCustomer(ETFCustomer projectEtfCustomer) {
		this.projectEtfCustomer = projectEtfCustomer;
	}

	public ETFManager getProjectEtfManager() {
		return projectEtfManager;
	}

	public void setProjectEtfManager(ETFManager projectEtfManager) {
		this.projectEtfManager = projectEtfManager;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEtfProjectDetail() {
		return EtfProjectDetail;
	}

	public void setEtfProjectDetail(String etfProjectDetail) {
		EtfProjectDetail = etfProjectDetail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ETFProject [etfName=");
		builder.append(etfName);
		builder.append(", projectEtf=");
		builder.append(projectEtf);
		builder.append(", projectEtfCustomer=");
		builder.append(projectEtfCustomer);
		builder.append(", projectEtfManager=");
		builder.append(projectEtfManager);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", EtfProjectDetail=");
		builder.append(EtfProjectDetail);
		builder.append("]");
		return builder.toString();
	}
	
	
}
