package pl.edu.pk.it.zsbd.eshop.product.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.it.zsbd.eshop.product.application.producer.ProducerService;
import pl.edu.pk.it.zsbd.eshop.product.application.producer.dto.AddProducerDto;
import pl.edu.pk.it.zsbd.eshop.product.application.producer.dto.ProducerDto;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/producers")
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @GetMapping("/producer/{id}")
    public ProducerDto getProducerById(@PathVariable UUID id) {
        return producerService.getProducersById(id);
    }

    @GetMapping()
    public List<ProducerDto> getProducers() {
        return producerService.getAllProducers();
    }

    @PostMapping("/producer")
    public ProducerDto addProducer(@RequestBody AddProducerDto producer) {
        return producerService.addProducer(producer);
    }

    @DeleteMapping("/producer/{id}")
    public ResponseEntity<Void> deleteProducer(@PathVariable UUID id) {
        producerService.deleteProducer(id);
        return ResponseEntity.ok().build();
    }
}