package stone.ast;

import java.util.List;

public class ArrayLiteral extends ASTList {

	public ArrayLiteral(List<ASTree> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}
	public int size() {
		return numChildren();
	}
}
