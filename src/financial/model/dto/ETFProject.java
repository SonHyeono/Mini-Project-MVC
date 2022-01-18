package financial.model.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ETFProject {
	/** ETF 이름 */
	private String etfName;
	
	/** ETF DTO */
	private ETF projectEtf;

	/** ETF 구매자 */
	private ETFCustomer projectEtfCustomer;
	
	/** ETF 판매자 */
	private ETFManager projectEtfManager;
	
	/** 프로젝트 시작일 */
	private String startDate;

	/** 진행되는 project의 상세 내용 */
	private String EtfProjectDetail;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(System.getProperty("line.separator"));
		builder.append("ETFProject [etfName=");
		builder.append(etfName);
		builder.append(System.getProperty("line.separator"));
		builder.append("ETF 객체 : ");
		builder.append(projectEtf);
		builder.append(System.getProperty("line.separator"));
		builder.append("구매자 : ");
		builder.append(projectEtfCustomer);
		builder.append(System.getProperty("line.separator"));
		builder.append("판매자 : ");
		builder.append(projectEtfManager);
		builder.append(System.getProperty("line.separator"));
		builder.append("ETF 매수한 날짜 : ");
		builder.append(startDate);
		builder.append(", 프로젝트 상세 사항 : ");
		builder.append(EtfProjectDetail);
		builder.append("]");
		builder.append(System.getProperty("line.separator"));
		return builder.toString();
	}
}
