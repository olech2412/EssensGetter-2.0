package com.example.essensgetter_2_0.JPA.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "deactivation_codes")
public class DeactivationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String code;

    public DeactivationCode(String code) {
        this.code = code;
    }

    public DeactivationCode() {

    }

}
