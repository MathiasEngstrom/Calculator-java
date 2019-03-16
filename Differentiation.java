import java.util.Map;

public class Differentiation 
  extends Binary {

  public Differentiation(Sexpr left, Sexpr right) {
    super(left, right);
  }
  
    @Override 
  public int priority() {
    return 40;
  }
  
    public String getName() {
    return "'";
  }
    
      public Sexpr eval(Map<String,Sexpr> map) {
    return left.eval(map).diff(right);
  }
}
