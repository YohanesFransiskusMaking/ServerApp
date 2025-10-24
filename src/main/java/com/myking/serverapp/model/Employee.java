package com.myking.serverapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_tb")
public class Employee {
    @Id
    @Column(name = "user_id")
    private int id;

    @Column(name = "full_name", nullable = false)
    private String fullname;

    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(name = "no_hp", nullable = false, length = 13)
    private String hp;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;


}
