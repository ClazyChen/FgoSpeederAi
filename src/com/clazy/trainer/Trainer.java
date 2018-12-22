package com.clazy.trainer;

public class Trainer {
	
	private static ServantBox Box;
	private static Stage Opponents;
	
	public static int Initialize() {
		Box = new ServantBox();
		boolean InitializeSuccess = true;
		if (Box.readFromFile("static/servants.txt") != 0) {
			System.out.println("初始化错误：读取从者列表失败。");
			InitializeSuccess = false;
		}
		Opponents = new Stage();
		if (Opponents.readFromFile("static/enemies.txt") != 0) {
			System.out.println("初始化错误：读取关卡信息失败。");
			InitializeSuccess = false;
		}
		if (!InitializeSuccess) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		if (Initialize() != 0) {
			System.out.println("初始化失败，程序异常退出。");
		}
		Box.print();
		Opponents.print();
	}
}
