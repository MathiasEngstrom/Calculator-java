import java.util.Map;

public class Cosinus extends Function {

  public Cosinus (Sexpr operand) {
  super(operand);
  }
  
  public String getName() {
  return "cos";
  }
  
    public Sexpr eval(Map<String,Sexpr> map) {
    return Symbolic.cos(operand.eval(map)); 
  }
  
  public Sexpr diff(Sexpr x) {
    return Symbolic.mul(operand.diff(x), Symbolic.negate(Symbolic.sin(operand)));
  }
}