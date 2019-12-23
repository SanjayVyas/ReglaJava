/**
 * -----------------------------------------------------------------------------
 * File: 	EngineAttributes.java 
 * Project: ReglaJava 
 * Author: 	Sanjay Vyas
 *
 *
 * -----------------------------------------------------------------------------
 * Revision History [SV] 2019-Dec-22 11.42: Created
 * -----------------------------------------------------------------------------
 */
package Regla;

public class EngineAttributes<Component, Output> {
    private static int engineCount = 0;
    public String name;
    Component component = null;
    Output output = null;
    public boolean stopOnException = true;
    public boolean stopOnRuleFailure = false;

    // Core constructor
    public EngineAttributes(String name, final Component component, final Output output, final boolean stopOnException,
            final boolean stopOnRuleFailure) {
        if (name == null || name.trim().isEmpty())
            this.name = "Engine_" + ++EngineAttributes.engineCount;

        this.component = component;
        this.output = output;
        this.stopOnException = stopOnException;
        this.stopOnRuleFailure = stopOnRuleFailure;
    }

    // Java doesn't have default params 😞
    public EngineAttributes(final String name) {
        this(name, null, null, true, false);
    }

    public EngineAttributes(final String name, final Component component, final Output output) {
        this(name, component, output, true, false);
    }

    public EngineAttributes(final String name, final Component component) {
        this(name, component, null, true, false);
    }

    public EngineAttributes(final Component component, final Output output) {
        this(null, component, output, true, false);
    }

    public EngineAttributes(final Component component) {
        this(null, component, null, true, false);
    }

    public EngineAttributes() {
        this(null, null, null, true, false);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Component getComponent() {
        return component;
    }

    public Output getOutput() {
        return output;
    }

    public boolean isStopOnException() {
        return stopOnException;
    }

    public void setStopOnException(final boolean stopOnException) {
        this.stopOnException = stopOnException;
    }

    public boolean isStopOnRuleFailure() {
        return stopOnRuleFailure;
    }

    public void setStopOnRuleFailure(final boolean stopOnRuleFailure) {
        this.stopOnRuleFailure = stopOnRuleFailure;
    }
}