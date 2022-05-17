package com.service.voteup.voteupservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.service.voteup.voteupservice.dto.VoteDTO;
import com.service.voteup.voteupservice.dto.VoteOptionDTO;
import com.service.voteup.voteupservice.model.Vote;
import com.service.voteup.voteupservice.service.VoteupService;

@RestController
public class VoteupController {

	@Autowired
	private VoteupService voteupService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/create")
	public VoteDTO createVote(@RequestBody Vote vote) {
		try {
			Vote voteCreated = voteupService.createVote(vote);
			return modelMapper.map(voteCreated, VoteDTO.class);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to create vote!", ex);
		}
	}

	@GetMapping("/{id}")
	public VoteDTO getVoteData(@PathVariable Long id) {
		try {
			Vote voteRetrieved = voteupService.retrieveVote(id);
			return modelMapper.map(voteRetrieved, VoteDTO.class);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to retrieve vote!", ex);
		}
	}

	@PutMapping("/update/{id}")
	public VoteOptionDTO updateVoteOption(@PathVariable Long id) {
		try {
			return modelMapper.map(voteupService.updateVoteOption(id), VoteOptionDTO.class);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to retrieve vote option!", ex);
		}
	}

	@PostMapping("/close/{id}")
	public VoteDTO closeVote(@PathVariable Long id, String passcode) {
		try {
			return modelMapper.map(voteupService.closeVote(id, passcode), VoteDTO.class);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to close vote!", ex);
		}
	}

}
