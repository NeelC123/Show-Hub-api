package com.showhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.showhub.model.Show;
import com.showhub.req.ShowAdminReq;
import com.showhub.req.ShowReq;
import com.showhub.response.ShowAdminResponse;
import com.showhub.response.ShowResponse;
import com.showhub.service.ShowAdminService;
import com.showhub.service.ShowService;

@RestController
@RequestMapping("/showAdmin")
public class ShowAdminController {
	@Autowired
	ShowAdminService service;
	@Autowired
	ShowService showService;

	// 1 Creating Show
	@PostMapping("/createshow")
	public ResponseEntity<Show> createShow(@RequestBody ShowReq req) {

		return showService.createShow(req);
	}

	// 2 Getting All Shows
	@GetMapping("/getAllshows")
	public ResponseEntity<List<ShowResponse>> getAllShow() {

		return showService.getAllShow();
	}

	// 3 Get Show By Id
	@GetMapping("/getShowByid/{id}")
	public ResponseEntity<ShowResponse> getShowById(@PathVariable("id") Long showId) {

		return showService.getShowById(showId);
	}

	// 4 Get Show By Show Name
	@GetMapping("/getShowByShowName/{showName}")
	public ResponseEntity<ShowResponse> getShowByShowName(@PathVariable("showName") String showName) {

		return showService.getShowByShowName(showName);
	}

	// 5 Get Show By Url
	@GetMapping("/getShowByUrl/{showUrl}")
	public ResponseEntity<ShowResponse> getShowByUrl(@PathVariable("showUrl") String showUrl) {

		return showService.getShowByUrl(showUrl);
	}

	// 6 Get Show By Lead actor
	@GetMapping("/getShowByLeadActor/{actor}")
	public ResponseEntity<ShowResponse> getShowByLeadActor(@PathVariable("actor") String showActor) {

		return showService.getShowByLeadActor(showActor);
	}

	// 7 Get Show By Lead actress
	@GetMapping("/getShowByLeadActoress/{actress}")
	public ResponseEntity<ShowResponse> getShowByLeadActoress(@PathVariable("actress") String showActoress) {

		return showService.getShowByLeadActoress(showActoress);
	}

	// 8 Get Show By Director
	@GetMapping("/getShowByDirector/{director}")
	public ResponseEntity<ShowResponse> getShowByDirector(@PathVariable("director") String showDirector) {
		// TODO Auto-generated method stub
		return showService.getShowByDirector(showDirector);
	}

	// 9 Get Show By Channel Name
	@GetMapping("/getShowsByChannelName/{channelName}")
	public ResponseEntity<List<ShowResponse>> getShowsByChannelName(@PathVariable("channelName") String channelName) {

		return showService.getShowsByChannelName(channelName);
	}

	// 10 Get Show By Channel AdminName
	@GetMapping("/getShowsByChannelAdminName/{channelAdminName}")
	public ResponseEntity<List<ShowResponse>> getShowsByChannelAdminName(
			@PathVariable("channelAdminName") String channelAdminName) {

		return showService.getShowsByChannelAdmin(channelAdminName);
	}

	// 11 Update Show Url By Id
	@PutMapping("/updateShowUrlById/{id}/{url}")
	public String updateShowUrlById(@PathVariable("id") Long showId, @PathVariable("url") String showUrl) {

		return showService.updateShowUrlById(showId, showUrl);
	}

//-----------------------------------

	// 12 Update Lead Actor By Show Name
	@PutMapping("/updateLeadActorByShowName/{leadActor}/{showName}")
	public String updateLeadActorByShowName(@PathVariable("leadActor") String leadActor,
			@PathVariable("showName") String showName) {
		// TODO Auto-generated method stub
		return showService.updateLeadActorByShowName(leadActor, showName);
	}

	// 13 Update LeadActoress By Show Name
	@PutMapping("/updateLeadActoressByShowName/{leadActoress}/{showName}")
	public String updateLeadActoressByShowName(@PathVariable("leadActoress") String leadActoress,
			@PathVariable("showName") String showName) {

		return showService.updateLeadActoressByShowName(leadActoress, showName);
	}

	// 14 Update Director By Id
	@PutMapping("/updateDirectorByShowId/{showId}/{showDirector}")
	public String updateDirectorByShowId(@PathVariable("showId") Long showId,
			@PathVariable("showDirector") String showDirector) {
		// TODO Auto-generated method stub
		return showService.updateDirectorByShowId(showId, showDirector);
	}

	// 15 Delete Show By Show Id
	@DeleteMapping("/deleteShowByShowId/{id}")
	public String deleteShowByShowId(@PathVariable("id") Long showId) {
		// TODO Auto-generated method stub
		return showService.deleteShowByShowId(showId);
	}

	// 16
	@DeleteMapping("/deleteShowByShowName/{showName}")
	public String deleteShowByShowName(@PathVariable("showName") String showName) {
		// TODO Auto-generated method stub
		return showService.deleteShowByShowName(showName);
	}

	// 17
	@DeleteMapping("/deleteShowByShowUrl/{showUrl}")
	public String deleteShowByShowUrl(@PathVariable("showUrl") String showUrl) {
		// TODO Auto-generated method stub
		return showService.deleteShowByShowUrl(showUrl);
	}

	// 18
	@DeleteMapping("/deleteShowByShowActor/{showActor}")
	public String deleteShowByShowShowActor(@PathVariable("showActor") String showActor) {
		// TODO Auto-generated method stub
		return showService.deleteShowByShowShowActor(showActor);
	}

	// 19
	@DeleteMapping("/deleteShowByShowShowActress/{showActoress}")
	public String deleteShowByShowShowActress(@PathVariable("showActoress") String showActress) {
		// TODO Auto-generated method stub
		return showService.deleteShowByShowShowActress(showActress);
	}

	// 20
	@GetMapping("/getShowNameByRemoteNumber/{number}")
	public String getShowNameByRemoteNumber(@PathVariable("number") int number) {
		return showService.getShowNameByNumber(number);
	}

//	21.Create ShowAdmin
	@PostMapping("/addShowAdmin")
	public ResponseEntity<ShowAdminResponse> addShowAdmin(@RequestBody ShowAdminReq showAdminReq) {
		return service.addShowAdmin(showAdminReq);
	}

//	22.Validate Show admin
	@GetMapping("/validateShowAdmin/{email}/{password}")
	public ResponseEntity<ShowAdminResponse> validateAdmin(@PathVariable("email") String email,
			@PathVariable("password") String password) {

		return service.validateShowAdmin(email, password);
	}

//	23.Update Show Admin Details
	@PutMapping("/updateShowAdminData")
	public ResponseEntity<ShowAdminResponse> updateShowAdmin(@RequestBody ShowAdminReq adminReq) {
		return service.updateShowAdmin(adminReq);
	}

}
