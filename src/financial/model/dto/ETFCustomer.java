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

public class ETFCustomer {
	/** ������ �̸� */
	private String Name;
	
	/** ������ ���� */
	private int Age;
	
	/** ������ �ڻ� */
	private String asset;
	
	/** ������ �޴�����ȣ */
	private String PhoneNumber;
}
