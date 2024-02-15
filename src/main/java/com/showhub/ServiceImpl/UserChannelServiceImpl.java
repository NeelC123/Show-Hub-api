package com.showhub.ServiceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.showhub.exception.ShowHubExceptionNotFound;
import com.showhub.exception.ShowHubForbidden;
import com.showhub.model.Channel;
import com.showhub.model.Userchannel;
import com.showhub.repo.ChannelRepository;
import com.showhub.repo.UserRepo;
import com.showhub.req.ChannelSetToUserReq;
import com.showhub.req.UserReq;
import com.showhub.response.UserResponse;
import com.showhub.service.UserChannelService;
import com.showhub.util.ChannelUtil;
import com.showhub.util.UserUtil;

import jakarta.transaction.Transactional;

@Service
public class UserChannelServiceImpl implements UserChannelService {
	@Autowired
	UserRepo repo;
	@Autowired
	UserUtil userUtil;
	@Autowired
	ChannelRepository channelRepository;

	@Autowired
	ChannelUtil channelUtil;

	@Override
	public UserResponse addUser(UserReq userReq) {
		if (repo.findByUserEmail(userReq.getUserEmail()) != null) {

			throw new ShowHubForbidden("User with this Mail already Exist");

		} else {

			repo.save(userUtil.setUserChannel(userReq));
		}
		return userUtil.setUserResponse(userReq);
	}

	@Override
	public UserResponse getUserByEmail(String userEmail) {
		if (repo.findByUserEmail(userEmail) == null) {

			throw new ShowHubExceptionNotFound("User with this mail does not Exist");

		}

		return userUtil.setUserchannelObjectToResponse(repo.findByUserEmail(userEmail));
	}

	@Override
	@Transactional
	public String addChannelToUser(ChannelSetToUserReq channelNames, String userMail) {
		Userchannel user = repo.findByUserEmail(userMail);
		if (user == null) {
			throw new ShowHubExceptionNotFound("User with this mail does not exist");
		} else {
			Set<Channel> channels = new HashSet<>();
			Set<String> channelNameList = channelNames.getChannelNameList();
			for (String channelName : channelNameList) {
				Channel channel = channelRepository.findByChannelName(channelName);
				if (channel != null) {
					channels.add(channel);
				}
			}
			user.setUserChannelList(channels);
			Channel channel1 = new Channel();
			// Associate channels with user by updating userChannelList
			for (Channel channel : channels) {
				channel.getUsers().add(user);
			}
			Set<Userchannel> userchannels = new HashSet<>();
			userchannels.add(user);
			channel1.setUsers(userchannels);

			repo.save(user); // Save the updated user with associated channels
		}
		return "Channel(s) added to User";
	}

	@Override
	public String deleteUserAccountByEmail(String email) {
		if (repo.findByUserEmail(email) == null) {

			throw new ShowHubExceptionNotFound("User with this mail does not Exist");

		} else {
			repo.deleteById(repo.findByUserEmail(email).getUserId());
		}
		return "User Deleted ";
	}

	@Override
	public String updateUser(UserReq req) {

		Userchannel userchannel = repo.findByUserEmail(req.getUserEmail());
		if (repo.findByUserEmail(req.getUserEmail()) == null) {

			throw new ShowHubExceptionNotFound("User does not Exist");

		} else {
			userchannel.setUserName(req.getUserName());
			userchannel.setUserPassword(req.getUserPassword());
			repo.save(userchannel);
		}
		return "User Updated";

	}

	@Override
	public Set<Channel> getChannelListOfUser(String userEmail) {
		if (repo.findByUserEmail(userEmail) == null) {

			throw new ShowHubExceptionNotFound("User with this mail does not Exist");

		}
		System.out.println(repo.findByUserEmail(userEmail).getUserChannelList());
		return repo.findByUserEmail(userEmail).getUserChannelList();
	}

	@Override
	public Set<String> getChannelNameListOfUser(String userEmail) {
		if (repo.findByUserEmail(userEmail) == null) {

			throw new ShowHubExceptionNotFound("User with this mail does not Exist");

		} else {
			Set<String> channelName = new HashSet<>();
			Set<Channel> channelList = repo.findByUserEmail(userEmail).getUserChannelList();

			for (Channel list : channelList) {
				channelName.add(list.getChannelName());
			}
			return channelName;
		}

	}
}
