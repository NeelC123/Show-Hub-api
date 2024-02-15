package com.showhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.showhub.model.Channel;
import com.showhub.model.ChannelAdmin;
import com.showhub.req.ChannelReq;
import com.showhub.service.ChannelAdminService;
import com.showhub.service.ChannelService;

@RestController
@RequestMapping("/channelAdmin")
public class ChannelAdminController {

	@Autowired
	ChannelAdminService service;

	@Autowired
	ChannelService channelservice;

//	1. Get all Channels 
	@GetMapping("/getAllChannels")
	private ResponseEntity<List<Channel>> getAllChannels() {
		return channelservice.getAllChannels();
	}

//	2.Get Channel by Id
	@GetMapping("/getChannelById/{id}")
	private Channel getChannelBy(@PathVariable("id") Long channelId) {
		return channelservice.getChannelById(channelId);
	}

//	3.Get Channel By Channel Name
	@GetMapping("/getChannelByChannelName/{channelName}")
	private Channel getChannelByChannelName(@PathVariable("channelName") String channelName) {
		return channelservice.getChannelByChannelName(channelName);
	}

//  4.Get Channel By Channel Owner
	@GetMapping("/getChannelByChannelOwner/{channelOwner}")
	private Channel getChannelByChannelOwner(@PathVariable("channelOwner") String channelName) {
		return channelservice.getChannelByChannelOwner(channelName);
	}

//  5.Get Channel By Channel Admin Id
	@GetMapping("/getChannelByChannelAdminId/{channelAdminId}")
	private Channel getChannelByChannelAdminId(@PathVariable("channelAdminId") Long channelAdminId) {
		return channelservice.getChannelByChannelAdminId(channelAdminId);
	}

//	6.Get Channel By Admin Name

	@GetMapping("/getChannelByChannelAdminName/{channelAdminName}")
	private Channel getChannelByChannelAdminName(@PathVariable("channelAdminName") String channelAdminName) {
		return channelservice.getChannelByChannelAdminName(channelAdminName);
	}

//	7.Get Channel By Admin Email
	@GetMapping("/getChannelByChannelAdminEmail/{channelAdminEmail}")
	private Channel getChannelByChannelAdminEmail(@PathVariable("channelAdminEmail") String channelAdminEmail) {
		return channelservice.getChannelByChannelAdminEmail(channelAdminEmail);
	}

//	8.Get Channel that starts with "like"

	@GetMapping("/getChannelThatStartsWith/{like}")
	private List<String> getChannelThatStartsWith(@PathVariable("like") String like) {

		return channelservice.getChannelThatStartsWith(like);

	}

//	9.Update Channel Name Using Channel Id

	@PutMapping("/updateChannelName/{channelId}/{channelName}")
	private Channel updateChannelName(@PathVariable("channelId") Long channelId,@PathVariable("channelName") String channelName) {
		
		return channelservice.updateChannelName(channelId,channelName);


		
	}	

//	10. Creating Channel Admin and Channel By ShowAdmin
	@PostMapping("/createChannelAdmin")
	private Channel createAdmin(@RequestBody ChannelReq channelReq) {
		return service.createChannelAdmin(channelReq);

	}

//  11. Validating Channel Admin
	@GetMapping("/login/{email}/{password}")
	private ResponseEntity<Boolean> validateChannelAdmin(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		return service.getValidationForChannelAdmin(email, password);
	}

//	12.Get All admin details in Ascending order by name
	@GetMapping("/getAllAdminInAscendingOrderByName")
	private List<ChannelAdmin> getAllAdminInAscendingOrder() {
		return service.getAllAdminInAscendingOrder();
	}

//	13.Get All admin details in Descending order by name
	@GetMapping("/getAllAdminInDescendingOrderByName")
	private List<ChannelAdmin> getAllAdminInDescendingOrder() {
		return service.getAllAdminInDescendingOrder();
	}


}
