package com.example.futbol.Service;
import com.example.futbol.Model.Estadisticas;
import com.example.futbol.Repository.EstadisticasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticasService {

    @Autowired
    private EstadisticasRepository estadisticasRepository;

    public List<Estadisticas> findAll() {
        return estadisticasRepository.findAll();
    }

    public Estadisticas save(Estadisticas estadisticas) {
        return estadisticasRepository.save(estadisticas);
    }

    public Estadisticas findById(Long id) {
        return estadisticasRepository.findById(id).orElse(null);
    }

    public void deleteById(long id) {
        estadisticasRepository.deleteById(id);
    }

    public boolean delete(Long id) {
        Estadisticas estadisticas = findById(id);
        if (estadisticas != null) {
            estadisticasRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
