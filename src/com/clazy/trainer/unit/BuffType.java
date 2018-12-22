package com.clazy.trainer.unit;

import com.clazy.trainer.tools.Attribute;

public class BuffType extends Attribute {

	private BuffType(String _Name) {
		super(_Name, '\0');
	}
	
	public static BuffType AttackBuff = new BuffType("¹¥»÷Á¦ÌáÉý");
	public static BuffType BusterBuff = new BuffType("ºì¿¨ÐÔÄÜÌáÉý");
	public static BuffType DefenseBuff = new BuffType("·ÀÓùÁ¦ÌáÉý");
	public static BuffType InjuryDownBuff = new BuffType("ÉËº¦¼õÃâ");

}
