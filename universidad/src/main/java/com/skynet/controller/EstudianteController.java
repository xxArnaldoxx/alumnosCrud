package com.skynet.controller;

import com.skynet.domain.Estudiante;
import com.skynet.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/estudiante/findAll")
    public ResponseEntity<List<Estudiante>> findAEstudiantes(){
        return ResponseEntity.ok(estudianteService.findAllEstudiantes());
    }

    @PostMapping ("/estudiante/save")
    public ResponseEntity<?> saveEstudiante(@RequestBody Estudiante estudiante){
        try {
            Estudiante estu=estudianteService.saveEstudiante(estudiante);
            return ResponseEntity.status(HttpStatus.OK).body(estu);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se pudo registar al alumno ");
        }
    }

    @PutMapping("/estudiante/update/{id}")
    public ResponseEntity<?> updateEstudiante(@PathVariable Long id,@RequestBody Estudiante estudiante){
        try {
            Estudiante estu=estudianteService.updateEstudiante(id,estudiante);
            return ResponseEntity.status(HttpStatus.OK).body(estu);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se pudo actualizar al alumno ");
        }
    }

    @DeleteMapping("/estudiante/delete/{id}")
    public ResponseEntity<?>  deleteEstudiante(@PathVariable Long id){
        try {
            estudianteService.deleteEstudiante(id);
            return ResponseEntity.status(HttpStatus.OK).body("Estudiante eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se pudo eliminar al alumno ");
        }
    }
}
