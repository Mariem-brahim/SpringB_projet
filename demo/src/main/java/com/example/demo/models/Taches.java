package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "Taches")

public class Taches {
    private UUID id;
    private  String titre;
    private   String  description ;
    private enum  statut{
        a_faire,en_cours,termine
    }
    private LocalDate dateEcheance ;
    private List<Users> assigneA;
    @ManyToOne
    @JoinColumn(name="Users_id")
    private Users createPar;
    private LocalDateTime dateCreation;
    @ManyToOne
    @JoinColumn(name = "Projets_id")
    private Projets projet ;
    @OneToMany(mappedBy ="tache")
    List<Notifications> notifications ;

}
