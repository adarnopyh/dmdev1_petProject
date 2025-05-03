package now.qty.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ProductEntity {
    private Integer id;
    private String name;
    private String sku;
}
