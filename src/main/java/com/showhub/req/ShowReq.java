package com.showhub.req;

import lombok.Data;

@Data
public class ShowReq {

	private String showName;
	private String showUrl;
	private String showLeadActor;
	private String showLeadActress;
	private String showDirector;
	private String adminName;
	private Long showchannelId;
	private Long channelId;

}
