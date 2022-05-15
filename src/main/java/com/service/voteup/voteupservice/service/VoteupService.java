package com.service.voteup.voteupservice.service;

import com.service.voteup.voteupservice.model.Vote;
import com.service.voteup.voteupservice.model.VoteOption;

public interface VoteupService {

	Vote createVote(Vote vote) throws Exception;

	Vote retrieveVote(Long id) throws Exception;

	Vote closeVote(Long id, String passcode) throws Exception;

	VoteOption updateVoteOption(Long id) throws Exception;

}
