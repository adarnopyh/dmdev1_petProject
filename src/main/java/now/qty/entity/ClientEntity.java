package now.qty.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
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


    @Override
    public String toString() {
        return "ClientEntity{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", isLegal=" + isLegal +
               ", isVatPayer=" + isVatPayer +
               ", addressId=" + addressId +
               ", regNumber='" + regNumber + '\'' +
               ", vatNumber='" + vatNumber + '\'' +
               ", bankAccountId=" + bankAccount +
               ", priceLevelId=" + priceLevel +
               '}' + "\n";
    }
}
