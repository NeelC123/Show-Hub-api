package com.showhub.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.showhub.model.ShowAdmin;


public interface ShowAdminRepo extends JpaRepository<ShowAdmin, Long> {
	ShowAdmin findByShowAdminEmail(String showAdminEmail);
	ShowAdmin  findByShowAdminName(String showAdminName);
	ShowAdmin findByShowAdminEmailAndShowAdminPassword(String showAdminEmail, String showAdminPassword);
}
