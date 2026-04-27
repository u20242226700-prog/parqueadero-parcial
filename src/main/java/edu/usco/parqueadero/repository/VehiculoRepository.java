package edu.usco.parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.usco.parqueadero.model.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}