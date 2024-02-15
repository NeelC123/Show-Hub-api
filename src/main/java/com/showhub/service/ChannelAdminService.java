package com.showhub.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.showhub.model.Channel;
import com.showhub.model.ChannelAdmin;
import com.showhub.req.ChannelReq;
@Component
public interface ChannelAdminService {

	Channel createChannelAdmin(ChannelReq channelReq);

	ResponseEntity<Boolean> getValidationForChannelAdmin(String email, String password);

	List<ChannelAdmin> getAllAdminInAscendingOrder();

	List<ChannelAdmin> getAllAdminInDescendingOrder();

}
