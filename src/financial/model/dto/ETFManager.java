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

public class ETFManager {
	/** 판매자 이름 */
	private String Name;
	
	/** 판매자 나이 */
	private int Age;
	
	/** 판매자 직급 */
	private String rank;
	
	/** 판매자 휴대폰 번호 */
	private String PhoneNumber;
}
