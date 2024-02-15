package com.showhub.service;

import org.springframework.http.ResponseEntity;

import com.showhub.req.ShowAdminReq;
import com.showhub.response.ShowAdminResponse;
/**
 * 
 * @author neeluchandra
 * 
 * 
 */


public interface ShowAdminService {

	ResponseEntity<ShowAdminResponse> addShowAdmin(ShowAdminReq showAdminReq);

	ResponseEntity<ShowAdminResponse> validateShowAdmin(String email, String password);

	ResponseEntity<ShowAdminResponse> updateShowAdmin(ShowAdminReq adminReq);

	

}
