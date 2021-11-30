package DataStructures;

import ComplexNumberClass.ComplexNumber;
import java.util.HashMap;

/**
 *
 * @author Vinciuzz10
 */
public class Variables extends  HashMap<Character, ComplexNumber>{
    
    //private HashMap<Character, ComplexNumber> variableSet = new HashMap<Character, ComplexNumber>();

    /**
     * Create an object of the class Variables containing a Map with all variables setted to ZERO (0.0 + 0.0j).
     */
    public Variables() {
        for (Character c: "abcdefghijklmnopqrstuvwxyz".toCharArray()){
            put(c, ComplexNumber.ZERO);
        }
    }
    
    /**
     * Set the value of a variable to the {@code ComplexNumber} passed as a parameter.
     * @param variableKey the key of the variable to be updated
     * @param newValue the value to set
     */
    public void setVariableValue(Character variableKey, ComplexNumber newValue) {
        put(variableKey, newValue);
    }
    
    /**
     * Returns the value of the variable with the key passed as a parameter.
     * @param variableKey the key of the variable.
     * @return the value of the variable with {@code key = variableKey}.
     */
    public ComplexNumber getVariableValue(Character variableKey) {
        return get(variableKey);
    }
    
    /**
     * Add a {@code ComplexNumber} to the value of the variable with {@code key = variableKey}.
     * @param variableKey the key of the variable to be updated.
     * @param value the {@code ComplexNumber} to be added to the variable value.
     */
    public void addToVariable(Character variableKey, ComplexNumber value) {
        ComplexNumber newValue = get(variableKey).add(value);
        put(variableKey, newValue);
    }
    
    /**
     * Subtract a {@code ComplexNumber} to the value of the variable with {@code key = variableKey}.
     * @param variableKey the key of the variable to be updated.
     * @param value the {@code ComplexNumber} to be subtracted to the variable value.
     */
    public void subtractToVariable(Character variableKey, ComplexNumber value) {
        ComplexNumber newValue = get(variableKey).subtract(value);
        put(variableKey, newValue);
    }
    
}