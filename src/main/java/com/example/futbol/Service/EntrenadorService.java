package com.example.futbol.Service;
import com.example.futbol.Model.Entrenador;
import com.example.futbol.Repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public List<Entrenador> findAll() {
        return entrenadorRepository.findAll();
    }

    public Entrenador save(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador findById(Long id) {
        return entrenadorRepository.findById(id).orElse(null);
    }

    public void deleteById(long id) {
        entrenadorRepository.deleteById(id);
    }

    public boolean delete(Long id) {
        Entrenador entrenador = findById(id);
        if (entrenador != null) {
            entrenadorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
