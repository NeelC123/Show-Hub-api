package com.showhub.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.showhub.model.Channel;

@Service
public interface ChannelService {

	ResponseEntity<List<Channel>> getAllChannels();

	Channel getChannelById(Long channelId);

	Channel getChannelByChannelName(String channelName);

	Channel getChannelByChannelOwner(String channelOwner);

	Channel getChannelByChannelAdminId(Long channelAdminId);

	Channel getChannelByChannelAdminName(String channelAdminName);

	Channel getChannelByChannelAdminEmail(String channelAdminEmail);

	List<String> getChannelThatStartsWith(String like);

	Channel updateChannelName(Long channelId, String channelName);

}
