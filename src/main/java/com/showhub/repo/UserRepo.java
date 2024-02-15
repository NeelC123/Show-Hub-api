package com.showhub.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.showhub.model.Userchannel;

public interface UserRepo extends JpaRepository<Userchannel, Long> {

	Userchannel findByUserEmail(String userEmail);

	List<Userchannel> findByUserName(String userName);

	List<Userchannel> findByUserEmailAndUserPassword(String userEmail, String userPassword);
}
