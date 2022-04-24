package com.frankmoley.lil.learningspring.business;

import java.util.ArrayList;
import java.util.Comparator;
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
		
		Iterable<Guest> allGuests = this.guestRepository.findAll();
		List<Guest> guestsSorted = new ArrayList<Guest>();
		allGuests.forEach(g->guestsSorted.add(g));
		guestsSorted.sort(new Comparator<Guest>() {

			@Override
			public int compare(Guest o1, Guest o2) {
				return o1.getLastName().equals(o2.getLastName())
																?o1.getFirstName().compareTo(o2.getFirstName())
																:o1.getLastName().compareTo(o2.getLastName());
													}
			
		});
		
		return guestsSorted;
		
	
	}
	
	

}



