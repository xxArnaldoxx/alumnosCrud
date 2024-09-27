package com.skynet.service;

import com.skynet.domain.Estudiante;

import java.util.List;

public interface EstudianteService {
    List<Estudiante> findAllEstudiantes();
    Estudiante saveEstudiante(Estudiante estudiante);
    Estudiante updateEstudiante(Long id,Estudiante estudiante);
    void deleteEstudiante(Long id);
}
