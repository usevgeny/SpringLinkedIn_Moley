package com.franckMoley.linkedin.learningspring.data;


import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends CrudRepository<Reservation, Double>{ //deuxieme arguement - classtype of the id of the entity

	Iterable<Reservation> findReservationByResDate(Date resDate); // 2022-01-01 //findReservationByResDate is the name composed of entity proprerty and should follow this naming logic
	
}
