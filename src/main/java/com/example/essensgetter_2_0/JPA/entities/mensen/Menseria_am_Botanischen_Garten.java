package com.example.essensgetter_2_0.JPA.entities.mensen;

import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Menseria_am_Botanischen_Garten;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "menseria_am_botanischen_garten")
public class Menseria_am_Botanischen_Garten extends Mensa {

    @OneToMany(mappedBy = "menseria_am_botanischen_garten")
    private Set<Meals_Menseria_am_Botanischen_Garten> meals_menseria_am_botanischen_garten;


}