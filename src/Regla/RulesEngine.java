
/**
 * -----------------------------------------------------------------------------
 * File: 	RulesEngine.java 
 * Project: ReglaJava 
 * Author: 	Sanjay Vyas
 *
 *
 * -----------------------------------------------------------------------------
 * Revision History [SV] 2019-Dec-22 11.52: Created
 * -----------------------------------------------------------------------------
 */
package Regla;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RulesEngine<Component, Output> {
    EngineAttributes<Component, Output> engineAttributes = new EngineAttributes<Component, Output>();
    List<Rule<Component, Output>> rulesList = new LinkedList<Rule<Component, Output>>();

    public RulesEngine(EngineAttributes<Component, Output> engineAttributes, List<Rule<Component, Output>> rulesList) {
        if (engineAttributes != null)
            this.engineAttributes = engineAttributes;
        if (rulesList != null)
            this.rulesList = rulesList;
    }

    public RulesEngine(EngineAttributes<Component, Output> engineAttributes, Rule<Component, Output>[] rulesArray) {
        this(engineAttributes, Arrays.asList(rulesArray));
    }

    public RulesEngine(EngineAttributes<Component, Output> engineAttributes) {
        this(engineAttributes, (List<Rule<Component, Output>>) null);
    }

    public RulesEngine() {
        this(null, (List<Rule<Component, Output>>) null);
    }

    public RulesEngine(String name) {
        this(new EngineAttributes<>(name), (List<Rule<Component, Output>>) (null));
    }

    public RulesEngine(Component component) {
        this(new EngineAttributes<>(component), (List<Rule<Component, Output>>) (null));
    }

    public RulesEngine(Component component, Output output) {
        this(new EngineAttributes<>(component, output), (List<Rule<Component, Output>>) (null));
    }

    public RulesEngine(String name, Component component) {
        this(new EngineAttributes<>(name, component), (List<Rule<Component, Output>>) (null));
    }

    public RulesEngine(String name, Component component, Output output) {
        this(new EngineAttributes<>(name, component, output), (List<Rule<Component, Output>>) (null));
    }

    public RulesEngine(String name, Component component, Output output, boolean stopOnException,
            boolean stopOnRuleFailure) {
        this(new EngineAttributes<>(name, component, output, stopOnException, stopOnRuleFailure));
    }

    public RulesEngine<Component, Output> AddRule(Rule<Component, Output> rule) {
        rulesList.add(rule);
        return this;
    }

    public RulesEngine<Component, Output> AddRule(Rule<Component, Output>[] array) {
        rulesList.addAll(Arrays.asList(array));
        return this;
    }

    private Result<Component, Output> RunRules(List<Rule<Component, Output>> rulesList, String executionType) {
        var ruleResultAttributesList = new LinkedList<RuleResultAttributes<Component, Output>>();
        var rulesExecutedCount = 0;

        for (var rule : rulesList) {
            var returnValue = false;
            Exception exception = null;

            try {
                returnValue = rule.runRule(engineAttributes.component, engineAttributes.output);
            } catch (Exception e) {
                exception = e;
            } finally {
                ruleResultAttributesList.add(new RuleResultAttributes<>(rule, returnValue, exception));
            }

            rulesExecutedCount++;

            if (exception != null && (engineAttributes.stopOnException || rule.ruleAttributes.stopOnException))
                return new Result<Component, Output>(engineAttributes, new RunResultAttributes(rulesList.size(),
                        rulesExecutedCount, executionType, rule.ruleAttributes.name, "Exception"),
                        ruleResultAttributesList);

            if (returnValue == false && (engineAttributes.stopOnRuleFailure || rule.ruleAttributes.stopOnRuleFailure))
                return new Result<Component, Output>(engineAttributes, new RunResultAttributes(rulesList.size(),
                        rulesExecutedCount, executionType, rule.ruleAttributes.name, "RuleFailure"),
                        ruleResultAttributesList);

        }

        return new Result<>(engineAttributes,
                new RunResultAttributes(rulesList.size(), rulesExecutedCount, executionType, null, null),
                ruleResultAttributesList);
    }

    public Result<Component, Output> RunAllRules() {
        return RunRules(rulesList, "All");
    }

    public Result<Component, Output> RunNamedRules(String... names) {
        var namedRulesList = new LinkedList<Rule<Component, Output>>();

        var ruleNames = new String[names.length];
        for (var name : ruleNames)
            name = name.trim().toLowerCase();
        var ruleNameList = Arrays.asList((ruleNames));

        for (var rule : rulesList)
            if (ruleNameList.contains(rule.ruleAttributes.name.trim().toLowerCase())) {
                namedRulesList.add(rule);
            }
        return RunRules(rulesList, String.join(",", names));
    }

    public Result<Component, Output> RunGroupRules(String group) {
        var namedRulesList = new LinkedList<Rule<Component, Output>>();
        var groupName = group.trim().toLowerCase();

        for (var rule : rulesList) {
            if (groupName.equals(rule.ruleAttributes.group.trim().toLowerCase()))
                namedRulesList.add(rule);
        }

        return RunRules(namedRulesList, group);
    }
}