package scientificprogrammablecalculator.datastruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import scientificprogrammablecalculator.ComplexNumber;

/**
 *
 * @author Vinciuzz10
 */

/** This class represents a stack which memorizes the numbers entered by the user (using a LIFO technology). */
public class NumberStack extends Stack<ComplexNumber> {
    
    /**
     * This function swap the last and the second last elements contained into the stack.
     */
    public void swap() throws EmptyStackException {
        ComplexNumber last = pop();
        ComplexNumber secondLast = pop();
        push(last);
        push(secondLast);
    }
    
    /**
     * This function push onto the stack a copy of the second last element.
     */
    public void over() throws EmptyStackException {
        if (size()<2) {
            return;
        }
        ComplexNumber last = pop();
        ComplexNumber secondLast = peek();
        push(last);
        push(secondLast);
    }
    
    /**
     * This function push onto the stack a copy of the last element.
     */
    public void dup()  throws EmptyStackException {
        push(peek());
    }
    
    /**
     *
     * @return
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
