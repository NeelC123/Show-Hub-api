package com.showhub.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.showhub.model.Channel;
import com.showhub.model.Show;

@Repository
public interface ShowRepo extends JpaRepository<Show, Long> {

	Show findByShowUrl(String showUrl);

	Show findByShowName(String showName);

	Show findByShowDirector(String showDirector);

	Show findByShowLeadActor(String showLeadActor);

	Show findByShowLeadActress(String showLeadActress);

	Show findByChannel(Channel channel);

	
}
