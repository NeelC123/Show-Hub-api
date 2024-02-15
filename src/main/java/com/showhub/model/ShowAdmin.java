package com.showhub.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "MyShowAdmin_Test1", uniqueConstraints = @UniqueConstraint(name = "showAdminEmail_unique", columnNames = "showAdminEmail"))
public class ShowAdmin {
	
	@Id
	@SequenceGenerator(name = "showadmin_sequence", sequenceName = "showadmin_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "showadmin_sequence")
	private Long showAdminId;
	private String showAdminName;
	private String showAdminEmail;
	private String showAdminPassword;
	@OneToMany(mappedBy = "ShowAdmin", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Show> showList;

}
