import java.util.Map;

public class Exponential extends Function {

  public Exponential (Sexpr operand) {
  super(operand);
  }
  
  public String getName() {
  return "exp";
  }
  
    public Sexpr eval(Map<String,Sexpr> map) {
    return Symbolic.exp(operand.eval(map)); 
  }
  
  public Sexpr diff(Sexpr x) {
    return Symbolic.mul(operand.diff(x), Symbolic.exp(operand));
  }
}