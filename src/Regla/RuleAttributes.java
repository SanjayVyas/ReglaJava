/**
 * -----------------------------------------------------------------------------
 * File: 	RuleAttributes.java 
 * Project: ReglaJava 
 * Author: 	Sanjay Vyas
 *
 *
 * -----------------------------------------------------------------------------
 * Revision History [SV] 2019-Dec-22 11.42: Created
 * -----------------------------------------------------------------------------
 */
package Regla;

public class RuleAttributes {
    String name = "";
    String group = "default";
    boolean enabled = true;
    boolean stopOnException = true;
    boolean stopOnRuleFailure = false;

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isStopOnException() {
        return stopOnException;
    }

    public void setStopOnException(boolean stopOnException) {
        this.stopOnException = stopOnException;
    }

    public boolean isStopOnRuleFailure() {
        return stopOnRuleFailure;
    }

    public void setStopOnRuleFailure(boolean stopOnRuleFailure) {
        this.stopOnRuleFailure = stopOnRuleFailure;
    }

    public RuleAttributes() {

    }

    public RuleAttributes(String name) {
        this.name = name;
    }

    public RuleAttributes(String name, String group, boolean enabled, boolean stopOnException,
            boolean stopOnRuleFailure) {
        this.name = name;
        this.group = group;
        this.enabled = enabled;
        this.stopOnException = stopOnException;
        this.stopOnRuleFailure = stopOnRuleFailure;

    }
}