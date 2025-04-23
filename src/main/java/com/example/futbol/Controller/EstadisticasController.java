package com.example.futbol.Controller;

import com.example.futbol.Model.Estadisticas;
import com.example.futbol.Service.EstadisticasService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadisticas")
@RequiredArgsConstructor
public class EstadisticasController {

    private final EstadisticasService estadisticasService;

    @GetMapping
    public List<Estadisticas> findAll() {
        return estadisticasService.findAll();
    }

    @PostMapping
    public Estadisticas save(@RequestBody Estadisticas estadisticas) {
        return estadisticasService.save(estadisticas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estadisticas> findById(@PathVariable Long id) {
        Estadisticas estadisticas = estadisticasService.findById(id);
        return estadisticas != null ? ResponseEntity.ok(estadisticas) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estadisticas> update(@PathVariable Long id, @RequestBody Estadisticas actualizado) {
        Estadisticas existente = estadisticasService.findById(id);
        if (existente != null) {

            return ResponseEntity.ok(estadisticasService.save(existente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return estadisticasService.delete(id) ?
                ResponseEntity.ok("Estadística eliminada.") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrada.");
    }
}
