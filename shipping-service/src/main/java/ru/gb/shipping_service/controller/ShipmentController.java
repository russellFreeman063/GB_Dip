package ru.gb.shipping_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.shipping_service.model.Shipment;
import ru.gb.shipping_service.service.ShipmentService;

import java.util.List;

@RestController
@RequestMapping("/api/shipping")
@RequiredArgsConstructor
public class ShipmentController {
    private final ShipmentService shipmentService;

    @GetMapping
    public ResponseEntity<List<Shipment>> getAllShipments() {
        return ResponseEntity.ok(shipmentService.findAll());
    }

    @PostMapping
    public ResponseEntity<Shipment> createShipment(@RequestBody Shipment shipment) {
        shipment.setStatus("SHIPPED");
        return ResponseEntity.ok(shipmentService.save(shipment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipment> getShipmentById(@PathVariable Long id) {
        return ResponseEntity.ok(shipmentService.findById(id));
    }
}
