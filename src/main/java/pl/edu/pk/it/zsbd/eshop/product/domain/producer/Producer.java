package pl.edu.pk.it.zsbd.eshop.product.domain.producer;

public record Producer(ProducerId id, String name, Mail mail, PhoneNumber phoneNumber) {
    public Producer {
        if (name == null || mail == null || phoneNumber == null) {
            throw new IllegalArgumentException("Producer cannot have null fields");
        }
    }
}
