package com.showhub.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.showhub.model.Show;
import com.showhub.model.ShowAdmin;
import com.showhub.repo.ShowAdminRepo;
import com.showhub.repo.ShowRepo;
import com.showhub.req.ShowReq;
import com.showhub.response.ShowResponse;

@Component
public class ShowUtil {
	@Autowired
	ShowAdminRepo adminrepo;
	@Autowired
	ShowRepo repo;

	public Show getShowRequest(ShowReq showreq) {
		Show show = new Show();
		show.setShowName(showreq.getShowName());
		show.setShowUrl(showreq.getShowUrl());
		show.setShowLeadActor(showreq.getShowLeadActor());
		show.setShowLeadActress(showreq.getShowLeadActress());
		show.setShowDirector(showreq.getShowDirector());
		show.setShowAdmin(adminrepo.findByShowAdminName(showreq.getAdminName()));
		
		return show;
	}

	public ShowResponse getShowResponse(Show show) {
		ShowResponse response = new ShowResponse();
		response.setShowName(show.getShowName());
		response.setShowLeadActor(show.getShowLeadActor());
		response.setShowLeadActress(show.getShowLeadActress());
		response.setShowDirector(show.getShowDirector());
		response.setShowUrl(show.getShowUrl());
		return response;
	}

	public List<ShowResponse> getShowList(List<Show> all) {
		List<Show> list = all;
		List<ShowResponse> res = new ArrayList<>();
		for (int i = 0; i <= list.size() - 1; i++) {
			ShowResponse response = new ShowResponse();
			response.setShowName(list.get(i).getShowName());
			response.setShowLeadActor(list.get(i).getShowLeadActor());
			response.setShowLeadActress(list.get(i).getShowLeadActress());
			response.setShowDirector(list.get(i).getShowDirector());
			response.setShowUrl(list.get(i).getShowUrl());
			res.add(response);
		}
		return res;
	}

}
