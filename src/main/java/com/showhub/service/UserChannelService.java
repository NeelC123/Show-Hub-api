package com.showhub.service;

import java.util.Set;

import com.showhub.model.Channel;
import com.showhub.req.ChannelSetToUserReq;
import com.showhub.req.UserReq;
import com.showhub.response.UserResponse;

public interface UserChannelService {

	UserResponse addUser(UserReq userReq);

	UserResponse getUserByEmail(String userEmail);

	String addChannelToUser(ChannelSetToUserReq channelList,String userMail);

	String deleteUserAccountByEmail(String email);

	String updateUser(UserReq req);

	Set<Channel> getChannelListOfUser(String userEmail);

	Set<String> getChannelNameListOfUser(String userEmail);

}
