package com.service.voteup.voteupservice.dto;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VoteDTO {

	private Long id;
	private String title;
	private String description;
	private LocalDateTime createDate;
	private boolean active;
	private Set<VoteOptionDTO> options;

}
