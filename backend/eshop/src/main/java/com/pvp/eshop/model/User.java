package com.pvp.eshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;

    @NotBlank(message = "Username is mandatory")
    @Column(name = "username", nullable = false)
    private String username;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email")
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = "Phone is mandatory")
    @Column(name = "phone", nullable = false)
    private String phone;
}