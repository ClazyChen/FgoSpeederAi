package com.clazy.trainer.tools;

public class LeveledType extends Attribute {

	private LeveledType(String _Name, char _Symbol) {
		super(_Name, _Symbol);
	}
	
	public static LeveledType NoblePhantasmLevel = new LeveledType("宝具等级", '\0');
	public static LeveledType NoblePhantasmOcLevel = new LeveledType("过充能等级", '\0');
	public static LeveledType SkillLevel = new LeveledType("技能等级", '\0');
}
