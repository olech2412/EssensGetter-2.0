package com.example.essensgetter_2_0.JPA.entities.meals;

import com.example.essensgetter_2_0.JPA.entities.mensen.Mensa_am_Medizincampus;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "meals_mensa_am_medizincampus")
public class Meals_Mensa_am_Medizincampus extends Meal {

    @ManyToOne
    @JoinColumn(name = "mensa_am_medizincampus_id", nullable = false)
    private Mensa_am_Medizincampus mensa_am_medizincampus;

    public Meals_Mensa_am_Medizincampus() {

    }

}
