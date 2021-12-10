package CustomClasses;

import CalculatorExceptions.InvalidOperandsException;
import DataStructures.NumberStack;
import DataStructures.Variables;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * This class manages the communication between the controller and the model.
 * @author Vinciuzz10
 */
public class Calculator {
    
    /** The stack of {@code ComplexNumber} entered by the user. */
    private final NumberStack stack;
    /** The map of variables. */
    private final Variables var;
    /** A Stack for storing variables values. */
    private final Stack<Variables> variablesStack;
    
    /** A map which associates to a {@code String}, that represents an operation, a function to perform.
     e.g.  "dup" -> dup()*/
    private final Map<String,Runnable> operationMap;

    /**
     * Create an object of the class {@code Calculator}.
     */
    public Calculator(){
        this.stack = new NumberStack();
        this.var = new Variables();
        variablesStack = new Stack<>();
        
        operationMap = new HashMap<>();
        operationMap.put("+", () -> sum());
        operationMap.put("-", () -> difference());
        operationMap.put("*", () -> product());
        operationMap.put("/", () -> quotient());
        operationMap.put("rad", () -> sqrt());
        operationMap.put("invSign", () -> invertSign());
        operationMap.put("swap", () -> swap());
        operationMap.put("dup", () -> dup());
        operationMap.put("over", () -> over());
        operationMap.put("del", () -> del());
        operationMap.put("clear", () -> clear());
    }

    /**
     *
     * @return
     */
    public NumberStack getStack() {
        return stack;
    }

    /**
     *
     * @return
     */
    public Variables getVar() {
        return var;
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
            throw new EmptyStackException();
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
            throw new EmptyStackException();
        }
        ComplexNumber n = stack.pop();
        stack.push(n.opposite());
    }
    
    
    // --------------------- STACK OPERATIONS ---------------------
    
    /**
     *
     * @param n1
     */
    public void push(ComplexNumber n1) {
        stack.push(n1);
    }
    
    /**
     *
     * @return
     */
    public ComplexNumber peek() {
        return stack.peek();
    }
    
    /**
     *
     * @return
     */
    public ComplexNumber pop() {
        return stack.pop();
    }
    
    /**
     *
     */
    public void dup() {
        stack.dup();
    }
    
    /**
     *
     */
    public void swap() {
        stack.swap();
    }
    
    /**
     *
     */
    public void del() {
        stack.pop();
    }
    
    /**
     *
     */
    public void clear() {
        stack.clear();
    }
    
    /**
     *
     */
    public void over() {
        stack.over();
    }
    
    
    // ------------------- VARIABLES OPERATIONS -------------------
    
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
     * Push the variables values onto a stack to restore and use them in next operations.
     */
    public void storeVariablesStatus() {
        Variables tmp = new Variables();
        tmp.putAll(var);
        variablesStack.push(tmp);
    }
    
    /**
     * Restore the variables values, perforiming the pop on the variables stack.
     */
    public void restoreVariableStatus() {
        if (variablesStack.isEmpty()) {
            throw new EmptyStackException();
        }
        Variables tmp = variablesStack.pop();
        var.clear();
        var.putAll(tmp);
    }
    
    
    // ------------------- USER-DEFINED OPERATIONS -------------------
    
    /**
     * Execute the user-defined operation specified as a parameter if it is valid.
     * A user-defined operation is valid if contains only basic operations.
     * @param op the user-defined operation to be executed.
     * @return true if the operation can be performed. Otherwise returns false.
     */
    public boolean executeUserOperation(UserOperation op) {
        NumberStack tmp = new NumberStack();
        tmp.addAll(stack);
        for (String subOp: op.getOperation()) {
            try {
                if (subOp.startsWith(">")) {
                    storeInVariable(subOp.substring(1).charAt(0));
                } else if (subOp.startsWith("<")) {
                    pickFromVariable(subOp.substring(1).charAt(0));
                } else if (subOp.length() == 2 && subOp.startsWith("+")) {
                    addToVariable(subOp.substring(1).charAt(0));
                } else if (subOp.length() == 2 && subOp.startsWith("-")) {
                    subtractToVariable(subOp.substring(1).charAt(0));
                } else {
                    Runnable function = operationMap.get(subOp);
                    function.run();
                }
            } catch (Exception e) {
                stack.clear();
                stack.addAll(tmp);
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns a Set of {@code String} containing all the allowed operations.
     * @return 
     */
    public Set<String> getAllowedOperations() {
        return operationMap.keySet();
    }
    
    /**
     *
     * @param op
     */
    public void addOperationToMap(UserOperation op) {
        operationMap.put(op.getName(), () -> executeUserOperation(op));
    }
}
