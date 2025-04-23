package com.example.futbol.Service;
import com.example.futbol.Model.Jugador;
import com.example.futbol.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    public Jugador save(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public Jugador findById(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    public void deleteById(long id) {
        jugadorRepository.deleteById(id);
    }

    public boolean delete(Long id) {
        Jugador jugador = findById(id);
        if (jugador != null) {
            jugadorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
