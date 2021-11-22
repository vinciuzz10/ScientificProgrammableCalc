package scientificprogrammablecalculator.datastruct;
import com.vm.jcomplex.Complex;
import java.util.Stack;

/**
 *
 * @author Vinciuzz10
 */

/** This class represents a stack which memorizes the numbers entered by the user (using a LIFO technology). */
public class NumberStack extends Stack<Complex> {
    
    /**
     * This function swap the last and the second last elements contained into the stack.
     */
    public void swap() {
        Complex last = pop();
        Complex secondLast = pop();
        push(last);
        push(secondLast);
    }
    
    /**
     * This function push onto the stack a copy of the second last element.
     */
    public void over() {
        Complex last = pop();
        Complex secondLast = peek();
        push(last);
        push(secondLast);
    }
    
    /**
     * This function push onto the stack a copy of the last element.
     */
    public void dup() {
        push(peek());
    }

}
