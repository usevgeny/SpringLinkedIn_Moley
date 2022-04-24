package com.frankmoley.lil.learningspring.webservice;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.frankmoley.lil.learningspring.business.ReservationService;
import com.frankmoley.lil.learningspring.business.RoomReservation;
import com.frankmoley.lil.learningspring.data.Guest;
import com.frankmoley.lil.learningspring.util.DateUtils;

@RestController
@RequestMapping("/api")
public class WebServiceController {
	
	private final DateUtils dateUtils;
	private final ReservationService reservationService;
	
	public WebServiceController(DateUtils dateUtils, ReservationService reservationService) {
		super();
		this.dateUtils = dateUtils;
		this.reservationService = reservationService;
	}
	
	
	@RequestMapping(path="/reservations", method = RequestMethod.GET) //request mapping is additive as it goes through
	public List<RoomReservation> getReservations(@RequestParam(value="date" , required=false) String dateString){
		
		Date date = this.dateUtils.createDateFromDateString(dateString);
		
		
		return this.reservationService.getRoomReservationsForDate(date); // no model to deal with
	};
	
	@RequestMapping(path="/guests", method = RequestMethod.GET) 
    public List<Guest> getGuests() {
		return reservationService.getHotelGuests();
		
		
	}
	
	@RequestMapping(path="/guests", method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED)
	public void createGuest(@RequestBody Guest guest) {
		
		reservationService.addGuest(guest);
	}
	
	
	@RequestMapping(path="/guest", method = RequestMethod.GET) 
	@ResponseStatus(HttpStatus.CREATED)
    public Optional<Guest> getGuestById(@RequestParam(value="id" , required=false) Long guestId){
		return reservationService.findGuestById(guestId);
		
		
	}
	
	
}
