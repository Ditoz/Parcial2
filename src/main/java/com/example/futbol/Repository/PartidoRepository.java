package com.example.futbol.Repository;


import com.example.futbol.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {


        @Query(value = "SELECT * FROM partido WHERE fecha BETWEEN :inicio AND :fin", nativeQuery = true)
        List<Partido> buscarPorRangoFechas(@Param("inicio") String inicio, @Param("fin") String fin);

        @Query(value = "SELECT * FROM partido WHERE equipo_local_id = :equipoId OR equipo_visitante_id = :equipoId", nativeQuery = true)
        List<Partido> partidosPorEquipo(@Param("equipoId") Long equipoId);
    }




