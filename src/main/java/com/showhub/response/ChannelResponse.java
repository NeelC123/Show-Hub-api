package com.showhub.response;

import java.util.Set;

import com.showhub.model.Show;
import com.showhub.model.Userchannel;

import lombok.Data;

@Data
public class ChannelResponse {
	private String channelName;
	private String channelOwner;
	private String channelAdminName;
	private Set<Userchannel> users;
	private Set<Show> showList;
}
