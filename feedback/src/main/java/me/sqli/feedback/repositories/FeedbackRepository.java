package me.sqli.feedback.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.sqli.feedback.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findAllByAccountNo(Long accountNo);
}
