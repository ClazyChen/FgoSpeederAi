package com.clazy.trainer;

public class Trainer {
	
	private static ServantBox Box;
	private static Stage Opponents;
	
	public static int Initialize() {
		Box = new ServantBox();
		boolean InitializeSuccess = true;
		if (Box.readFromFile("static/servants.txt") != 0) {
			System.out.println("��ʼ�����󣺶�ȡ�����б�ʧ�ܡ�");
			InitializeSuccess = false;
		}
		Opponents = new Stage();
		if (Opponents.readFromFile("static/enemies.txt") != 0) {
			System.out.println("��ʼ�����󣺶�ȡ�ؿ���Ϣʧ�ܡ�");
			InitializeSuccess = false;
		}
		if (!InitializeSuccess) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		if (Initialize() != 0) {
			System.out.println("��ʼ��ʧ�ܣ������쳣�˳���");
		}
		Box.print();
		Opponents.print();
	}
}
