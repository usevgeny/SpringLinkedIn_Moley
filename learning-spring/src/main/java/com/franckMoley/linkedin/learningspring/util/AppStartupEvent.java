package com.franckMoley.linkedin.learningspring.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.franckMoley.linkedin.learningspring.data.Guest;
import com.franckMoley.linkedin.learningspring.data.GuestRepository;
import com.franckMoley.linkedin.learningspring.data.Room;
import com.franckMoley.linkedin.learningspring.data.RoomRepository;

@Component // so that Spring pick it up
//@ComponentScan(basePackages ="data")
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

	
	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;

	public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository) {
		
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
	}
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Iterable<Room> rooms = roomRepository.findAll();
		Iterable<Guest> guests = guestRepository.findAll();
		
		
		System.out.println("Rooms collected");
		rooms.forEach(System.out::println);
	
		System.out.println("Guests collected");
		guests.forEach(System.out::println);
	
	}
}