package com.showhub.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.showhub.model.Channel;
import com.showhub.model.ChannelAdmin;
import com.showhub.repo.ChannelAdminRepo;
import com.showhub.repo.ChannelRepository;
import com.showhub.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	ChannelRepository repo;

	@Autowired
	ChannelAdminRepo adminRepo;

	@Override
	public ResponseEntity<List<Channel>> getAllChannels() {

		return ResponseEntity.ok(repo.findAll());
	}

	@Override
	public Channel getChannelById(Long channelId) {

		return repo.findById(channelId).get();
	}

	@Override
	public Channel getChannelByChannelName(String channelName) {

		return repo.findByChannelName(channelName);
	}

	@Override
	public Channel getChannelByChannelOwner(String channelOwner) {

		return repo.findByChannelOwner(channelOwner);
	}

	@Override
	public Channel getChannelByChannelAdminId(Long channelAdminId) {
		ChannelAdmin channeladmin = adminRepo.findByAdminId(channelAdminId);

		return repo.findByChannelAdmin(channeladmin);
	}

	@Override
	public Channel getChannelByChannelAdminName(String channelAdminName) {
		ChannelAdmin channeladmin = adminRepo.findByAdminName(channelAdminName);
		return repo.findByChannelAdmin(channeladmin);
	}

	@Override
	public Channel getChannelByChannelAdminEmail(String channelAdminEmail) {
		ChannelAdmin channeladmin = adminRepo.findByAdminEmail(channelAdminEmail);
		return repo.findByChannelAdmin(channeladmin);
	}

	@Override
	public List<String> getChannelThatStartsWith(String like) {
	    List<Channel> listChannel = repo.findAll();
	    
	    List<String> channelNames = listChannel.stream()
	            .filter(channel -> channel.getChannelName().toLowerCase().startsWith(like.toLowerCase()))
	            .map(Channel::getChannelName) // Map Channel objects to their names
	            .collect(Collectors.toList()); // Collect the names into a list
	    
	    return channelNames;
	}

	@Override
	public Channel updateChannelName(Long channelId,String channelName) {
		Channel channel= repo.findById(channelId).get();
		channel.setChannelName(channelName);
		repo.save(channel);
		return channel;
		
	
	}

}
