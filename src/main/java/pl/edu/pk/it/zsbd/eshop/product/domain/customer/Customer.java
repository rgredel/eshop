package pl.edu.pk.it.zsbd.eshop.product.domain.customer;

import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class Customer {
    private CustomerId id;
    private String firstName;
    private String lastName;

    public Customer(CustomerId id, String firstName, String lastName) {
        Assert.notNull(firstName, "First name cannot be null");
        Assert.notNull(lastName, "Last name cannot be null");
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
