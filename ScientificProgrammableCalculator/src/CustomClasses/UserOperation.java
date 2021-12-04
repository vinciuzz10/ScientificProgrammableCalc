/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomClasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alfonso Giso
 */
public class UserOperation {
    private String name;
    private String[] operation;

    public UserOperation(String name, String[] operation) {
        this.name = name;
        this.operation = operation;
    }

    public String getName() {
        return name;
    }

    public String[] getOperation() {
        return operation;
    }

    public void setOperation(String[] operation) {
        this.operation = operation;
    }
    
    
    
    
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
        return "UserOperation{" + "name=" + name + ", operation=" + operation + '}';
    }

    public String getOperationAsString(){
        String s="";
        for(String tmp: operation){
            s += tmp;
            s += " ";
        }
        return s;
    }
    
    
}
