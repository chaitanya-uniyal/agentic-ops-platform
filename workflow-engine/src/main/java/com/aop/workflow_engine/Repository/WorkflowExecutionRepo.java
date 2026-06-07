package com.aop.workflow_engine.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aop.workflow_engine.model.WorkflowExecution;

public interface WorkflowExecutionRepo extends JpaRepository<WorkflowExecution,String> {
    List<WorkflowExecution> findByWorkflowId(String workflowId);
    List<WorkflowExecution> findByStatus(String status);
    // Week 3: recovery scheduler uses findByStatus("RUNNING") to find stuck executions
    List<WorkflowExecution> findByStatusAndCreatedAtBefore(String status, LocalDateTime cutoff);    
    
}