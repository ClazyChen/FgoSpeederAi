package com.clazy.trainer.battle.skills;

import com.clazy.trainer.battle.Battle;
import com.clazy.trainer.unit.Buff;
import com.clazy.trainer.unit.BuffType;
import com.clazy.trainer.unit.Unit;

public class InjuryDownEffect extends SpecificSkillEffect {

	public InjuryDownEffect(double LowerValue, double UpperValue, String LastTime) {
		super(LowerValue, UpperValue, LastTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ValuedEffectOn(Battle battle, Unit self, double value) {
		// TODO Auto-generated method stub
		self.getBuff(new Buff(BuffType.InjuryDownBuff, value, LastTimes, LastTurns));
	}

}
