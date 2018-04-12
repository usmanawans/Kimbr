package com.kimbr.app.repository;

import com.kimbr.app.domain.Butikk;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract interface ButikkRepository extends MongoRepository<Butikk, String> {

    public abstract Butikk save( Butikk butikk );
    public abstract Butikk findButikkByNavnLike( String navn );
    public abstract Butikk findButikkByPostNummerNear( String postNummer );


}
