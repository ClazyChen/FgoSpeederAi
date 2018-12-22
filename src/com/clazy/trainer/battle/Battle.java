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
	 * ѡ��һ��������Ӣ�飬��ģ����/AIģʽӦ���в�ͬ�Ľ��
	 * @return ����ȫ��ʱ����null
	 */
	public Servant ChooseServant() {
		if (getTeam().isEmpty()) {
			return null;
		}
		return getTeam().get(0);
	}
	
	/**
	 * ѡ��һ�����ˣ���ģ����/AIģʽӦ���в�ͬ�Ľ��
	 * @return �з�ȫ��ʱ����null
	 */
	public Enemy ChooseEnemy() {
		if (getStage().getPhases().isEmpty() || getStage().getPhases().get(0).getEnemies().isEmpty()) {
			return null;
		}
		return getStage().getPhases().get(0).getEnemies().get(0);
	}
	
	/**
	 * ���ѡ��һ�����ˣ����ڵз������Զ��Ѽ���
	 * @return �з�ȫ��ʱ����null
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
