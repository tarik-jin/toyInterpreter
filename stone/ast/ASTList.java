package stone.ast;

import java.util.Iterator;
import java.util.List;

public class ASTList extends ASTree {
	protected List<ASTree> children;
	public ASTList(List<ASTree> list) {
		children = list;
	}

	@Override
	public ASTree child(int i) {
		// TODO Auto-generated method stub
		return children.get(i);
	}

	@Override
	public int numChildren() {
		// TODO Auto-generated method stub
		return children.size();
	}

	@Override
	public Iterator<ASTree> children() {
		// TODO Auto-generated method stub
		return children.iterator();
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('(');
		String sep = "";
		for(ASTree t: children) {
			builder.append(sep);
			sep = " ";
			builder.append(t.toString());
		}
		return builder.append(')').toString();
	}
	@Override
	public String location() {
		// TODO Auto-generated method stub
		for(ASTree t: children) {
			String s = t.location();
			if(s != null) {
				return s;
			}
			else {
				
			}
		}
		return null;
	}

}
