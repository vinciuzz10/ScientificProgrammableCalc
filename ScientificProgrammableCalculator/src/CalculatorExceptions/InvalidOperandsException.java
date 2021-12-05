/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package CalculatorExceptions;

/**
 *
 * @author alfa1
 */
public class InvalidOperandsException extends RuntimeException{

    /**
     * Creates a new instance of <code>InvalidOperandsException</code> without
     * detail message.
     */
    public InvalidOperandsException(){
    }

    /**
     * Constructs an instance of <code>InvalidOperandsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidOperandsException(String msg) {
        super(msg);
    }
}
