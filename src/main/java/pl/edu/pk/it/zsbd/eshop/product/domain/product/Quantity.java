package pl.edu.pk.it.zsbd.eshop.product.domain.product;

public record Quantity(int value) {
    public Quantity {
        if (value < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
    }
}
