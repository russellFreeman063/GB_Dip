package ru.gb.auth_service.model;

import jakarta.persistence.*;
import lombok.Data;



@Entity(name = "user")
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private  String role;
}
