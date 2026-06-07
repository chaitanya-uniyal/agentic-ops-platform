package com.aop.workflow_engine.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aop.workflow_engine.model.WorkflowStep;

public interface WorkflowStepRepo extends JpaRepository<WorkflowStep,String> {
    List<WorkflowStep> findByWorkflowIdOrderByStepOrderAsc(String workflowId);
    // This is the key query — executor calls this to get steps in order
    
}
