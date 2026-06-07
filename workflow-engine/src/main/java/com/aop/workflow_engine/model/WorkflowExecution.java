package com.aop.workflow_engine.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Workflow_Execution")
@Data
public class WorkflowExecution {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Column(name = "workflow_id", nullable = false)
    private String workflowId;

    @Column(name = "Status",nullable = false)
    private String status;
    // PENDING   → just created, not started yet
    // RUNNING   → currently executing
    // SUCCESS   → all steps passed
    // FAILED    → stopped due to a step failure
    // PARTIAL   → some steps failed but onFailure=CONTINUE let it finish

    @Column(name = "Triggered_By", nullable = false)
    private String triggeredBy;

    @Column(name = "Created_At", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "Started_At")
    private LocalDateTime startedAt;

    @Column(name = "Ended_At")
    private LocalDateTime endedAt;

    @Column(name = "Error_Message")
    private String errorMessage;


}
