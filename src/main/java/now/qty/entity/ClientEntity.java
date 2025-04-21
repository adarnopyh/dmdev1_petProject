package now.qty.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ClientEntity {
    private int id;
    private String name;
    private boolean isLegal;
    private Boolean isVatPayer;
    private Integer addressId;
    private String regNumber;
    private String vatNumber;
    private Integer bankAccountId;
    private Integer priceLevelId;


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
               ", bankAccountId=" + bankAccountId +
               ", priceLevelId=" + priceLevelId +
               '}' + "\n";
    }
}
