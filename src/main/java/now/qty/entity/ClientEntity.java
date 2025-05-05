package now.qty.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class ClientEntity {
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
