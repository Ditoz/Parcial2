package com.example.futbol.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_entrenador;

    private String nombre;
    private String especialidad;
    private int id_equipo;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;


}
