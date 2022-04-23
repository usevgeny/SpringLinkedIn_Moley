package com.franckMoley.linkedin.learningspring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long>{ //deuxieme arguement - classtype of the id of the entity

}
