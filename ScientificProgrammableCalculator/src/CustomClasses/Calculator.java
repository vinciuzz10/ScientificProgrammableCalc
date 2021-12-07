package CustomClasses;

import CalculatorExceptions.InvalidOperandsException;
import DataStructures.NumberStack;
import DataStructures.Variables;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * This class manages the communication between the controller and the model.
 * @author Vinciuzz10
 */
public class Calculator {
    
    /** The stack of {@code ComplexNumber} entered by the user. */
    private final NumberStack stack;
    /** The map of variables. */
    private Variables var;
    
    private final Stack<Variables> variablesStack;
    
    /** A map that associates to a {@code String}, that represents an operation, a function to perform.
     e.g.  "dup" -> dup()*/
    private final Map<String,Runnable> operationMap;

    /**
     * Create an object {@code Calculator} given the stack of numbers and the variables collection.
     * @param stack the stack of {@code ComplexNumber}.
     * @param var the map of variables.
     */
    public Calculator(NumberStack stack, Variables var){
        this.stack = stack;
        this.var = var;
        variablesStack = new Stack<>();
        
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
     * Perform the sum between the last and the second last element contained into the stack.
     * The function calls the method of the class {@code ComplexNumber}.
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
     * Perform the difference between the second last and the last element contained into the stack.
     * The function calls the method of the class {@code ComplexNumber}.
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
     * Perform the product between the last and the second last element contained into the stack.
     * The function calls the method of the class {@code ComplexNumber}.
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
     * Perform the quotient between the second last and the last element contained into the stack.
     * The function calls the method of the class {@code ComplexNumber}.
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
     * Perform the square root of the last element contained into the stack.
     * The function calls the method of the class {@code ComplexNumber}.
     */
    public void sqrt() {
        if (stack.isEmpty()) {
            throw new InvalidOperandsException();
        }
        ComplexNumber n = stack.pop();
        stack.push(n.sqrt());
    }
    
    /**
     * Compute the opposite the last element contained into the stack.
     * The function calls the method of the class {@code ComplexNumber}.
     */
    public void invertSign() {
        if (stack.isEmpty()) {
            throw new InvalidOperandsException();
        }
        ComplexNumber n = stack.pop();
        stack.push(n.opposite());
    }
    
    /**
     * Store the last entered number in the variable specified as a parameter.
     * @param varKey the variable to be updated.
     */
    public void storeInVariable(Character varKey) {
        ComplexNumber n = stack.pop();
        var.put(varKey, n);
    }
    
    /**
     * Push onto the stack the value of the variable specified as a parameter.
     * @param varKey the variable to be picked.
     */
    public void pickFromVariable(Character varKey) {
        stack.push(var.get(varKey));
    }
    
    /**
     * Add the last entered number to the variable specified as a parameter.
     * @param varKey the variable to be updated.
     */
    public void addToVariable(Character varKey) {
        ComplexNumber value = var.get(varKey);
        ComplexNumber newValue = value.add(stack.pop());
        var.put(varKey, newValue);
    }
    
    /**
     * Subtract the last entered number to the variable specified as a parameter.
     * @param varKey the variable to be updated.
     */
    public void subtractToVariable(Character varKey) {
        ComplexNumber value = var.get(varKey);
        ComplexNumber newValue = value.subtract(stack.pop());
        var.put(varKey, newValue);
    }
    
    /**
     * Execute the user-defined operation specified as a parameter if it is valid.
     * A user-defined operation is valid if contains only basic operations.
     * @param op the user-defined operation to be executed.
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
            try {
                function.run();
            } catch (InvalidOperandsException e) {
                stack.clear();
                stack.addAll(tmp);
                return false;
            } 
        }
        return true;
    }
    
    /**
     *
     */
    public void storeVariablesStatus() {
        Variables tmp = new Variables();
        tmp.putAll(var);
        variablesStack.push(tmp);
    }
    
    /**
     *
     * @return
     */
    public boolean restoreVariableStatus() {
        Variables tmp;
        try {
            tmp = variablesStack.pop();
        } catch (EmptyStackException e) {
            return false;
        }
        var.clear();
        var.putAll(tmp);
        return true;
    }
}
