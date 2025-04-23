package com.example.futbol.Service;
import com.example.futbol.Model.Equipo;
import com.example.futbol.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo findById(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }

    public void deleteById(long id) {
        equipoRepository.deleteById(id);
    }

    public boolean delete(Long id) {
        Equipo equipo = findById(id);
        if (equipo != null) {
            equipoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
