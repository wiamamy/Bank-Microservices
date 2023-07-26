package me.sqli.feedback.services;

import java.util.List;

import me.sqli.feedback.entities.Feedback;

public interface FeedbackService {
    Feedback createFeedback(Feedback feedback);

    Feedback getFeedbackById(Long feedbackId);

    List<Feedback> getAllFeedbacksByAccountNo(Long accountNo);

    void deleteFeedback(Long feedbackId);
}
