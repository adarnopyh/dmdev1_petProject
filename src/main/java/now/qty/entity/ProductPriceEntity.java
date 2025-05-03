package now.qty.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ProductPriceEntity {
    private Integer id;
    private ProductEntity product;
    private PriceLevelEntity priceLevel;
    private Double price;
}
