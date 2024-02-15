package com.showhub.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.showhub.model.Channel;
import com.showhub.repo.ChannelRepository;
import com.showhub.response.ChannelResponse;

@Component
public class ChannelUtil {
	@Autowired
	ChannelRepository channelRepository;

	public Set<ChannelResponse> changeChannelListToChannelResponse(Set<Channel> channelList) {
		Set<ChannelResponse> channelResponsesList = new HashSet<>();
		for (Channel list : channelList) {
			ChannelResponse channelResponse = new ChannelResponse();
			channelResponse.setChannelAdminName(list.getChannelAdmin().getAdminName());
			channelResponse.setChannelName(list.getChannelName());
			channelResponse.setChannelOwner(list.getChannelOwner());
			channelResponse.setShowList(list.getShowList());
			channelResponse.setUsers(list.getUsers());
			channelResponsesList.add(channelResponse);
		}
		return channelResponsesList;
	}



	

}
