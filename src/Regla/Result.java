
/**
 * -----------------------------------------------------------------------------
 * File: 	Result.java 
 * Project: ReglaJava 
 * Author: 	Sanjay Vyas
 *
 *
 * -----------------------------------------------------------------------------
 * Revision History [SV] 2019-Dec-23 12.58: Created
 * -----------------------------------------------------------------------------
 */
package Regla;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Result<Component, Output> {
    EngineAttributes<Component, Output> engineAttributes;
    RunResultAttributes runResultAttributes;
    List<RuleResultAttributes<Component, Output>> ruleResultAttributesList;

    public EngineAttributes<Component, Output> getEngineAttributes() {
        return engineAttributes;
    }

    public RunResultAttributes getRunResultAttributes() {
        return runResultAttributes;
    }

    public List<RuleResultAttributes<Component, Output>> getRuleResultAttributes() {
        return ruleResultAttributesList;
    }

    public Result(EngineAttributes<Component, Output> engineAttributes, RunResultAttributes runResultAttributes,
            List<RuleResultAttributes<Component, Output>> ruleResultAttributesList) {
        this.engineAttributes = engineAttributes;
        this.runResultAttributes = runResultAttributes;
        this.ruleResultAttributesList = ruleResultAttributesList;
    }

    @Override
    public String toString() {
    	GsonBuilder builder = new GsonBuilder();
    	builder.serializeNulls();
    	Gson gson = builder.setPrettyPrinting().create();
    	

        return gson.toJson(this);
    }
}