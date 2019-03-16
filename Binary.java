/**
 * Base class for all binary operators
 */
public abstract class Binary 
  extends Sexpr
{
  protected Sexpr left;
  protected Sexpr right;
  
  public Binary(Sexpr left, Sexpr right) {
    this.left = left;
    this.right = right;
  }
  
  /* 
   * The toString-method should be refined so that parentheses are used only when needed
   */
  @Override 
  public String toString() {
    String leftString = left.toString();
    String rightString = right.toString();
    if (left.priority() < this.priority()) {
      leftString = "(" + leftString + ")";
    }
    if (right.priority() <= this.priority()) {
      rightString = "(" + rightString + ")"; 
    }
    return leftString + getName() + rightString;
  }
}
  
  