package com.franckMoley.linkedin.learningspring.data;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>{ //deuxieme arguement - classtype of the id of the entity

}
