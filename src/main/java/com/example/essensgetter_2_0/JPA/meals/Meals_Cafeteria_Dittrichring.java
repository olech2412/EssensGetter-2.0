package com.example.essensgetter_2_0.JPA.meals;

import com.example.essensgetter_2_0.JPA.mensen.Cafeteria_Dittrichring;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "meals_cafeteria_dittrichring")
public class Meals_Cafeteria_Dittrichring extends Meal {

    @ManyToOne
    @JoinColumn(name = "cafeteria_dittrichring_id", nullable = false)
    private Cafeteria_Dittrichring cafeteria_dittrichring;

    public Meals_Cafeteria_Dittrichring() {

    }

}
