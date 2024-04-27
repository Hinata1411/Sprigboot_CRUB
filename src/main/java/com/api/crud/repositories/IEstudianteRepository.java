package com.api.crud.repositories;

import com.api.crud.models.EstudianteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEstudianteRepository extends JpaRepository<EstudianteModel, Long> {

    //Método paraco buscar a los estudiantes por nombre
    List<EstudianteModel> findByNombre(String nombre);


}
