package com.service.voteup.voteupservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.voteup.voteupservice.model.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

}
