package com.example.futbol.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
    public class Jugador {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id_jugador;

        private String nombre;
        private String posicion;
        private Double dorsal;
        private LocalDate fecha_nac;
    private String nacionalidad;
    private int id_equipo;



    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador")
    private List<Estadisticas> estadisticas;
}
