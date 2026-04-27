package edu.usco.parqueadero.controller;

import edu.usco.parqueadero.model.Vehiculo;
import edu.usco.parqueadero.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VehiculoController {

    @Autowired
    private VehiculoRepository repository;

    // Acción para el ADMINISTRADOR
    @PostMapping("/admin/registrar")
    public String registrar(Vehiculo vehiculo) {
        // Validación de placa manual por si acaso
        if (vehiculo.getPlaca() != null && vehiculo.getPlaca().length() <= 6) {
            repository.save(vehiculo);
        }
        return "redirect:/home";
    }

    // Acción para el ACOMODADOR
    @PostMapping("/acomodador/actualizar")
    public String actualizarUbicacion(@RequestParam Long id, @RequestParam String ubicacion) {
        Vehiculo v = repository.findById(id).orElseThrow();
        v.setUbicacion(ubicacion);
        repository.save(v);
        return "redirect:/home";
    }
}