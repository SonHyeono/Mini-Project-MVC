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
	/** ETF 타입 */
	private String etfType;
	
	/** ETF 운용사 */
	private String etfComPany;
	
	/** ETF 설정기간 */
	private String etfPeriod;
	
	/** ETF 순자산 */
	private String asset;
}
