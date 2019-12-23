/**
 * -----------------------------------------------------------------------------
 * File: 	RuleResultAttributes.java 
 * Project: ReglaJava 
 * Author: 	Sanjay Vyas
 *
 *
 * -----------------------------------------------------------------------------
 * Revision History 
 * 	[SV] 2019-Dec-23 12.55: Created
 * -----------------------------------------------------------------------------
 */
package Regla;
public class RuleResultAttributes<Component, Output> {
    Rule<Component, Output> rule;
    boolean returnValue;
    Exception exception;
 

    public Rule<Component, Output> getRule() {
        return rule;
    }

    public boolean isReturnValue() {
        return returnValue;
    }

    public Exception getException() {
        return exception;
    }
    
    public String getExceptionMessage() {
    	return exception.getMessage();
    			
    }
    

    public RuleResultAttributes(Rule<Component, Output> rule, boolean returnValue, java.lang.Exception exception) {
        this.rule = rule;
        this.returnValue = returnValue;
        this.exception = exception;
    }
}
