package stone.ast;

import java.util.List;

public class Fun extends ASTList {

	public Fun(List<ASTree> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}
	public ParameterList parameters() {
		return (ParameterList)child(0);
	}
	public BlockStmnt body() {
		return (BlockStmnt)child(1);
	}
	public String toString() {
		return "(" + parameters() + " " + body() + ")";
	}
}
