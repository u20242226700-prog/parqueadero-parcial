package edu.usco.parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.usco.parqueadero.model.TipoVehiculo;

public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculo, Long> {
}