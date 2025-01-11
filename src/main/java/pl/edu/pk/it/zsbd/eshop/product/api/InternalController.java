package pl.edu.pk.it.zsbd.eshop.product.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.it.zsbd.eshop.product.tools.DataLoader;

@RequiredArgsConstructor
@RestController
@RequestMapping("/internal")
public class InternalController {
    private final DataLoader dataLoader;

    @PostMapping("/load/orders/{entitiesCount}")
    public void loadOrders(@PathVariable int entitiesCount) {
        dataLoader.loadOrders(entitiesCount);
    }
}
