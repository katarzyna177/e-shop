package pl.kate.eshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Product {
    private String name;
    private BigDecimal price;

}
