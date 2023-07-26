package me.sqli.feedback.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import me.sqli.feedback.entities.Feedback;
import me.sqli.feedback.services.FeedbackService;

@RestController
@Slf4j
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        Feedback createdFeedback = feedbackService.createFeedback(feedback);
        return new ResponseEntity<>(createdFeedback, HttpStatus.CREATED);
    }

    @GetMapping("/{feedbackId}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long feedbackId) {
        Feedback feedback = feedbackService.getFeedbackById(feedbackId);
        if (feedback == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

    @GetMapping("/account/{accountNo}")
    public ResponseEntity<List<Feedback>> getAllFeedbacksByAccountNo(@PathVariable Long accountNo) {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacksByAccountNo(accountNo);
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @DeleteMapping("/{feedbackId}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long feedbackId) {
        Feedback feedback = feedbackService.getFeedbackById(feedbackId);
        if (feedback == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        feedbackService.deleteFeedback(feedbackId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
