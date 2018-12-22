package com.clazy.trainer.battle.skills;

import com.clazy.trainer.battle.Battle;
import com.clazy.trainer.unit.Buff;
import com.clazy.trainer.unit.BuffType;
import com.clazy.trainer.unit.Unit;

public class AttackUpEffect extends SpecificSkillEffect {

	public AttackUpEffect(double LowerValue, double UpperValue, String LastTime) {
		super(LowerValue, UpperValue, LastTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ValuedEffectOn(Battle battle, Unit self, double value) {
		self.getBuff(new Buff(BuffType.AttackBuff, value, LastTimes, LastTurns));
	}

}
