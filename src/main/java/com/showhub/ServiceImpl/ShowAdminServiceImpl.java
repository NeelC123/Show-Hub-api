package com.showhub.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.showhub.exception.ShowHubExceptionNotFound;
import com.showhub.exception.ShowHubUnauthorized;
import com.showhub.model.ShowAdmin;
import com.showhub.repo.ShowAdminRepo;
import com.showhub.req.ShowAdminReq;
import com.showhub.response.ShowAdminResponse;
import com.showhub.service.ShowAdminService;
import com.showhub.util.ShowAdminUtil;

@Service
public class ShowAdminServiceImpl implements ShowAdminService {

	@Autowired
	ShowAdminRepo repo;
	@Autowired
	ShowAdminUtil util;

	@Override
	public ResponseEntity<ShowAdminResponse> addShowAdmin(ShowAdminReq showAdminReq) {
		
		ShowAdmin admin = util.getShowAdmin(showAdminReq);

		try {
			if (repo.findByShowAdminEmail(admin.getShowAdminEmail()) == null) {
				repo.save(admin);
			} else {
				throw new ShowHubExceptionNotFound("Email Already Exist");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(util.createResponse(admin));
	}

	@Override
	public ResponseEntity<ShowAdminResponse> validateShowAdmin(String email, String password) {

		try {
			if (repo.findByShowAdminEmailAndShowAdminPassword(email, password) == null) {
				throw new ShowHubUnauthorized("Email Id Or Password Wrong");
			} else {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ShowAdmin admin = repo.findByShowAdminEmail(email);

		return ResponseEntity.ok(util.createResponse(admin));
	}

	@Override
	public ResponseEntity<ShowAdminResponse> updateShowAdmin(ShowAdminReq adminReq) {
		
		ShowAdmin admin =repo.findByShowAdminEmail(adminReq.getShowAdminEmail());
		
		if(admin!=null) {
			admin.setShowAdminName(adminReq.getShowAdminName());
			admin.setShowAdminPassword(adminReq.getShowAdminPassword());
			System.out.println(admin);
			repo.save(admin);
		}
		else {
			throw new ShowHubExceptionNotFound("Show Admin Not Found ");
		}
		return ResponseEntity.ok(util.createResponse(admin));
	}

}
