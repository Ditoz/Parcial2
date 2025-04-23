package com.example.futbol.Repository;
import com.example.futbol.Model.Estadisticas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadisticasRepository extends JpaRepository<Estadisticas, Long> {




        @Query(value = "SELECT * FROM estadisticas WHERE jugador_id = :jugadorId", nativeQuery = true)
        List<Estadisticas> obtenerPorJugador(@Param("jugadorId") Long jugadorId);

        @Query(value = "SELECT AVG(goles) FROM estadisticas", nativeQuery = true)
        Double promedioGoles();
    }




