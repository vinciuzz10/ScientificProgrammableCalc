package CustomClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a User-defined Operation through a name and a formula.
 * @author Alfonso Giso
 */
public class UserOperation {
    
    /** The name of the USer-defined operation. */
    private final String name;
    /** The formula of the User-defined operation. */
    private String[] operation;

    /**
     * Create a {@code UserOperation} given the name and the relative formula.
     * @param name the name of the operation.
     * @param operation the formula of the operation.
     */
    public UserOperation(String name, String[] operation) {
        this.name = name;
        this.operation = operation;
    }

    /**
     * Returns the {@code name} of the operation as a {@code String}.
     * @return a {@code String} representing the name of the operation.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the list of basic operations computed by the user-defined operation.
     * @return a {@code String[]} contaning all the basic operations performed by the user-defined operation.
     */
    public String[] getOperation() {
        return operation;
    }
    
    /**
     * Returns the list of basic operations computed by the user-defined operation as a String.
     * @return a {@code String} containing all the basic operations performed by the user-defined operation.
     */
    public String getOperationAsString(){
        String s="";
        for(String tmp: operation){
            s += tmp;
            s += " ";
        }
        return s.substring(0,s.length()-1);
    }
    
    /**
     * Set the value of attribute {@code operation} to the value passed as parameter.
     * @param operation the new value of the attribute {@code operation}.
     */
    public void setOperation(String[] operation) {
        this.operation = operation;
    }

    /**
     * Split a user-operation given as a {@code String} and returns a {@code String[]}.
     * @param operation a {@code String} representing the operation to be splitted.
     * @return a {@code String[]} containing all the basic operations performed by the user-defined operation.
     */
    private List<String> operationSplitter(String operation){
        String[] operations = operation.split(" ");
        List<String> tmp = new ArrayList<>();
        for(String s: operations){
            tmp.add(s);
        }
        return tmp;
    }
    
    @Override
    public String toString() {
        return "UserOperation{" + "name=" + name + ", operation=" + getOperationAsString() + '}';
    }
}
