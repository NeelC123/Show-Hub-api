package com.showhub.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.showhub.model.Userchannel;
import com.showhub.repo.UserRepo;
import com.showhub.req.UserReq;
import com.showhub.response.UserResponse;

@Component
public class UserUtil {

	@Autowired
	UserRepo repo;

	public Userchannel setUserChannel(UserReq userReq) {
		Userchannel user = new Userchannel();
		user.setUserEmail(userReq.getUserEmail());
		user.setUserName(userReq.getUserName());
		user.setUserPassword(userReq.getUserPassword());

		return user;
	}

	public UserResponse setUserResponse(UserReq userReq) {
		UserResponse response = new UserResponse();
		response.setUserEmail(userReq.getUserEmail());
		response.setUserName(userReq.getUserName());
		response.setUserId(repo.findByUserEmail(userReq.getUserEmail()).getUserId());
		return response;
	}

	public UserResponse setUserchannelObjectToResponse(Userchannel byUserEmail) {
		UserResponse response = new UserResponse();
		response.setUserEmail(byUserEmail.getUserEmail());
		response.setUserName(byUserEmail.getUserName());
		response.setUserId(repo.findByUserEmail(byUserEmail.getUserEmail()).getUserId());
		return response;
	}

}
