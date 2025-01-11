package pl.edu.pk.it.zsbd.eshop.product.domain.producer;

public record Mail(String value) {
    public Mail {
        if (value == null || value.isBlank() || !value.contains("@") || !value.contains(".")) {
            throw new IllegalArgumentException("Invalid value address");
        }
    }
}
