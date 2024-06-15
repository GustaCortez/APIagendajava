package com.agenda.api.sevice;

import com.agenda.api.entity.Tarea;
import com.agenda.api.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    @Autowired
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public Tarea guardarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    public Tarea obtenerTareaPorId(Long id) {
        return tareaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));
    }

    public Tarea actualizarTarea(Tarea tarea, Long id) {
        Tarea tareaExistente = obtenerTareaPorId(id);
        tareaExistente.setTitulo(tarea.getTitulo());
        tareaExistente.setDescripcion(tarea.getDescripcion());
        tareaExistente.setFechaVencimiento(tarea.getFechaVencimiento());
        return tareaRepository.save(tareaExistente);
    }

    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}


