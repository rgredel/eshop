package pl.edu.pk.it.zsbd.eshop.product.domain.product;

import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * Price of the product in PLN
 */
public record Price(BigDecimal value) {
    public Price {
        Assert.notNull(value, "Price cannot be null");
        if (value.compareTo(new BigDecimal("0.01")) < 0) {
            throw new IllegalArgumentException("Minimal price is 0,01 PLN");
        }
    }

}
