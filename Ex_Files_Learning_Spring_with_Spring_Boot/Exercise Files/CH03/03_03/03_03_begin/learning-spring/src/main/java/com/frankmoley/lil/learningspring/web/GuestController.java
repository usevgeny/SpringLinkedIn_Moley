package com.frankmoley.lil.learningspring.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.frankmoley.lil.learningspring.business.GuestService;

import com.frankmoley.lil.learningspring.data.Guest;

@Controller
@RequestMapping("/guests")
public class GuestController {
	
	private final GuestService guestService;

	public GuestController(GuestService guestService) {
		
		this.guestService = guestService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getGuests(Model model) {
		
		List<Guest> guests = this.guestService.getAllGuests();
		model.addAttribute("guests", guests) ;
		return "guestsTemplate";
		
	}

}
