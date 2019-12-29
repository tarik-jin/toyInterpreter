package stone.ast;

import java.util.List;

public class NegativeExpr extends ASTList {

	public NegativeExpr(List<ASTree> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}
	public ASTree operand() {
		return child(0);
	}
	public String toString() {
		return "-" + operand();
	}
}
