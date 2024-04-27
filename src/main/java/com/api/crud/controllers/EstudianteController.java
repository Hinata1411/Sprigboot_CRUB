package com.api.crud.controllers;


import com.api.crud.models.EstudianteModel;
import com.api.crud.repositories.IEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class EstudianteController {

    private final IEstudianteRepository iestudianteRepository;

    @Autowired
    public EstudianteController(IEstudianteRepository estudianteRepository){
        this.iestudianteRepository = estudianteRepository;
    }

    //Método para listar todos los estudiantes
    @GetMapping
    public List<EstudianteModel> listarEstudiantes(){
        return iestudianteRepository.findAll();
    }

    //Método para buscar estudiantes por Id
    @GetMapping("/{id}")
    public EstudianteModel buscarPorId(@PathVariable Long id){
        return iestudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante con id " + id + "no fue encontrado"));

    }

    //Método para buscar estudiantes por nombre
    @GetMapping("/nombre{nombre}")
    public List<EstudianteModel> buscarPorNombre(@PathVariable String nombre){
        return iestudianteRepository.findByNombre(nombre);
    }

    //Método para Ingresar un nuevo estudiante
    @PostMapping
    public EstudianteModel ingresarEstudiante(@RequestBody EstudianteModel estudianteModel){
        return iestudianteRepository.save(estudianteModel);
    }

    //Método para Modificar estudiantes
    @PutMapping("/{id}")
    public EstudianteModel modificarEstudiante(@PathVariable Long id, @RequestBody EstudianteModel estudianteModelActualizado){
        EstudianteModel estudianteModel = iestudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante con id " + id + "no fue encontrado"));

        if(estudianteModel != null){
            estudianteModel.setNombre(estudianteModelActualizado.getNombre());
            estudianteModel.setApellido(estudianteModelActualizado.getApellido());
            estudianteModel.setEdad(estudianteModelActualizado.getEdad());
        return iestudianteRepository.save(estudianteModel);
        }
        else{
            throw new RuntimeException("Estudiante con id " + id + "no fue encontrado");
        }
    }


    //Método para Eliminar estudiantes
    @DeleteMapping("/{id}")
    public void eliminarEstudiante(@PathVariable Long id){
        iestudianteRepository.deleteById(id);
    }



}
