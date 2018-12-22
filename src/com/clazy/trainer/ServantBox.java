package com.clazy.trainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.clazy.trainer.tools.AttributeDisplay;
import com.clazy.trainer.unit.Servant;

public class ServantBox extends AttributeDisplay {
	private List<Servant> Servants;
	
	public ServantBox() {
		setServants(new ArrayList<Servant>());
	}
	
	/**
	 * 从文件中读取信息导入到Box中
	 * @param FileName
	 * @return 正确运行返回0
	 */
	public int readFromFile(String FileName) {
		Scanner in;
		boolean CorrectRunFlag = true;
		try {
			in = new Scanner(new File(FileName));
			Servant LastServant = null;
			int LineCount = 0;
			while (in.hasNextLine()) {
				String[] Order = in.nextLine().trim().split(" ");
				LineCount++;
				boolean CorrectOrder = false;
				if (Order.length == 2) {
					if (Order[0].equals("NEW")) {
						if (Order[1].equals("Servant")) {
							if (LastServant != null) {
								Servants.add(LastServant);
							}
							LastServant = new Servant();
							CorrectOrder = true;
						}
					} else {
						if (LastServant != null) {
							if (LastServant.setAttributeByOrder(Order[0], Order[1]) == 0) {
								CorrectOrder = true;
							}
						}
					}
				}
				if (!CorrectOrder) {
					System.out.println(String.format("ServantBox.readFromFile：非法从者信息命令：%s 于文件 %s，行%d", 
							"[" + String.join(" ", Order) + "]", FileName, LineCount));
					CorrectRunFlag = false;
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println(String.format("ServantBox.readFromFile：找不到从者信息文件：%s", FileName));
			CorrectRunFlag = false;
		}
		if (!CorrectRunFlag) {
			return 1;
		}
		return 0;
	}

	public List<Servant> getServants() {
		return Servants;
	}

	private void setServants(List<Servant> Servants) {
		this.Servants = Servants;
	}
	
	
}
