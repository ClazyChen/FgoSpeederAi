package com.clazy.trainer.tools;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 实现一张随机数表
 * @author Clazy
 *
 */
public class RandomTable {
	
	private static List<Double> table;
	private static int count;
	
	private static final int TableSize = 0x1000;
	
	private RandomTable() {
	}
	
	public static double getDouble() {
		if (table == null) {
			RefreshTable();
		}
		if (count < TableSize) {
			return table.get(count++);
		} else {
			RefreshTable();
			return table.get(count = 0);
		}
	}
	
	public static int getInt() {
		return (int) (Double.doubleToRawLongBits(getDouble()) & 0x7fffffff);
	}
	
	public static int getIntBetween(int lowerBound, int upperBound) {
		int DirectInteger = getInt();
		return DirectInteger % (upperBound - lowerBound) + lowerBound;
	}
	
	private static void RefreshTable() {
		table = new Random().doubles(TableSize).boxed().collect(Collectors.toList());
	}
}
