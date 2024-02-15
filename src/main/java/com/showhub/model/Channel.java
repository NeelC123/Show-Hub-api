package com.showhub.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "MyChannel_Test")
public class Channel {

	@Id
	@SequenceGenerator(name = "channel_sequence", sequenceName = "channel_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "channel_sequence")
	private Long channelId;
	private String channelName;
	private String channelOwner;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore

	private ChannelAdmin channelAdmin;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "userchannel_channel", joinColumns = @JoinColumn(name = "channel_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<Userchannel> users;
	
	
	@OneToMany(mappedBy = "channel" ,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Show> showList;

}
