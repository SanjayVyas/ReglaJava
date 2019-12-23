
/**
 *-----------------------------------------------------------------------------
 * File:      Rule.java
 * Project:   ReglaJava
 * Author:    Sanjay Vyas
 *
 *
 *-----------------------------------------------------------------------------
 * Revision History
 *   [SV] 2019-Dec-22 11.42: Created
 *-----------------------------------------------------------------------------
 */
package Regla;

import java.util.function.BiFunction;

public class Rule<Component, Output> {
    BiFunction<Component, Output, Boolean> ruleMethod = null;
    RuleAttributes ruleAttributes = null;

    public Rule(BiFunction<Component, Output, Boolean> ruleMethod, RuleAttributes ruleAttributes) {
        this.ruleMethod = ruleMethod;
        this.ruleAttributes = ruleAttributes;
    }

    public Rule(BiFunction<Component, Output, Boolean> ruleMethod) {
        this.ruleMethod = ruleMethod;
        this.ruleAttributes = new RuleAttributes();
    }

    public Rule(BiFunction<Component, Output, Boolean> ruleMethod, String name) {
        this.ruleMethod = ruleMethod;
        this.ruleAttributes = new RuleAttributes(name);
    }

    public Rule(BiFunction<Component, Output, Boolean> ruleMethod, String name, String group, boolean enabled,
            boolean stopOnException, boolean stopOnRuleFailure) {
        this.ruleMethod = ruleMethod;
        this.ruleAttributes = new RuleAttributes(name, group, enabled, stopOnException, stopOnRuleFailure);
    }

    public boolean runRule(Component component, Output output) throws Exception {
        if (ruleMethod != null)
            return this.ruleMethod.apply(component, output);
        throw new Exception("Cannot run undefined methods");
    }

    public RuleAttributes getRuleAttributes() {
        return ruleAttributes;
    }

    public void setRuleAttributes(RuleAttributes ruleAttributes) {
        this.ruleAttributes = ruleAttributes;
    }
}