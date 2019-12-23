/**
 * -----------------------------------------------------------------------------
 * File: 	Program.java 
 * Project: ReglaJava 
 * Author: 	Sanjay Vyas
 *
 *
 * -----------------------------------------------------------------------------
 * Revision History [SV] 2019-Dec-23 1.51: Created
 * -----------------------------------------------------------------------------
 */
import Regla.*;

class Program {
    public static void main(String[] args) {
        var engine = new RulesEngine<Object, Object>();
        Rule<Object, Object> rule = new Rule<Object, Object>((c, o) -> {
            System.out.println("Hello, World");
            return true;
        });
        engine.AddRule(rule);
        var result = engine.RunAllRules();
        System.out.println(result.toString());
    }
    
}