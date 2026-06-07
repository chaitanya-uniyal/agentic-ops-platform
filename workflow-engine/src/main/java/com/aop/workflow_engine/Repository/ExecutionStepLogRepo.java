package com.aop.workflow_engine.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aop.workflow_engine.model.ExecutionStepLog;

public interface ExecutionStepLogRepo extends JpaRepository<ExecutionStepLog,String> {

    List<ExecutionStepLog> findByExecutionIdOrderByCreatedAtAsc(String executionId);
    // Dashboard calls this to show step-by-step logs for one execution
}