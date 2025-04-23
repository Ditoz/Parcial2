package com.example.futbol.Controller;

import com.example.futbol.Model.Jugador;
import com.example.futbol.Service.JugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
@RequiredArgsConstructor
public class JugadorController {

    private final JugadorService jugadorService;

    @GetMapping
    public List<Jugador> findAll() {
        return jugadorService.findAll();
    }

    @PostMapping
    public Jugador save(@RequestBody Jugador jugador) {
        return jugadorService.save(jugador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> findById(@PathVariable Long id) {
        Jugador jugador = jugadorService.findById(id);
        return jugador != null ? ResponseEntity.ok(jugador) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> update(@PathVariable Long id, @RequestBody Jugador actualizado) {
        Jugador existente = jugadorService.findById(id);
        if (existente != null) {

            return ResponseEntity.ok(jugadorService.save(existente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return jugadorService.delete(id) ?
                ResponseEntity.ok("Jugador eliminado.") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
    }
}
