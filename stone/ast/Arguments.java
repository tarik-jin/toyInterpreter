package stone.ast;

import java.util.List;

public class Arguments extends Postfix {

	public Arguments(List<ASTree> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}
	
	public int size() {
		return numChildren();
	}

}
