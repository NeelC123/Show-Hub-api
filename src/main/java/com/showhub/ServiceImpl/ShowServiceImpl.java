package com.showhub.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.showhub.exception.ShowHubExceptionNotFound;
import com.showhub.exception.ShowHubForbidden;
import com.showhub.model.Show;
import com.showhub.repo.ChannelAdminRepo;
import com.showhub.repo.ChannelRepository;
import com.showhub.repo.ShowRepo;
import com.showhub.req.ShowReq;
import com.showhub.response.ShowResponse;
import com.showhub.service.ShowService;
import com.showhub.util.ShowUtil;

@Service
public class ShowServiceImpl implements ShowService {
	@Autowired
	ChannelRepository channelRepository;
	@Autowired
	ShowRepo repo;
	@Autowired
	ChannelAdminRepo adminRepo;
	@Autowired
	ShowUtil showUtil;

	@Override
	public ResponseEntity<Show> createShow(ShowReq showreq) {

		Show show = showUtil.getShowRequest(showreq);
		show.setChannel(channelRepository.findById(showreq.getChannelId()).get());
		
			if (repo.findByShowUrl(showreq.getShowUrl()) == null
					&& repo.findByShowName(showreq.getShowName()) == null) {
				repo.save(show);
			} else {
				throw new ShowHubForbidden("Url or Show name already Exist");
			}
		
		return ResponseEntity.ok(show);
	}

	@Override
	public ResponseEntity<List<ShowResponse>> getAllShow() {
		try {
			if (repo.findAll().isEmpty()) {
				throw new ShowHubForbidden("List in Empty");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(showUtil.getShowList(repo.findAll()));
	}

	@Override
	public ResponseEntity<ShowResponse> getShowById(Long showId) {
		Show show = repo.findById(showId).get();
		return ResponseEntity.ok(showUtil.getShowResponse(show));
	}

	@Override
	public ResponseEntity<ShowResponse> getShowByShowName(String showName) {
		Show show = repo.findByShowName(showName);
		return ResponseEntity.ok(showUtil.getShowResponse(show));
	}

	@Override
	public ResponseEntity<ShowResponse> getShowByUrl(String showUrl) {
		Show show = repo.findByShowUrl(showUrl);
		return ResponseEntity.ok(showUtil.getShowResponse(show));
	}

	@Override
	public ResponseEntity<ShowResponse> getShowByLeadActor(String showActor) {

		Show show = repo.findByShowLeadActor(showActor);
		return ResponseEntity.ok(showUtil.getShowResponse(show));
	}

	@Override
	public ResponseEntity<ShowResponse> getShowByLeadActoress(String showActoress) {
		Show show = repo.findByShowLeadActress(showActoress);
		return ResponseEntity.ok(showUtil.getShowResponse(show));
	}

	@Override
	public ResponseEntity<ShowResponse> getShowByDirector(String showDirector) {
		Show show = repo.findByShowDirector(showDirector);
		return ResponseEntity.ok(showUtil.getShowResponse(show));
	}

	@Override
	public ResponseEntity<List<ShowResponse>> getShowsByChannelName(String channelName) {
		List<Show> showList = repo.findAll();
		
		List<Show> resShowList = new ArrayList<>();
		for (int i = 0; i <= showList.size() - 1; i++) {
			
			if (showList.get(i).getChannel().getChannelName().equals(channelName)) {

				
				resShowList.add(showList.get(i));
			}
		}
		return ResponseEntity.ok(showUtil.getShowList(resShowList));
	}

	@Override
	public ResponseEntity<List<ShowResponse>> getShowsByChannelAdmin(String channelAdminName) {

		List<Show> showList = repo.findAll();
		List<Show> resShowList = new ArrayList<>();
		for (Show show : showList) {
			if (showList.get(0).getChannel().getChannelAdmin().getAdminName().equals(channelAdminName)) {
				resShowList.add(show);
			}
		}
		return ResponseEntity.ok(showUtil.getShowList(resShowList));
	}

	// -------------------
	@Override
	public String updateShowUrlById(Long showId, String showUrl) {
		Optional<Show> show = repo.findById(showId);
//		System.out.println(show);
		if (repo.findById(showId).isEmpty()) {
			throw new ShowHubExceptionNotFound("No such show Found By Id");

		} else {
			Show show1 = show.get();
			show1.setShowUrl(showUrl);
			repo.save(show1);
		}

		return "Url updated";
	}

	@Override
	public String updateLeadActorByShowName(String Leadactor, String showName) {
		Show show = repo.findByShowName(showName);

		if (show == null) {
			throw new ShowHubExceptionNotFound("No such LeadActor Found By ShowName");
		} else {
			show.setShowLeadActor(Leadactor);
			repo.save(show);

		}

		return "LeadActor updated";
	}

	@Override
	public String updateLeadActoressByShowName(String Leadactoress, String showName) {
		Show show = repo.findByShowName(showName);

		if (show == null) {
			throw new ShowHubExceptionNotFound("No such LeadActoress Found By ShowName");

		} else {
			show.setShowLeadActress(Leadactoress);
			repo.save(show);
		}

		return "Url updated";
	}

	@Override
	public String updateDirectorByShowId(Long showId, String showDirector) {
		Optional<Show> show = repo.findById(showId);

		if (repo.findById(showId).isEmpty()) {
			throw new ShowHubExceptionNotFound("No such Id ");
		} else {
			Show show1 = show.get();
			show1.setShowDirector(showDirector);
			repo.save(show1);

		}

		return "Url updated";
	}

	@Override
	public String deleteShowByShowId(Long showId) {

		if (repo.findById(showId).isEmpty()) {
			throw new ShowHubExceptionNotFound("No such Id Found");

		} else {
			repo.deleteById(showId);
		}

		return "Show Deleted";
	}

	@Override
	public String deleteShowByShowName(String showName) {
		Show show = repo.findByShowName(showName);

		if (repo.findById(show.getShowId()).isEmpty()) {

			throw new ShowHubExceptionNotFound("No such Id Found");
		} else {
			repo.deleteById(repo.findByShowName(showName).getShowId());

		}

		return "Show Deleted";
	}

	@Override
	public String deleteShowByShowUrl(String showUrl) {
		Show show = repo.findByShowUrl(showUrl);

		if (repo.findById(show.getShowId()).isEmpty()) {
			throw new ShowHubExceptionNotFound("No such Id Found");
		} else {
			repo.deleteById(repo.findByShowUrl(showUrl).getShowId());

		}

		return "Show Deleted";
	}

	@Override
	public String deleteShowByShowShowActor(String showActor) {
		Show show = repo.findByShowLeadActor(showActor);
		if (repo.findById(show.getShowId()).isEmpty()) {
			throw new ShowHubExceptionNotFound("No such Id Found");
		} else {
			repo.deleteById(repo.findByShowLeadActor(showActor).getShowId());

		}

		return "Show Deleted";
	}

	@Override
	public String deleteShowByShowShowActress(String showActress) {
		Show show = repo.findByShowLeadActress(showActress);
		if (repo.findById(show.getShowId()).isEmpty()) {
			throw new ShowHubExceptionNotFound("No such Id Found");
		} else {
			repo.deleteById(repo.findByShowLeadActress(showActress).getShowId());

		}
		return "Show Deleted";
	}

	@Override
	public String getShowNameByNumber(int number) {
		List<Show> showList = repo.findAll();

		return showList.get(number - 1).getShowName();
	}

}
