package com.api.crud.services;

import com.api.crud.models.EstudianteModel;
import com.api.crud.repositories.IEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EstudianteService {

    @Autowired
    IEstudianteRepository userRepository;

    public ArrayList<EstudianteModel> getUsers(){
        return (ArrayList<EstudianteModel>) userRepository.findAll();
    }
}
