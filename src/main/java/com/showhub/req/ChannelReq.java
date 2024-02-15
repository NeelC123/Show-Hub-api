package com.showhub.req;

import lombok.Data;

@Data
public class ChannelReq {

	private String channelName;

	private String channelOwner;

	private ChannelAdminReq adminReq;
}
