package com.showhub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MyChannelAdmin_Test", uniqueConstraints = @UniqueConstraint(name = "adminEmail_unique", columnNames = "adminEmail"))

public class ChannelAdmin {
	@Id
	@SequenceGenerator(name = "channelAdmin_sequence", sequenceName = "channelAdmin_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "channelAdmin_sequence")
	private Long adminId;
	private String adminName;

	private String adminEmail;
	private String adminPassword;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "channelAdmin")
	@JoinColumn(name = "channel_id", referencedColumnName = "channelId")
	@JsonIgnore
	private Channel channel;
	
}
