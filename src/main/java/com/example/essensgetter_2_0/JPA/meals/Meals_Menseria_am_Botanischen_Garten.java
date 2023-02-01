package com.example.essensgetter_2_0.JPA.meals;

import com.example.essensgetter_2_0.JPA.mensen.Mensa_Schoenauer_Str;
import com.example.essensgetter_2_0.JPA.mensen.Menseria_am_Botanischen_Garten;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "meals_menseria_am_botanischen_garten")
public class Meals_Menseria_am_Botanischen_Garten extends Meal {

    @ManyToOne
    @JoinColumn(name = "menseria_am_botanischen_garten_id", nullable = false)
    private Menseria_am_Botanischen_Garten menseria_am_botanischen_garten;

    public Meals_Menseria_am_Botanischen_Garten(){

    }

}
