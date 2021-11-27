package DataStructures;

import ComplexNumberClass.ComplexNumber;
import java.util.TreeMap;

/**
 *
 * @author Vinciuzz10
 */
public class Variables {
    
    private TreeMap<Character, ComplexNumber> variableSet = new TreeMap<Character, ComplexNumber>();

    public Variables() {
        ComplexNumber zero = new ComplexNumber(0.0);
        for (Character c: "abcdefghijklmnopqrstuvwxyz".toCharArray()){
            variableSet.put(c, zero);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Variables{" + "variableSet=" + variableSet + '}';
    }
    
    /**
     *
     * @param variableKey
     * @param newValue
     */
    public void setVariableValue(Character variableKey, ComplexNumber newValue) {
        variableSet.put(variableKey, newValue);
    }
    
    /**
     *
     * @param variableKey
     * @return
     */
    public ComplexNumber getVariableValue(Character variableKey) {
        return variableSet.get(variableKey);
    }
    
    /**
     *
     * @param variableKey
     * @param value
     */
    public void addToVariable(Character variableKey, ComplexNumber value) {
        ComplexNumber newValue = variableSet.get(variableKey).add(value);
        variableSet.put(variableKey, newValue);
    }
    
    /**
     *
     * @param variableKey
     * @param value
     */
    public void subtractToVariable(Character variableKey, ComplexNumber value) {
        ComplexNumber newValue = variableSet.get(variableKey).subtract(value);
        variableSet.put(variableKey, newValue);
    }
    
}
