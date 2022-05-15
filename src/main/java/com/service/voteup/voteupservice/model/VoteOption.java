package com.service.voteup.voteupservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class VoteOption {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "option_id")
	private Long id;

	@Column(nullable = false)
	private String label;
	private int count = 0;

	@ManyToOne
	@JoinColumn(name = "vote_id", nullable = false)
	private Vote vote;

}
