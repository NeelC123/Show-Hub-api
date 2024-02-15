package com.showhub.util;

import org.springframework.stereotype.Component;

import com.showhub.model.ShowAdmin;
import com.showhub.req.ShowAdminReq;
import com.showhub.response.ShowAdminResponse;
@Component
public class ShowAdminUtil {

	public ShowAdmin getShowAdmin(ShowAdminReq showAdminReq) {
		ShowAdmin admin = new ShowAdmin();
		admin.setShowAdminEmail(showAdminReq.getShowAdminEmail());
		admin.setShowAdminName(showAdminReq.getShowAdminName());
		admin.setShowAdminPassword(showAdminReq.getShowAdminPassword());
		return admin;
	}

	public ShowAdminResponse createResponse(ShowAdmin admin) {
		ShowAdminResponse adminResponse = new ShowAdminResponse();

		adminResponse.setShowAdminEmail(admin.getShowAdminEmail());
		adminResponse.setShowAdminId(admin.getShowAdminId());
		adminResponse.setShowAdminName(admin.getShowAdminName());
		return adminResponse;
	}

}
