package com.clazy.trainer.unit;

import com.clazy.trainer.tools.Attribute;

public class BuffType extends Attribute {

	private BuffType(String _Name) {
		super(_Name, '\0');
	}
	
	public static BuffType AttackBuff = new BuffType("����������");
	public static BuffType BusterBuff = new BuffType("�쿨��������");
	public static BuffType DefenseBuff = new BuffType("����������");
	public static BuffType InjuryDownBuff = new BuffType("�˺�����");

}
