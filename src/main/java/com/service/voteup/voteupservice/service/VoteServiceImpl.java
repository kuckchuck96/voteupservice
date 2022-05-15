package com.service.voteup.voteupservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.voteup.voteupservice.model.Vote;
import com.service.voteup.voteupservice.model.VoteOption;
import com.service.voteup.voteupservice.repository.VoteOptionRepository;
import com.service.voteup.voteupservice.repository.VoteRepository;

@Service
public class VoteServiceImpl implements VoteupService {

	@Autowired
	private VoteRepository voteRepository;

	@Autowired
	private VoteOptionRepository voteOptionRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Transactional
	@Override
	public Vote createVote(Vote vote) throws Exception {
		if (vote != null) {
			vote.getOptions().forEach(o -> o.setVote(vote));
			vote.setPasscode(encoder.encode(vote.getPasscode()));
			return voteRepository.save(vote);
		} else {
			throw new Exception("Unable to create a vote.");
		}

	}

	@Transactional(readOnly = true)
	@Override
	public Vote retrieveVote(Long id) throws Exception {
		Vote vote = voteRepository.findById(id)
				.orElseThrow(() -> new Exception(String.format("Unable to find vote with id: %d.", id)));

		return vote;
	}

	@Transactional
	@Override
	public Vote closeVote(Long id, String passcode) throws Exception {
		Vote vote = voteRepository.findById(id)
				.orElseThrow(() -> new Exception(String.format("Unable to find vote with id: %d.", id)));

		if (encoder.matches(passcode, vote.getPasscode())) {
			vote.setActive(false);
			return voteRepository.save(vote);
		} else {
			throw new Exception("Entered passcode is incorrect!");
		}
	}

	@Transactional
	@Override
	public VoteOption updateVoteOption(Long id) throws Exception {
		VoteOption option = voteOptionRepository.findById(id)
				.orElseThrow(() -> new Exception(String.format("Unable to find an option with id: %d.", id)));

		// Increment count by 1
		option.setCount(option.getCount() + 1);

		return voteOptionRepository.save(option);
	}

}
