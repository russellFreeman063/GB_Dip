package ru.gb.shipping_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.shipping_service.model.Shipment;
import ru.gb.shipping_service.repository.ShipmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentService {
    private final ShipmentRepository shipmentRepository;

    public List<Shipment> findAll() {
        return shipmentRepository.findAll();
    }

    public Shipment save(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public Shipment findById(Long id) {
        return shipmentRepository.findById(id).orElse(null);
    }

}