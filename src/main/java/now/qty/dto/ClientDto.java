package now.qty.dto;

import lombok.*;
import now.qty.entity.BankAccountEntity;
import now.qty.entity.PriceLevelEntity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ClientDto {
    private Integer id;
    private String name;
    private Boolean isLegal;
    private Boolean isVatPayer;
    private Integer addressId;
    private String regNumber;
    private String vatNumber;
    private BankAccountEntity bankAccount;
    private PriceLevelEntity priceLevel;
}
