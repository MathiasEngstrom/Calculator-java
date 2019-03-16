import java.util.Map;

public class AbsoluteValue extends Function {

  public AbsoluteValue (Sexpr operand) {
  super(operand);
  }
  
  public String getName() {
  return "abs";
  }
  
    public Sexpr eval(Map<String,Sexpr> map) {
    return Symbolic.abs(operand.eval(map)); 
  }
}