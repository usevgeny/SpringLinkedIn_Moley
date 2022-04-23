package com.franckMoley.linkedin.learningspring.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.franckMoley.linkedin.learningspring.data.Room;
import com.franckMoley.linkedin.learningspring.data.RoomRepository;

@Component // so that Spring pick it up
@ComponentScan(basePackages ="data")
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

	
	private final RoomRepository roomRepository;

	public AppStartupEvent(RoomRepository roomRepository) {
		
		this.roomRepository = roomRepository;
	}
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Iterable<Room> rooms = roomRepository.findAll();
		System.out.println("Rooms collected");
		rooms.forEach(System.out::println);
	}
}