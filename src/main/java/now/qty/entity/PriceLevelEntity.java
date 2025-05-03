package now.qty.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class PriceLevelEntity {
    private Integer id;
    private String code;
}
