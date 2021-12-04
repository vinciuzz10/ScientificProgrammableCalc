package DataStructures;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import CustomClasses.ComplexNumber;

/**
 *
 * @author Vinciuzz10
 */

/** This class represents a stack which memorizes the numbers entered by the user (using a LIFO technology). */
public class NumberStack extends Stack<ComplexNumber> {
    
    /**
     * Swap the last and the second last elements contained into the stack.
     */
    public void swap() {
        if (size() < 2) 
            return;
        ComplexNumber last = pop();
        ComplexNumber secondLast = pop();
        push(last);
        push(secondLast);
    }
    
    /**
     * Push onto the stack a copy of the second last element.
     */
    public void over() {
        if (size() < 2) {
            return;
        }
        ComplexNumber last = pop();
        ComplexNumber secondLast = peek();
        push(last);
        push(secondLast);
    }
    
    /**
     * Push onto the stack a copy of the last element.
     */
    public void dup() {
        if (isEmpty())
            return;
        push(peek());
    }
    
    /**
     * Gives a List representation of the structure.
     * The first element is the last element of the stack.
     * @return a list containing the elements into the stack.
     */
    public List<ComplexNumber> toList() {
        if (isEmpty()) {
            return new ArrayList<>();
        }
        List<ComplexNumber> numbersList = new ArrayList<>(this);
        
        Collections.reverse(numbersList);
        return numbersList;
    } 

}
