package com.example.futbol.Controller;

import com.example.futbol.Model.Partido;
import com.example.futbol.Service.PartidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
@RequiredArgsConstructor
public class PartidoController {

    private final PartidoService partidoService;

    @GetMapping
    public List<Partido> findAll() {
        return partidoService.findAll();
    }

    @PostMapping
    public Partido save(@RequestBody Partido partido) {
        return partidoService.save(partido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> findById(@PathVariable Long id) {
        Partido partido = partidoService.findById(id);
        return partido != null ? ResponseEntity.ok(partido) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> update(@PathVariable Long id, @RequestBody Partido actualizado) {
        Partido existente = partidoService.findById(id);
        if (existente != null) {

            return ResponseEntity.ok(partidoService.save(existente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return partidoService.delete(id) ?
                ResponseEntity.ok("Partido eliminado.") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
    }
}
