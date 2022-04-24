package com.frankmoley.lil.learningspring.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.frankmoley.lil.learningspring.business.ReservationService;
import com.frankmoley.lil.learningspring.business.RoomReservation;
import com.frankmoley.lil.learningspring.util.DateUtils;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {
	
	
	private final DateUtils dateutils;
	private final ReservationService  reservationService;
	public RoomReservationController(DateUtils dateutils, ReservationService reservationService) {
		super();
		this.dateutils = dateutils;
		this.reservationService = reservationService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getReservations(@RequestParam(value="date", required=false) String datestring, Model model) {
		Date date =this. dateutils.createDateFromDateString(datestring);
		
		List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
		model.addAttribute("roomReservations", roomReservations) ;
		return "roomres";
		
		
	}

}
