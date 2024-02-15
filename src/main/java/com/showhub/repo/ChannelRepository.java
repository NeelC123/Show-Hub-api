package com.showhub.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.showhub.model.Channel;
import com.showhub.model.ChannelAdmin;



@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

	Channel findByChannelName(String channelName);

	Channel findByChannelOwner(String channelOwner);

	Channel  findByChannelAdmin(ChannelAdmin channelAdmin);
	
}
