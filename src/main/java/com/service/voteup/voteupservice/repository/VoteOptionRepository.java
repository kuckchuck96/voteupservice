package com.service.voteup.voteupservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.voteup.voteupservice.model.VoteOption;

@Repository
public interface VoteOptionRepository extends JpaRepository<VoteOption, Long> {

}
