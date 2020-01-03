package stone.ast;

import java.util.List;

public class ArrayRef extends Postfix {

	public ArrayRef(List<ASTree> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}
	public ASTree index() {
		return child(0);
	}
	public String toString() {
		return "[" + index() + "]";
	}

}
