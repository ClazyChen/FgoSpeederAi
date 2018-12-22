package com.clazy.trainer.battle;

import com.clazy.trainer.tools.Attribute;

public class NoblePhantasmType extends Attribute {

	private NoblePhantasmType(String _Name, char _Symbol) {
		super(_Name, _Symbol);
	}
	
	public static NoblePhantasmType getBySymbol(char TargetSymbol) {
		return (NoblePhantasmType)(Attribute.getBySymbol(TargetSymbol, NoblePhantasmType.class));
	}
	
	public static NoblePhantasmType SingleTarget = new NoblePhantasmType("single target", 'S');
	public static NoblePhantasmType MultipleTargets = new NoblePhantasmType("multiple targets", 'M');
	public static NoblePhantasmType NonAttack = new NoblePhantasmType("non-attack", 'N');
}
