package com.ctf_kg.ctf_kg.entities;

import com.ctf_kg.ctf_kg.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "players")
public class Citizen {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @OneToOne(mappedBy = "citizen")
    private User user;
    private String email;

    private Role role;

    private String firstname;
    private String lastname;




}
