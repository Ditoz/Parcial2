package com.example.futbol.Controller;

import com.example.futbol.Model.Entrenador;
import com.example.futbol.Service.EntrenadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/entrenadores")
@RequiredArgsConstructor
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @GetMapping
    public List<Entrenador> findAll() {
        return entrenadorService.findAll();
    }

    @PostMapping
    public Entrenador save(@RequestBody Entrenador entrenador) {
        return entrenadorService.save(entrenador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> findById(@PathVariable Long id) {
        Entrenador entrenador = entrenadorService.findById(id);
        return entrenador != null ? ResponseEntity.ok(entrenador) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> update(@PathVariable Long id, @RequestBody Entrenador actualizado) {
        Entrenador existente = entrenadorService.findById(id);
        if (existente != null) {
            existente.setNombre(actualizado.getNombre());

            return ResponseEntity.ok(entrenadorService.save(existente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return entrenadorService.delete(id) ?
                ResponseEntity.ok("Entrenador eliminado.") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
    }
}
