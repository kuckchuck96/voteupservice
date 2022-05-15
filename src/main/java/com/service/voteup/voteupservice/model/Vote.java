package com.service.voteup.voteupservice.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vote_id")
	private Long id;

	@Column(nullable = false)
	private String title;
	private String description;
	private LocalDateTime createDate = LocalDateTime.now();

	@Column(nullable = false)
	private String passcode;
	private boolean active = true;

	@OneToMany(mappedBy = "vote", cascade = CascadeType.ALL)
	private List<VoteOption> options;

}
