package com.clazy.trainer.tools;

public class LeveledType extends Attribute {

	private LeveledType(String _Name, char _Symbol) {
		super(_Name, _Symbol);
	}
	
	public static LeveledType NoblePhantasmLevel = new LeveledType("���ߵȼ�", '\0');
	public static LeveledType NoblePhantasmOcLevel = new LeveledType("�����ܵȼ�", '\0');
	public static LeveledType SkillLevel = new LeveledType("���ܵȼ�", '\0');
}
