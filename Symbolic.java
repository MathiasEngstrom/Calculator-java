/**
 * Methods for symbolic arithmetic.
 */
public class Symbolic {
 
  /**
   * Perform a symbolic/numeric addition
   * Note: The method should be elaborated to handle
   * handle several special cases (e.g addition of zero)
   */
  public static Sexpr add(Sexpr left, Sexpr right) {
    if (left.isConstant() && right.isConstant()) {
      return new Constant(left.getValue()+ right.getValue());
    } else if (left.isConstant(0)) {
      return right;
    } else if (right.isConstant(0)) {
      return left;
    } else if (right.toString().equals(left.toString())){
    return Symbolic.mul(new Constant(2), left);
    } else {
      return new Addition(left, right);
    }
  }
  
  public static Sexpr sub(Sexpr left, Sexpr right) {
    if (left.isConstant() && right.isConstant()) {
      return new Constant(left.getValue()- right.getValue());
    } else if (left.isConstant(0)) {
      return Symbolic.negate(right);
    } else if (right.isConstant(0)) {
      return left;
    } else {
      return new Subtraction(left, right);
    }
  }
  
  /**
   * Perform a symbolic/numeric multiplication
   * Note: The method should be elaborated to handle several
   * special cases (e.g multiplication with zero or one)
   */
  public static Sexpr mul(Sexpr left, Sexpr right) {
if (left.isConstant() && right.isConstant()) {
      return new Constant(left.getValue() * right.getValue());
    } else if (left.isConstant(0) || right.isConstant(0)) {
      return new Constant(0);
    } else if (left.isConstant(1)) {
      return right;
    } else if (right.isConstant(1)) {
      return left;
    } else {
      return new Multiplication(left, right);
    }
  }
  
  /**
   * Perform a symbolic/numeric negation
   */  
  public static Sexpr negate(Sexpr operand) {
   if (operand.isConstant())
     return new Constant(-operand.getValue());
   else
     return new Negation(operand);
  }
  
  public static Sexpr cos(Sexpr operand) {
    if (operand.isConstant())
      return new Constant(Math.cos(operand.getValue()));
    else 
      return new Cosinus(operand);  
  }

  public static Sexpr sin(Sexpr operand) {
    if (operand.isConstant())
      return new Constant(Math.sin(operand.getValue()));
    else 
      return new Sinus(operand);  
  }
  
    public static Sexpr exp(Sexpr operand) {
    if (operand.isConstant())
      return new Constant(Math.exp(operand.getValue()));
    else 
      return new Exponential(operand);  
  }
    
    public static Sexpr abs(Sexpr operand) {
      if (operand.isConstant())
        return new Constant(Math.abs(operand.getValue()));
      else 
        return new AbsoluteValue(operand);  
    } 
    
    public static Sexpr log(Sexpr operand) {
      if (operand.isConstant())
        return new Constant(Math.log(operand.getValue()));
      else 
        return new Logarithm(operand);  
    }
    
    public static Sexpr div(Sexpr left, Sexpr right) {
      if (right.isConstant(0)){
        throw new EvaluationException("Cannot divide by 0");
      }
      if (left.isConstant() && right.isConstant()) {
        return new Constant(left.getValue() / right.getValue());
      } else if (left.isConstant(0)) {
        return new Constant(0);
      } else if (right.isConstant(1)) {
        return left;
      } else {
        return new Division(left, right);
      }
    }
    
}