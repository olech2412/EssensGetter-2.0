package com.example.essensgetter_2_0.JPA.meals;

import com.example.essensgetter_2_0.JPA.mensen.Cafeteria_Dittrichring;
import com.example.essensgetter_2_0.JPA.mensen.Mensa_Tierklinik;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "meals_mensa_tierklinik")
public class Meals_Mensa_Tierklinik extends Meal {

    @ManyToOne
    @JoinColumn(name = "mensa_tierklinik_id", nullable = false)
    private Mensa_Tierklinik mensa_tierklinik;

    public Meals_Mensa_Tierklinik() {

    }

}
