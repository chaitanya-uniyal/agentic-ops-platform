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
@Table(name="workflow_step")
@Data
public class WorkflowStep {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;

    @Column(name = "workflow_id",nullable = false)
    private String workflowId;

    @Column(name = "step_id",nullable = false)
    private String stepId;

    @Column(name = "step_type", nullable = false)
    private String stepType;

    @Column(name = "step_order", nullable = false)
    private Integer stepOrder;

    @Column(name = "name", nullable = false)
    private String name;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")

    private Map<String,Object> config;

    @Column(name = "retry_Max_Attempts")
    private Integer retryMaxAttempts;

    @Column(name = "retry_Backoff_Ms")
    private Integer retryBackoffMs = 1000;

    @Column(name = "on_Failure")
    private String onFailure = "STOP";

    @Column(name = "depends_On")
    private String dependsOn;

    @Column(name = "created_At")
    private LocalDateTime createdAt = LocalDateTime.now();



}
