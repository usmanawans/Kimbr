package com.kimbr.app.repository;

import com.kimbr.app.domain.Produkt;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public abstract interface ProduktRepository extends MongoRepository<Produkt, String> {

    public abstract Produkt save( Produkt produkt );
    public abstract List<Produkt> findProduktsByButikk( String butikk );

    public abstract List<Produkt> findAll();

    public abstract Produkt findProduktBy_id( String _id );
}
