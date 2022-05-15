package com.service.voteup.voteupservice.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VoteOptionDTO {

	private Long id;
	private String label;
	private int count;

}
