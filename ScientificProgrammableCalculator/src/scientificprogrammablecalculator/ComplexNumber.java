/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificprogrammablecalculator;

/**
 *
 * @author Vinciuzz10
 */
public class ComplexNumber {
    
    /** The square root of -1. A number representing "0.0 + 1.0i" */
    public static final ComplexNumber I = new ComplexNumber(0.0, 1.0);
    // CHECKSTYLE: stop ConstantName
    /** A complex number representing "NaN + NaNi" */
    public static final ComplexNumber NaN = new ComplexNumber(Double.NaN, Double.NaN);
    // CHECKSTYLE: resume ConstantName
    /** A complex number representing "+INF + INFi" */
    public static final ComplexNumber INF = new ComplexNumber(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    /** A complex number representing "1.0 + 0.0i" */
    public static final ComplexNumber ONE = new ComplexNumber(1.0, 0.0);
    /** A complex number representing "0.0 + 0.0i" */
    public static final ComplexNumber ZERO = new ComplexNumber(0.0, 0.0);
    
        
    /** The imaginary part. */
    private final double imaginary;
    /** The real part. */
    private final double real;

    
    //private static final DecimalFormat df = new DecimalFormat("0.000");
    
    
    /**
     * Create a complex number given the real and imaginary parts.
     */
    public ComplexNumber(double real, double imaginary) {
        this.imaginary = imaginary;
        this.real = real;
    }
    
    /**
     * Create a complex number given only the real part.
     */
    public ComplexNumber (double real) {
        this(real, 0.0);
    }

    /**
     * Returns the imaginary part of the complex number as a double.
     * @return the double value representing the imaginary part of the complex number.
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Returns the real part of the complex number as a double.
     * @return the double value representing the real part of the complex number.
     */
    public double getReal() {
        return real;
    }
    
    /**
     * Utility method which returns a String representation of the complex number calling the method "toString".
     * @return a string representing the complex number like "5+6j" or "-6-3j"
     */
    public String getComplexString() {
        return this.toString();
    }
    
    /**
     * Returns a ComplexNumber whose value is {@code (this + addend)}. Uses the definitional formula
     * <p>
     *   {@code (a + bj) + (c + dj) = (a+c) + (b+d)j}
     * </p>
     * @param other Value to be added to this {@code ComplexNumber}.
     * @return {@code this + addend}.
     */
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.getReal(), imaginary + other.getImaginary());
    }
    
    /**
     * Returns a ComplexNumber whose value is {@code (this - subtrahend)}. Uses the definitional formula
     * <p>
     *   {@code (a + bj) - (c + dj) = (a-c) + (b-d)j}
     * </p>
     * @param other Value to be subtracted to this {@code ComplexNumber}.
     * @return {@code this - subtrahend}.
     */
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }
    
    /**
     * Returns a ComplexNumber whose value is {@code (this * subtrahend)}. Uses the definitional formula
     * <p>
     *   {@code (a + bi)(c + di) = (ac - bd) + (ad + bc)j}
     * </p>
     * @param other Value to be multiplied by this {@code ComplexNumber}.
     * @return {@code this * subtrahend}.
     */
    public ComplexNumber multiply(ComplexNumber other) {
        return new ComplexNumber(real * other.real - imaginary * other.imaginary, real * other.imaginary + imaginary * other.real);
    }
    
    /**
     * Returns a ComplexNumber whose value is {@code (this / subtrahend)}. Uses the definitional formula
     * <p>
     *   {@code (a + bi)/(c + di) = [ac + bd + (bc - ad)j]/(c^2 + d^2)}
     * </p>
     * @param other Value to be multiplied by this {@code ComplexNumber}.
     * @return {@code this * subtrahend}.
     */
    public ComplexNumber divide(ComplexNumber other) {
        double realPartNumerator = real * other.real + imaginary * other.imaginary;
        double imaginaryPartNumerator = imaginary * other.real - real * other.imaginary;
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        
        return new ComplexNumber(realPartNumerator/denominator, imaginaryPartNumerator/denominator);
    }

    /**
     * Return the absolute value of this complex number.
     * @return the absolute value
     */
    public double abs() {
        return Math.sqrt(real*real + imaginary*imaginary);
    }
    
    /**
     *
     * @return
     */
    public double phase() {
        if (real == 0 && imaginary > 0) {
            return Math.PI/2;
        }
        if (real == 0 && imaginary < 0) {
            return -Math.PI/2;
        }
        if (real > 0) {
            return Math.atan(imaginary/real);
        }
        if (real < 0 && imaginary >= 0) {
            return Math.atan(imaginary/real) + Math.PI;
        }
        if (real < 0 && imaginary < 0) {
            return Math.atan(imaginary/real) - Math.PI;
        }
        else return Double.NaN;
    }
    
    /**
     * Returns the sqare root of a complex number as a ComplexNumber
     * @return a ComplexNumber representing the square root of the complex number.
     */
    public ComplexNumber sqrt() {
        if (imaginary == 0 && real <0) {
            return new ComplexNumber(0.0, Math.sqrt(-real));
        }
        double phase = this.phase();
        double realPart = Math.sqrt(this.abs()) * Math.cos(phase/2);
        double imaginaryPart = Math.sqrt(this.abs()) * Math.sin(phase/2);
        
        return new ComplexNumber(realPart, imaginaryPart);
    }
    
    /**
     * 
     * @return
     */
    public ComplexNumber opposite() {
        return new ComplexNumber(-real, -imaginary);
    }
    
    /**
     *
     * @return
     */
    public ComplexNumber conjugate() {
        return new ComplexNumber(real, -imaginary);
    }
    
    /**
     * Gives a string representation for a complex number.
     * @return A string that represent the complex number (e.g. "2+3j).
     */
    @Override
    public String toString() {
        if (imaginary == 0) {
            return String.valueOf(real);
        }
        if (real == 0) {
            return String.valueOf(imaginary) + "j";
        }
        if (imaginary > 0) {
            return String.valueOf(real) + "+" + String.valueOf(imaginary) + "j";
        } else {
            return String.valueOf(real) + String.valueOf(imaginary) + "j";
        }
    }    

    
}
