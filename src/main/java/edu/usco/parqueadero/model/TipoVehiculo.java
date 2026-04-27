package edu.usco.parqueadero.model;

import jakarta.persistence.*;

@Entity
public class TipoVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre; // Ejemplo: Carro, Moto, Bicicleta

    // Generar Getters y Setters (Tip: Clic derecho -> Source -> Generate Getters and Setters)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}