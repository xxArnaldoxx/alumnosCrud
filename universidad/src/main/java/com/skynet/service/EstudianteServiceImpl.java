package com.skynet.service;

import com.skynet.domain.Estudiante;
import com.skynet.repository.EstudianteRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EstudianteServiceImpl implements EstudianteService{
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Override
    public List<Estudiante> findAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante saveEstudiante(Estudiante estudiante) {
        try {
            return estudianteRepository.save(estudiante);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Error al crear el alumno: " + e.getMessage());
        } catch (ConstraintViolationException e) {
            throw new RuntimeException("Error al crear el alumno: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el alumno: " + e.getMessage());
        }
    }

    @Override
    public Estudiante updateEstudiante(Long id, Estudiante estudiante) {
        Estudiante estudianteDB=estudianteRepository.findById(id).get();
        try {
            return estudianteRepository.save(estudianteDB);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Error al crear el alumno: " + e.getMessage());
        } catch (ConstraintViolationException e) {
            throw new RuntimeException("Error al crear el alumno: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el alumno: " + e.getMessage());
        }
    }

    @Override
    public void deleteEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }
}
