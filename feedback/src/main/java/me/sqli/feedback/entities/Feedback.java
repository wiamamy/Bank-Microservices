package me.sqli.feedback.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Feedback {
    @Id
    @Column(name = "feedback_id")
    private Long feedbackId;

    @Column(name = "account_no", nullable = false)
    private Long accountNo;

    @Column(name = "feedback", nullable = false, length = 1000)
    private String feedback;

    @Column(name = "hearts")
    private Integer hearts;

    @Column(name = "time", nullable = false)
    private Date time;
}
