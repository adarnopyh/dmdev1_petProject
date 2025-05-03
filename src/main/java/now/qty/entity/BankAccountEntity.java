package now.qty.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class BankAccountEntity {
    private Integer id;
    private String iban;
    private String bankName;
    private String swiftCode;
}
