package stone;

import stone.ast.Fun;
import static stone.Parser.rule;

public class ClosureParser extends FuncParser {
	public ClosureParser(){
		primary.insertChoice(rule(Fun.class).sep("fun").ast(paramList).ast(block));
	}
}
