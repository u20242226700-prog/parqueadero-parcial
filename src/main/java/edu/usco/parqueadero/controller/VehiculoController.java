package edu.usco.parqueadero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.usco.parqueadero.entity.Vehiculo;
import edu.usco.parqueadero.repository.VehiculoRepository;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoRepository repository;

    @PostMapping("/admin/registrar")
    public String registrar(@RequestBody Vehiculo vehiculo) {
        if (vehiculo.getPlaca() != null) {
            repository.save(vehiculo);
        }
        return "Vehículo registrado correctamente";
    }

    @PostMapping("/acomodador/actualizar")
    public String actualizarUbicacion(@RequestParam Long id, @RequestParam String ubicacion) {
        Vehiculo v = repository.findById(id).orElseThrow();
        v.setUbicacion(ubicacion);
        repository.save(v);
        return "Ubicación actualizada";
    }
}