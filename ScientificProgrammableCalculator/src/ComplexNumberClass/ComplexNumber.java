package ComplexNumberClass;

/**
 * This class implements the mathematical concept of Complex Number.
 * @author Vinciuzz10
 */
public class ComplexNumber {
    
    /** The square root of -1. A number representing "0.0 + 1.0j" */
    public static final ComplexNumber J = new ComplexNumber(0.0, 1.0);    
        
    /** The imaginary part. */
    private final double imaginary;
    /** The real part. */
    private final double real;
    
    /**
     * Create a complex number given the real and imaginary parts.
     * @param real the real part of the complex number.
     * @param imaginary the imaginary part of the complex number.
     */
    public ComplexNumber(double real, double imaginary) {
        this.imaginary = imaginary;
        this.real = real;
    }
    
    /**
     * Create a complex number given only the real part.
     * @param real the real part of the complex number.
     */
    public ComplexNumber (double real) {
        this(real, 0.0);
    }

    /**
     * Returns the imaginary part of the complex number as a {@code Double}.
     * @return the double value representing the imaginary part of the complex number.
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Returns the real part of the complex number as a {@code Double}.
     * @return the double value representing the real part of the complex number.
     */
    public double getReal() {
        return real;
    }
    
    /**
     * Utility method which returns a {@code String} representation of the complex number calling the method "toString".
     * @return a {@code String} representing the complex number.
     */
    public String getComplexString() {
        return toString();
    }
    
    /**
     * Returns a ComplexNumber whose value is {@code this + addend}. Uses the definitional formula
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
     * Returns a ComplexNumber whose value is {@code this - subtrahend}. Uses the definitional formula
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
     * Returns a ComplexNumber whose value is {@code this * subtrahend}. Uses the definitional formula
     * <p>
     *   {@code (a + bi)(c + di) = (ac - bd) + (ad + bc)j}
     * </p>
     * @param other Value to be multiplied by this {@code ComplexNumber}.
     * @return {@code this * subtrahend}.
     */
    public ComplexNumber multiply(ComplexNumber other) {
        return new ComplexNumber(formatter(real * other.real - imaginary * other.imaginary), formatter(real * other.imaginary + imaginary * other.real));
    }
    
    /**
     * Returns a ComplexNumber whose value is {@code this / subtrahend}. Uses the definitional formula
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
        
        return new ComplexNumber(formatter(realPartNumerator/denominator),formatter(imaginaryPartNumerator/denominator));
    }

    /**
     * Return the absolute value of this complex number.
     * @return the absolute value.
     */
    public double abs() {
        return Math.sqrt(real*real + imaginary*imaginary);
    }
    
    /**
     * Compute the phase of this complex number.
     * The phase is the angle phi between the positive real axis and
     * the point representing this number in the complex plane.
     * @return the phase of {@code this}.
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
     * Compute the <a href="http://mathworld.wolfram.com/SquareRoot.html" TARGET="_top">square root</a> 
     * of this complex number.
     * @return the square root of {@code this}.
     */
    public ComplexNumber sqrt() {
        if (imaginary == 0 && real <0) {
            return new ComplexNumber(0.0, Math.sqrt(-real));
        }
        double phase = this.phase();
        double realPart = Math.sqrt(this.abs()) * Math.cos(phase/2);
        double imaginaryPart = Math.sqrt(this.abs()) * Math.sin(phase/2);

        return new ComplexNumber(formatter(realPart),formatter(imaginaryPart));
    }
    
    /**
     * Returns a {@code ComplexNumber} whose value is {@code -this}.
     * @return {@code -this}.
     */
    public ComplexNumber opposite() {
        if (real == 0 && imaginary == 0) {
            return this;
        } 
        return new ComplexNumber(-real, -imaginary);
    }
    
    /**
     * Returns a {@code ComplexNumber} whose value is the conjugate of {@code this}.
     * The conjugate of {@code "a + bj" is "a - bj"}.
     * @return the conjugate of {@code this}.
     */
    public ComplexNumber conjugate() {
        return new ComplexNumber(real, -imaginary);
    }
    
    /**
     * Convert a {@code String} in a {@code ComplexNumber} if the string respects the format.
     * @param numberAsString String representation of a complex number.
     * @return a {@code ComplexNumber} representation of the {@code String}.
     * @throws NumberFormatException
     */
    public static ComplexNumber parseComplexNumber(String numberAsString) {
        double real, imaginary;
        String formattedString = numberAsString.replace(" ", "");

        if (!formattedString.matches("[0123456789j.+-]*")) {
            throw new NumberFormatException();
        }
        
        String[] splittedNumber = formattedString.split("[+-]");
        
        /* Case 1: "5", "5j" */
        if (splittedNumber.length == 1) {
            String number = splittedNumber[0];
            if (number.contains("j")) {
                String imaginaryAsString = number.substring(0, number.length()-1);
                if (imaginaryAsString.equals("")) {
                    return J;
                }
                imaginary = Double.parseDouble(imaginaryAsString);
                return new ComplexNumber(0, imaginary);
            } else {
                real = Double.parseDouble(splittedNumber[0]);
                return new ComplexNumber(real);
            }
        /* Case 2: "+5", "-5j", "5+3j" */
        } else if (splittedNumber.length == 2) {
            if (formattedString.charAt(0) == '-') {
                String number = splittedNumber[1];
                if (number.contains("j")) {
                    String imaginaryAsString = number.substring(0, number.length()-1);
                    if (imaginaryAsString.equals("")) {
                        return J.conjugate();
                    }
                    imaginary = Double.parseDouble(imaginaryAsString);
                    return new ComplexNumber(0, -imaginary);
                } else {
                    real = Double.parseDouble(number);
                    return new ComplexNumber(-real);
                }
            } else if (formattedString.charAt(0) == '+') {
                String number = splittedNumber[1];
                if (number.contains("j")) {
                    String imaginaryAsString = number.substring(0, number.length()-1);
                    if (imaginaryAsString.equals("")) {
                        return J;
                    }
                    imaginary = Double.parseDouble(imaginaryAsString);
                    return new ComplexNumber(0, imaginary);
                } else {
                    real = Double.parseDouble(number);
                    return new ComplexNumber(real);
                }
            } else {
                String number = splittedNumber[1];
                if (number.contains("j")) {
                    real = Double.parseDouble(splittedNumber[0]);
                    String imaginaryAsString = number.substring(0, number.length()-1);
                    if (formattedString.contains("-")) {
                        if (imaginaryAsString.equals("")) {
                            imaginary = -1;
                            return new ComplexNumber(real, imaginary);
                        }
                        imaginary = Double.parseDouble(imaginaryAsString);
                        return new ComplexNumber(real, -imaginary);
                    } else {
                        if (imaginaryAsString.equals("")) {
                            imaginary = 1;
                            return new ComplexNumber(real, imaginary);
                        }
                        imaginary = Double.parseDouble(imaginaryAsString);
                        return new ComplexNumber(real, imaginary);
                    } 
                }
            }
        /* Case 2: "+5+5j", "-5+5j" */
        } else if (splittedNumber.length == 3) {
            if (!splittedNumber[2].contains("j")) {
                throw new NumberFormatException();
            }
            if (formattedString.charAt(0) == '+') {
                real = Double.parseDouble(splittedNumber[1]);
                String imaginaryAsString = splittedNumber[2].substring(0, splittedNumber[2].length()-1);
                if (formattedString.substring(1).contains("+")) {
                    if (imaginaryAsString.equals("")) {
                        imaginary = 1;
                        return new ComplexNumber(real, imaginary);
                    }
                    imaginary = Double.parseDouble(imaginaryAsString);
                    return new ComplexNumber(real, imaginary);
                } else if (formattedString.substring(1).contains("-")) {
                    if (imaginaryAsString.equals("")) {
                        imaginary = 1;
                        return new ComplexNumber(real, -imaginary);
                    }
                    imaginary = Double.parseDouble(imaginaryAsString);
                    return new ComplexNumber(real, -imaginary);
                }
            } else if (formattedString.charAt(0) == '-') {
                real = -Double.parseDouble(splittedNumber[1]);
                String imaginaryAsString = splittedNumber[2].substring(0, splittedNumber[2].length()-1);
                if (formattedString.substring(1).contains("+")) {
                    if (imaginaryAsString.equals("")) {
                        imaginary = 1;
                        return new ComplexNumber(real, imaginary);
                    }
                    imaginary = Double.parseDouble(imaginaryAsString);
                    return new ComplexNumber(real, imaginary);
                } else if (formattedString.substring(1).contains("-")) {
                    if (imaginaryAsString.equals("")) {
                        imaginary = 1;
                        return new ComplexNumber(real, -imaginary);
                    }
                    imaginary = Double.parseDouble(imaginaryAsString);
                    return new ComplexNumber(real, -imaginary);
                }
            }
        }
        
        throw new NumberFormatException();
    }
    
    /**
     * Gives a string representation for a complex number.
     * @return A string that represent the complex number (e.g. "2+3j","-4j","3").
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

    /**
     * Check if a {@code ComplexNumber} is equals to another one, comparing the real and the imaginary part.
     * @param obj the {@code ComplexNumber} to be compared.
     * @return {@code true} if {@code this} is equals to obj.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        if (Double.doubleToLongBits(this.imaginary) != Double.doubleToLongBits(other.imaginary)) {
            return false;
        }
        if (Double.doubleToLongBits(this.real) != Double.doubleToLongBits(other.real)) {
            return false;
        }
        return true;
    }
    
    private Double formatter(Double number){
        Double formatted = Math.floor(number * 1000) / 1000;
        return formatted;
    }
    
}
