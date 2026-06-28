package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name ="Notifiactions")


public class Notifications {
    @Id
    private UUID id;
    private String message;
    private Users destinataire;
    private boolean lue ;
    private  LocalDateTime dateEnvoi;
    @ManyToOne
    @JoinColumn(name = "Taches_id")
    private Taches tache;
    @ManyToOne()
    @JoinColumn(name ="Users_id")
    private  Users user;
    @ManyToOne()
    @JoinColumn(name = "Projets_id")
    private  Projets projets ;

}
