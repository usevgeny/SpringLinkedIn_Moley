package com.franckMoley.linkedin.learningspring.util;

import java.sql.Date;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.franckMoley.linkedin.learningspring.data.Guest;
import com.franckMoley.linkedin.learningspring.data.GuestRepository;
import com.franckMoley.linkedin.learningspring.data.Reservation;

import com.franckMoley.linkedin.learningspring.data.ReservationsRepository;
import com.franckMoley.linkedin.learningspring.data.Room;
import com.franckMoley.linkedin.learningspring.data.RoomRepository;

@Component // so that Spring pick it up
//@ComponentScan(basePackages ="data")
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

	
	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final ReservationsRepository reservationRepository;

	public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository,
			ReservationsRepository reservationRepository) {
		
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
		
	}
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Iterable<Room> rooms = roomRepository.findAll();
		Iterable<Guest> guests = guestRepository.findAll();
		Iterable<Reservation> res = reservationRepository.findAll();
		
		System.out.println("Rooms collected");
		rooms.forEach(System.out::println);
	
		System.out.println("Guests collected");
		guests.forEach(System.out::println);
		
		
		System.out.println("Resas collected");
		res.forEach(System.out::println);
		
		
		String str="2022-01-01";
		Date dateResa=Date.valueOf(str);//converting string into sql date.
		
		
		System.out.println("Resas By Date");
		Iterable<Reservation> resasByDate = reservationRepository.findReservationByResDate(dateResa);
		resasByDate.forEach(System.out::println);
	}
}