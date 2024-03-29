/** 
 * Represents a multiplication operation
 */
import java.util.Map;

public class Multiplication
  extends Binary
{
  public Multiplication(Sexpr left, Sexpr right) {
    super(left, right);
  }

  public String getName() {
    return "*";
  }
  
  @Override 
  public int priority() {
    return 30;
  }
  
  public Sexpr eval(Map<String, Sexpr>map) {
    return Symbolic.mul(left.eval(map), right.eval(map));
  }
  
    public Sexpr diff(Sexpr x) {
    return Symbolic.add(Symbolic.mul(left.diff(x), right), Symbolic.mul(right.diff(x), left));
  }
}