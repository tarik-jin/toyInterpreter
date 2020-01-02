package stone.ast;

import java.util.List;

public class ClassStmnt extends ASTList {

	public ClassStmnt(List<ASTree> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}
	public String name() {
		return ((ASTLeaf)child(0)).token().getText();
	}
	public String superClass() {
		if(numChildren() < 3) {
			return null;
		}
		else {
			return ((ASTLeaf)child(1)).token().getText();
		}
	}
	public ClassBody body() {
		return (ClassBody)child(numChildren() - 1);
	}
	public String toString() {
		String parent = superClass();
		if(parent == null) {
			parent = "*";
		}
		else {
			//parent is the super class name
		}
		return "(class " + name() + " " + parent + " " + body() + ")";
	}
}
