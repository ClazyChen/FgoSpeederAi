package com.clazy.trainer.battle.skills;

import com.clazy.trainer.battle.Battle;
import com.clazy.trainer.unit.Buff;
import com.clazy.trainer.unit.BuffType;
import com.clazy.trainer.unit.Unit;

public class DefenseUpEffect extends SpecificSkillEffect {

	public DefenseUpEffect(double LowerValue, double UpperValue, String LastTime) {
		super(LowerValue, UpperValue, LastTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ValuedEffectOn(Battle battle, Unit self, double value) {
		// TODO Auto-generated method stub
		self.getBuff(new Buff(BuffType.DefenseBuff, value, LastTimes, LastTurns));
	}

}
