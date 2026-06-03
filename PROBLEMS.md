# Engineering Problems Log

## Problem 001 — Crash Recovery for Running Executions
**Date:** 3/6/26
**Layer:** Workflow Engine

**Problem:** If the application crashes while a workflow execution 
is in RUNNING state, it stays stuck in RUNNING forever. 
No automatic recovery.

**Thinking through it:**
- Can't rely on app restart to know what was running
- Need external mechanism to detect stuck executions

**Planned Solution:**
Spring Scheduler job runs every 5 minutes, finds all executions 
in RUNNING state older than configurable timeout (default 10min),
marks them FAILED with reason "execution_timeout_recovery".

**Tradeoff:**
Timeout value is tricky — too short and we false-positive on 
slow legitimate executions. Making it configurable per workflow.



