package com.example.essensgetter_2_0.JPA.services.mensen;


import com.example.essensgetter_2_0.JPA.entities.mensen.Mensa;
import com.example.essensgetter_2_0.JPA.services.Abstract_Service;
import org.springframework.stereotype.Service;

@Service
public abstract class Mensa_Service extends Abstract_Service<Mensa>  {

    /**
     * Make sure all subclasses implement this method
     * @return Any subclass of Mensa
     */
    @Override
    public abstract Iterable<? extends Mensa> findAll();

    public abstract Mensa getMensa();

}
