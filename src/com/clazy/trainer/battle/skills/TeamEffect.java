package com.clazy.trainer.battle.skills;

import com.clazy.trainer.Phase;
import com.clazy.trainer.battle.Battle;
import com.clazy.trainer.unit.Enemy;
import com.clazy.trainer.unit.Servant;
import com.clazy.trainer.unit.Unit;

/**
 * 己方全体技能
 * @author Clazy
 *
 */
public class TeamEffect extends SpecificSkillEffect {
	
	private SpecificSkillEffect baseEffect;
	
	public TeamEffect(SpecificSkillEffect baseEffect) {
		super(baseEffect.value.getLowerBoundValue(), baseEffect.value.getUpperBoundValue(), "");
		setBaseEffect(baseEffect);
	}

	@Override
	public void ValuedEffectOn(Battle battle, Unit self, double value) {
		if (self instanceof Servant) {
			// 玩家方
			for (int i = 0; i < 3 && i < battle.getTeam().size(); ++ i) {
				baseEffect.ValuedEffectOn(battle, battle.getTeam().get(i), value);
			}
		} else if (self instanceof Enemy) {
			// CPU方
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
