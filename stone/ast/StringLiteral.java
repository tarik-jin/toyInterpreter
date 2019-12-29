package stone.ast;

import stone.Token;

public class StringLiteral extends ASTLeaf {

	public StringLiteral(Token t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	public String value() {
		return token().getText();
	}
}
