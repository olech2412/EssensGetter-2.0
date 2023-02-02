package com.example.essensgetter_2_0.JPA.entities;

import com.example.essensgetter_2_0.JPA.entities.mensen.Mensa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "mail_users")
public class MailUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToOne
    private ActivationCode activationCode;

    @OneToOne
    private DeactivationCode deactivationCode;
    private String firstname;
    private String lastname;
    private boolean enabled;

    public MailUser() {
    }

    public MailUser(String email, String firstname, String lastname,
                    boolean enabled) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                '}';
    }
}