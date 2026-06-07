package com.aop.workflow_engine.model;

import java.time.LocalDateTime;
import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Execution_Step_Log")
@Data
public class ExecutionStepLog {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Column(name = "execution_id", nullable = false)
    private String executionId;

    @Column(name = "step_id", nullable = false)
    private String stepId;

    @Column(name ="status", nullable = false)
    private String status;

    @Column(name = "attempt_number", nullable = false)
    private Integer attemptNumber=1;
    

    @Column(name = "created_At")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "started_At")
    private LocalDateTime startedAt;

    @Column(name = "completed_At")
    private LocalDateTime completedAt;

    @Column(name = "error_Message")
    private String errorMessage;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "input_payload", columnDefinition = "jsonb")
    private Map<String,Object> inputPayload;


    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "output_payload", columnDefinition = "jsonb")
    private Map<String,Object> outputPayload;

}
