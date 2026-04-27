package edu.usco.parqueadero.model;

import jakarta.persistence.*;

@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 6) // Requerimiento: No superar 6 caracteres [cite: 7]
    private String placa;

    private Integer horaEntrada; // Requerimiento: Campo numérico [cite: 8]
    private Integer horaSalida;  // Requerimiento: Editable al salir [cite: 9]
    private String ubicacion;    // Requerimiento: Alfanumérico [cite: 10]

    @ManyToOne // Relación con la tabla independiente 
    private TipoVehiculo tipo;

    // --- GETTERS Y SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public Integer getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(Integer horaEntrada) { this.horaEntrada = horaEntrada; }
    public Integer getHoraSalida() { return horaSalida; }
    public void setHoraSalida(Integer horaSalida) { this.horaSalida = horaSalida; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public TipoVehiculo getTipo() { return tipo; }
    public void setTipo(TipoVehiculo tipo) { this.tipo = tipo; }
}