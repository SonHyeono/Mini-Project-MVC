package financial.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ETF {
	/** ETF Ÿ�� */
	private String etfType;
	
	/** ETF ���� */
	private String etfComPany;
	
	/** ETF �����Ⱓ */
	private String etfPeriod;
	
	/** ETF ���ڻ� */
	private String asset;
}
