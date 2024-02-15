package com.showhub.ServiceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.showhub.model.Channel;
import com.showhub.model.ChannelAdmin;
import com.showhub.repo.ChannelAdminRepo;
import com.showhub.repo.ChannelRepository;
import com.showhub.req.ChannelReq;
import com.showhub.service.ChannelAdminService;

@Service
public class ChannelAdminServiceImpl implements ChannelAdminService {
	@Autowired
	ChannelRepository channelRepo;
	@Autowired
	ChannelAdminRepo adminRepo;

	@Override
	public Channel createChannelAdmin(ChannelReq channelReq) {
		ChannelAdmin admin = new ChannelAdmin();
		admin.setAdminName(channelReq.getAdminReq().getAdminName());
		admin.setAdminPassword(channelReq.getAdminReq().getAdminPassword());
		admin.setAdminEmail(channelReq.getAdminReq().getAdminEmail());

		Channel channel = new Channel();
		channel.setChannelName(channelReq.getChannelName());
		channel.setChannelOwner(channelReq.getChannelOwner());
		channel.setChannelAdmin(admin);
		admin.setChannel(channel);

		return channelRepo.save(channel);
	}

	@Override
	public ResponseEntity<Boolean> getValidationForChannelAdmin(String email, String password) {
		ChannelAdmin admin = adminRepo.findByAdminEmailAndAdminPassword(email, password);
		if (admin == null) {
			return ResponseEntity.ok(false);
		} else
			return ResponseEntity.ok(true);
	}
	

	@Override
	public List<ChannelAdmin> getAllAdminInAscendingOrder() {
		List<ChannelAdmin> admins= adminRepo.findAll();
		List<ChannelAdmin> sortedListAsc = admins.stream()
                .sorted(Comparator.comparing(ChannelAdmin::getAdminName))
                .collect(Collectors.toList());
	
		return sortedListAsc;
	}
	@Override
	public List<ChannelAdmin> getAllAdminInDescendingOrder() {
		List<ChannelAdmin> admins= adminRepo.findAll();
		List<ChannelAdmin> sortedListDesc = admins.stream()
                .sorted(Comparator.comparing(ChannelAdmin::getAdminName).reversed())
                .collect(Collectors.toList());
	
		return sortedListDesc;
	}

}