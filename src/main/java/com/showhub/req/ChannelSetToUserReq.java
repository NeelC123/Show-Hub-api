package com.showhub.req;

import java.util.Set;

import lombok.Data;

@Data
public class ChannelSetToUserReq {
	Set<String> channelNameList;
}
