package com.example.futbol.Service;
import com.example.futbol.Model.Partido;
import com.example.futbol.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> findAll() {
        return partidoRepository.findAll();
    }

    public Partido save(Partido partido) {
        return partidoRepository.save(partido);
    }

    public Partido findById(Long id) {
        return partidoRepository.findById(id).orElse(null);
    }

    public void deleteById(long id) {
        partidoRepository.deleteById(id);
    }

    public boolean delete(Long id) {
        Partido partido = findById(id);
        if (partido != null) {
            partidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
