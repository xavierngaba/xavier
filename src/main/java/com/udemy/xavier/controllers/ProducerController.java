package com.udemy.xavier.controllers;

import com.udemy.xavier.entities.StudentJpa;
import com.udemy.xavier.json.Student;
import com.udemy.xavier.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.udemy.xavier.producer.IProducer;

@RestController
public class ProducerController {

    @Autowired
    private IProducer producer;

    @Autowired
    private EtudiantRepository repository;

    @GetMapping(path = "/send" )
    public String sendMessage() {
        Student student = Student.builder().nom("BOMO NGABA").prenom("Xavier").age(35).build();
        StudentJpa etudiant = StudentJpa.builder().nom(student.getNom()).prenom(student.getPrenom()).age(student.getAge()).build();
        repository.save(etudiant);
        producer.produceMessage(student);
        return student.toString();
    }
}
