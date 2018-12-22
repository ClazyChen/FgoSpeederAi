package com.clazy.trainer.battle;

import java.util.List;

import com.clazy.trainer.Phase;
import com.clazy.trainer.Stage;
import com.clazy.trainer.tools.AttributeDisplay;
import com.clazy.trainer.unit.Enemy;
import com.clazy.trainer.unit.Servant;

public class Battle extends AttributeDisplay {
	private Stage stage;
	private List<Servant> team;
	
	public Stage getStage() {
		return stage;
	}

	public List<Servant> getTeam() {
		return team;
	}

	public Battle(Stage _stage, Servant...servants) {
		stage = new Stage();
		for (Phase phase : _stage.getPhases()) {
			Phase CopyPhase = new Phase();
			for (Enemy enemy : phase.getEnemies()) {
				CopyPhase.getEnemies().add(enemy.clone());
			}
			stage.getPhases().add(CopyPhase);
		}
		for (Servant servant : servants) {
			team.add(servant.clone());
		}
	}
	
	/**
	 * 选择一个己方的英灵，在模拟器/AI模式应当有不同的结果
	 * @return 己方全灭时返回null
	 */
	public Servant ChooseServant() {
		if (getTeam().isEmpty()) {
			return null;
		}
		return getTeam().get(0);
	}
	
	/**
	 * 选择一个敌人，在模拟器/AI模式应当有不同的结果
	 * @return 敌方全灭时返回null
	 */
	public Enemy ChooseEnemy() {
		if (getStage().getPhases().isEmpty() || getStage().getPhases().get(0).getEnemies().isEmpty()) {
			return null;
		}
		return getStage().getPhases().get(0).getEnemies().get(0);
	}
	
	/**
	 * 随机选择一个敌人，用于敌方发动对队友技能
	 * @return 敌方全灭时返回null
	 */
	public Enemy RandomEnemy() {
		if (getStage().getPhases().isEmpty() || getStage().getPhases().get(0).getEnemies().isEmpty()) {
			return null;
		}
		List<Enemy> enemies = getStage().getPhases().get(0).getEnemies();
		if (3 < enemies.size()) {
			return enemies.get()
		}
	}
}
