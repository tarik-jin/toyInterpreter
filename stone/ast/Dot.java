package stone.ast;

import java.util.List;

public class Dot extends Postfix {

	public Dot(List<ASTree> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}
	public String name() {
		return ((ASTLeaf)child(0)).token().getText();
	}
	public String toString() {
		return "." + name();
	}

}
