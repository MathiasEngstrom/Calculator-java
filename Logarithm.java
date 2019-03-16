import java.util.Map;

public class Logarithm extends Function {

  public Logarithm (Sexpr operand) {
  super(operand);
  }
  
  public String getName() {
  return "log";
  }
  
    public Sexpr eval(Map<String,Sexpr> map) {
    return Symbolic.log(operand.eval(map)); 
  }
  
  public Sexpr diff(Sexpr x) {
    return Symbolic.mul(operand.diff(x), Symbolic.div(new Constant(1), operand));
  }
}