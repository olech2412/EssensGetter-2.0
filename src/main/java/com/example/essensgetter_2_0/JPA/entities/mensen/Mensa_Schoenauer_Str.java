package com.example.essensgetter_2_0.JPA.entities.mensen;

import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Schoenauer_Str;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "mensa_schoenauer_str")
public class Mensa_Schoenauer_Str extends Mensa {

    @OneToMany(mappedBy = "mensa_schoenauer_str")
    private Set<Meals_Schoenauer_Str> meals_schoenauer_strList;


}