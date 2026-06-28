package com.example.demo.models;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity(name ="Users")


public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id=UUID.randomUUID() ;
    @Column(nullable = false)
    private String name ;
    @Column(unique = true )
    private String email;
    private String motdepasse;
    private enum role{admin,membre} ;
    private LocalDateTime dateInscription;
    @ManyToMany
    @JoinTable(
            name = "Users_Projets",
            joinColumns = @JoinColumn(name = "Users_id"),
            inverseJoinColumns = @JoinColumn(name = "Projets_id"))
    private List<Projets> projets;
    @OneToMany(mappedBy ="createpar" ,cascade = CascadeType.ALL)
    private List<Taches> taches;
    @OneToMany(mappedBy ="user")
    private  List<Notifications> notifications;




}
