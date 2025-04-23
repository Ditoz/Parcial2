package com.example.futbol.Repository;

import com.example.futbol.Model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {



        @Query(value = "SELECT * FROM entrenador WHERE nombre LIKE %:nombre%", nativeQuery = true)
        List<Entrenador> buscarPorNombre(@Param("nombre") String nombre);

        @Query(value = "SELECT * FROM entrenador ORDER BY nombre ASC", nativeQuery = true)
        List<Entrenador> listarOrdenadosPorNombre();
    }



