package com.showhub.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.showhub.model.Show;
import com.showhub.req.ShowReq;
import com.showhub.response.ShowResponse;

public interface ShowService {

//	Post

	ResponseEntity<Show> createShow(ShowReq show);

//	Get

	ResponseEntity<List<ShowResponse>> getAllShow();

	ResponseEntity<ShowResponse> getShowById(Long showId);

	ResponseEntity<ShowResponse> getShowByShowName(String showName);

	ResponseEntity<ShowResponse> getShowByUrl(String showUrl);

	ResponseEntity<ShowResponse> getShowByLeadActor(String showActor);

	ResponseEntity<ShowResponse> getShowByLeadActoress(String showActoress);

	ResponseEntity<ShowResponse> getShowByDirector(String showDirector);

	ResponseEntity<List<ShowResponse>> getShowsByChannelName(String channelName);

	ResponseEntity<List<ShowResponse>> getShowsByChannelAdmin(String channelAdminName);

//	Put

	String updateShowUrlById(Long showId,String showUrl);

	String updateLeadActorByShowName(String Leadactor,String showName);

	String updateLeadActoressByShowName(String Leadactoress,String showName);

	String updateDirectorByShowId(Long showId,String showDirector);

//	Delete

	String deleteShowByShowId(Long showId);

	String deleteShowByShowName(String showName);

	String deleteShowByShowUrl(String showUrl);

	String deleteShowByShowShowActor(String showActor);

	String deleteShowByShowShowActress(String showActress);

	String getShowNameByNumber(int number);
}
