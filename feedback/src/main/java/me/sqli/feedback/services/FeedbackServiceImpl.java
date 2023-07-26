package me.sqli.feedback.services;

import java.util.List;

import org.springframework.stereotype.Service;

import me.sqli.feedback.entities.Feedback;
import me.sqli.feedback.repositories.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback getFeedbackById(Long feedbackId) {
        return feedbackRepository.findById(feedbackId).orElse(null);
    }

    @Override
    public List<Feedback> getAllFeedbacksByAccountNo(Long accountNo) {
        return feedbackRepository.findAllByAccountNo(accountNo);
    }

    @Override
    public void deleteFeedback(Long feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }
}
