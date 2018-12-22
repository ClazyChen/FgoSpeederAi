package com.clazy.trainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.clazy.trainer.tools.AttributeDisplay;
import com.clazy.trainer.unit.Enemy;

public class Stage extends AttributeDisplay {
	private List<Phase> Phases;
	
	public Stage() {
		setPhases(new ArrayList<Phase>());
	}
	
	/**
	 * 从文件中读取信息导入到Stage中
	 * @param FileName
	 * @return 正确运行返回0
	 */
	public int readFromFile(String FileName) {
		Scanner in;
		boolean CorrectRunFlag = true;
		try {
			in = new Scanner(new File(FileName));
			Enemy LastEnemy = null;
			Phase LastPhase = null;
			int LineCount = 0;
			while (in.hasNextLine()) {
				String[] Order = in.nextLine().trim().split(" ");
				LineCount++;
				boolean CorrectOrder = false;
				if (Order.length == 2) {
					if (Order[0].equals("NEW")) {
						if (Order[1].equals("Enemy")) {
							if (LastPhase != null && LastEnemy != null) {
								LastPhase.getEnemies().add(LastEnemy);
							}
							LastEnemy = new Enemy();
							CorrectOrder = true;
						} else if (Order[1].equals("Phase")) {
							if (LastPhase != null) {
								if (LastEnemy != null) {
									LastPhase.getEnemies().add(LastEnemy);
									LastEnemy = null;
								}
								Phases.add(LastPhase);
							}
							LastPhase = new Phase();
							CorrectOrder = true;
						}
					} else {
						if (LastEnemy != null) {
							if (LastEnemy.setAttributeByOrder(Order[0], Order[1]) == 0) {
								CorrectOrder = true;
							}
						}
					}
				}
				if (!CorrectOrder) {
					System.out.println(String.format("Stage.readFromFile：非法从者信息命令：%s 于文件 %s，行%d", 
							"[" + String.join(" ", Order) + "]", FileName, LineCount));
					CorrectRunFlag = false;
				}
			}
			if (LastEnemy != null && LastPhase != null) {
				LastPhase.getEnemies().add(LastEnemy);
			}
			if (LastPhase != null && !LastPhase.getEnemies().isEmpty()) {
				Phases.add(LastPhase);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println(String.format("Stage.readFromFile：找不到从者信息文件：%s", FileName));
			CorrectRunFlag = false;
		}
		if (!CorrectRunFlag) {
			return 1;
		}
		return 0;
	}

	public List<Phase> getPhases() {
		return Phases;
	}

	private void setPhases(List<Phase> Phases) {
		this.Phases = Phases;
	}
}
