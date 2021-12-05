package CustomClasses;

import CalculatorExceptions.InvalidOperandsException;
import DataStructures.NumberStack;
import DataStructures.Variables;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vinciuzz10
 */
public class Calculator {
    private final NumberStack stack;
    private final Variables var;
    
    private final Map<String,Runnable> operationMap;

    /**
     *
     * @param stack
     * @param var
     */
    public Calculator(NumberStack stack, Variables var){
        this.stack = stack;
        this.var = var;
        
        operationMap = new HashMap<>();
        operationMap.put("+", () -> sum());
        operationMap.put("-", () -> difference());
        operationMap.put("*", () -> product());
        operationMap.put("/", () -> quotient());
        operationMap.put("rad", () -> sqrt());
        operationMap.put("invSign", () -> invertSign());
        operationMap.put("swap", () -> stack.swap());
        operationMap.put("dup", () -> stack.dup());
        operationMap.put("over", () -> stack.over());
        operationMap.put("del", () -> stack.pop());
        operationMap.put("clear", () -> stack.clear());
    }
    
    /**
     *
     */
    public void sum() {
        if (stack.size() < 2) {
            throw new InvalidOperandsException();
        }
        ComplexNumber n1 = stack.pop();
        ComplexNumber n2 = stack.pop();
        stack.push(n1.add(n2));
    }
    
    /**
     *
     */
    public void difference() {
        if (stack.size() < 2) {
            throw new InvalidOperandsException();
        }
        ComplexNumber n1 = stack.pop();
        ComplexNumber n2 = stack.pop();
        stack.push(n2.subtract(n1));
    }
    
    /**
     *
     */
    public void product() {
        if (stack.size() < 2) {
            throw new InvalidOperandsException();
        }
        ComplexNumber n1 = stack.pop();
        ComplexNumber n2 = stack.pop();
        stack.push(n2.multiply(n1));
    }
    
    /**
     *
     */
    public void quotient() {
        if (stack.size() < 2) {
            throw new InvalidOperandsException();
        }
        ComplexNumber n1 = stack.pop();
        ComplexNumber n2 = stack.pop();
        stack.push(n2.divide(n1));
    }
    
    /**
     *
     */
    public void sqrt() {
        if (stack.isEmpty()) {
            throw new InvalidOperandsException();
        }
        ComplexNumber n = stack.pop();
        stack.push(n.sqrt());
    }
    
    /**
     *
     */
    public void invertSign() {
        if (stack.isEmpty()) {
            throw new InvalidOperandsException();
        }
        ComplexNumber n = stack.pop();
        stack.push(n.opposite());
    }
    
    /**
     *
     * @param varKey
     */
    public void storeInVariable(Character varKey) {
        ComplexNumber n = stack.pop();
        var.put(varKey, n);
    }
    
    /**
     *
     * @param varKey
     */
    public void pickFromVariable(Character varKey) {
        stack.push(var.get(varKey));
    }
    
    /**
     *
     * @param varKey
     */
    public void addToVariable(Character varKey) {
        ComplexNumber value = var.get(varKey);
        ComplexNumber newValue = value.add(stack.pop());
        var.put(varKey, newValue);
    }
    
    /**
     *
     * @param varKey
     */
    public void subtractToVariable(Character varKey) {
        ComplexNumber value = var.get(varKey);
        ComplexNumber newValue = value.subtract(stack.pop());
        var.put(varKey, newValue);
    }
    
    /**
     *
     * @param op
     */
    public boolean executeUserOperation(UserOperation op) {
        for (String subOp: op.getOperation()) {
            if (!operationMap.keySet().contains(subOp)) {
                return false;
            }
        }
        NumberStack tmp = new NumberStack();
        tmp.addAll(stack);
        for (String subOp: op.getOperation()) {
            Runnable function = operationMap.get(subOp);
            try{
                function.run();
            }catch(InvalidOperandsException e){
                System.out.println("ERRORE");
                stack.clear();
                stack.addAll(tmp);
                return false;
            } 
        }
        return true;
    }
}
