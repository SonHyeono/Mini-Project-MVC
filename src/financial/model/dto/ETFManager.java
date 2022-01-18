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
	/** �Ǹ��� �̸� */
	private String Name;
	
	/** �Ǹ��� ���� */
	private int Age;
	
	/** �Ǹ��� ���� */
	private String rank;
	
	/** �Ǹ��� �޴��� ��ȣ */
	private String PhoneNumber;
}
