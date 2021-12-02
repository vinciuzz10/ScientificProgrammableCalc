package DataStructures;

import CustomClasses.ComplexNumber;
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
        super();
        for (Character c: "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()){
            put(c, ComplexNumber.ZERO);
        }
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