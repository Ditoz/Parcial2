package com.example.futbol.Controller;

import com.example.futbol.Model.Equipo;
import com.example.futbol.Service.EquipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/equipos")
@RequiredArgsConstructor
public class EquipoController {

    private final EquipoService equipoService;

    @GetMapping
    public List<Equipo> findAll() {
        return equipoService.findAll();
    }

    @PostMapping
    public Equipo save(@RequestBody Equipo equipo) {
        return equipoService.save(equipo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> findById(@PathVariable Long id) {
        Equipo equipo = equipoService.findById(id);
        return equipo != null ? ResponseEntity.ok(equipo) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> update(@PathVariable Long id, @RequestBody Equipo actualizado) {
        Equipo existente = equipoService.findById(id);
        if (existente != null) {
            existente.setNombre(actualizado.getNombre());

            return ResponseEntity.ok(equipoService.save(existente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return equipoService.delete(id) ?
                ResponseEntity.ok("Equipo eliminado.") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
    }
}
