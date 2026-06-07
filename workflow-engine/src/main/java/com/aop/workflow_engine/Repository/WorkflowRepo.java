package com.aop.workflow_engine.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aop.workflow_engine.model.Workflow;

public interface WorkflowRepo extends JpaRepository<Workflow,String> {
    Optional<Workflow> findByWorkflowId(String workflowId);
    // Spring reads the method name and writes the SQL: WHERE workflow_id = ?
}
