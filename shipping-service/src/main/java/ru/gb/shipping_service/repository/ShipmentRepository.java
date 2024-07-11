package ru.gb.shipping_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.shipping_service.model.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}