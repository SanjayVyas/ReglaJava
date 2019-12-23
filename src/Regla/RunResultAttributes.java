/**
 * -----------------------------------------------------------------------------
 * File: 	RunResultAttributes.java 
 * Project: ReglaJava 
 * Author: 	Sanjay Vyas
 *
 *
 * -----------------------------------------------------------------------------
 * Revision History [SV] 2019-Dec-23 12.47: Created
 * -----------------------------------------------------------------------------
 */
package Regla;

public class RunResultAttributes {
    int totalRulesCount;
    int rulesExecutedCount;
    String executionType;
    String failedRuleName;
    String failureReason;

    public int getTotalRulesCount() {
        return totalRulesCount;
    }

    public int getRulesExecutedCount() {
        return rulesExecutedCount;
    }

    public String getExecutionType() {
        return executionType;
    }

    public String getFailedRuleName() {
        return failedRuleName;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public RunResultAttributes(int totalRulesCount, int rulesExecutedCount, String executionType, String failedRuleName,
            String failureReason) {
        this.totalRulesCount = totalRulesCount;
        this.rulesExecutedCount = rulesExecutedCount;
        this.executionType = executionType;
        this.failedRuleName = failedRuleName;
        this.failureReason = failureReason;
    }
}