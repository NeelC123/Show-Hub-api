package com.showhub.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Show_Test1", uniqueConstraints = @UniqueConstraint(name = "showName_unique", columnNames = "showName"))
public class Show {

	@Id
	@SequenceGenerator(name = "show_sequence", sequenceName = "show_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "show_sequence")
	private Long showId;
	private String showName;
	private String showUrl;
	private String showLeadActor;
	private String showLeadActress;
	private String showDirector;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "channel_id",referencedColumnName = "channelId")
	private Channel channel;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "showAdmin_id",referencedColumnName = "showAdminId")
	private ShowAdmin ShowAdmin;

}
