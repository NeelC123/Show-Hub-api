package com.showhub.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.showhub.model.Channel;
import com.showhub.model.ChannelAdmin;

@Repository

public interface ChannelAdminRepo extends JpaRepository<ChannelAdmin, Long> {

	Channel findByChannel(Channel channel);

	ChannelAdmin findByAdminId(Long adminId);

	ChannelAdmin findByAdminName(String adminName);

	ChannelAdmin findByAdminEmail(String adminEmail);

	ChannelAdmin findByAdminEmailAndAdminPassword(String email, String password);
}
