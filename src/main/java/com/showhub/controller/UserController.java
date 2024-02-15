package com.showhub.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.showhub.req.ChannelSetToUserReq;
import com.showhub.req.UserReq;
import com.showhub.response.UserResponse;
import com.showhub.service.UserChannelService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserChannelService channelService;

//	1.Adding User with Channel
	@PostMapping("/addUser")
	private UserResponse addUser(@RequestBody UserReq userReq) {

		return channelService.addUser(userReq);

	}

//	2.Get User By Email
	@GetMapping("/getUserByEmail/{userEmail}")
	private UserResponse getUser(@PathVariable("userEmail") String userEmail) {
		return channelService.getUserByEmail(userEmail);
	}

//	3.Add Channel to user

	@PutMapping("/addChannelstoUser/{userMail}")
	private String addChannelToUser(@RequestBody ChannelSetToUserReq channelList,
			@PathVariable("userMail") String userMail) {
		System.out.println("etwuyegh");
		return channelService.addChannelToUser(channelList, userMail);

	}

//	4.Delete User
	@DeleteMapping("/deleteUserByEmail/{email}")
	private String deleteUserByEmail(@PathVariable("email") String email) {
		return channelService.deleteUserAccountByEmail(email);
	}

//	5.Update User
	@PutMapping("/updateUser")
	private String updateUser(@RequestBody UserReq req) {
		return channelService.updateUser(req);
	}

//	6.Get all ChannelName list Of User

	@GetMapping("/getChannelNameList/{userEmail}")
	private Set<String> getChannelNameListOfUser(@PathVariable("userEmail") String userEmail) {
		return channelService.getChannelNameListOfUser(userEmail);
	}
}
