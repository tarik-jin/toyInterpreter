package stone.ast;

import java.util.ArrayList;
import java.util.Iterator;

import stone.Token;

public class ASTLeaf extends ASTree {

	private static ArrayList<ASTree> empty = new ArrayList<ASTree>();
	protected Token token;
	public ASTLeaf(Token t) {
		token = t;
	}
	@Override
	public ASTree child(int i) {
		// TODO Auto-generated method stub
		throw new IndexOutOfBoundsException();
	}

	@Override
	public int numChildren() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<ASTree> children() {
		// TODO Auto-generated method stub
		return empty.iterator();
	}

	public String toString() {
		return token.getText();
	}
	
	@Override
	public String location() {
		// TODO Auto-generated method stub
		return "at line " + token.getLineNumber();
	}

	public Token token() {
		return token;
	}
}
