package com.clazy.trainer.battle.skills;

import com.clazy.trainer.Phase;
import com.clazy.trainer.battle.Battle;
import com.clazy.trainer.unit.Enemy;
import com.clazy.trainer.unit.Servant;
import com.clazy.trainer.unit.Unit;

public class TeammateEffect extends SpecificSkillEffect {
	private SpecificSkillEffect baseEffect;
	
	public TeammateEffect(SpecificSkillEffect baseEffect) {
		super(baseEffect.value.getLowerBoundValue(), baseEffect.value.getUpperBoundValue(), "");
		setBaseEffect(baseEffect);
	}

	@Override
	public void ValuedEffectOn(Battle battle, Unit self, double value) {
		if (self instanceof Servant) {
			// Íæ¼Ò·½
			for (int i = 0; i < 3 && i < battle.getTeam().size(); ++ i) {
				baseEffect.ValuedEffectOn(battle, battle.getTeam().get(i), value);
			}
		} else if (self instanceof Enemy) {
			// CPU·½
			if (!battle.getStage().getPhases().isEmpty()) {
				Phase CurrentPhase = battle.getStage().getPhases().get(0);
				for (int i = 0; i < 3 && i < CurrentPhase.getEnemies().size(); ++ i) {
					baseEffect.ValuedEffectOn(battle, CurrentPhase.getEnemies().get(i), value);
				}
			}
		}
	}

	public SpecificSkillEffect getBaseEffect() {
		return baseEffect;
	}

	private void setBaseEffect(SpecificSkillEffect baseEffect) {
		this.baseEffect = baseEffect;
	}
}
