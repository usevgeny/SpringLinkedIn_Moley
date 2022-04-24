package com.frankmoley.lil.learningspring.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.frankmoley.lil.learningspring.data.Guest;
import com.frankmoley.lil.learningspring.data.GuestRepository;

@Service
public class GuestService {
	
	
	
	private final GuestRepository guestRepository;

	public GuestService(GuestRepository guestRepository) {
		
		this.guestRepository = guestRepository;
	}
	
	
	public List<Guest> getAllGuests(){
		
		
		return this.guestRepository.findAll();
		
	
	}
	
	

}



