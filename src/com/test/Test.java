package com.test;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
//		创建一个一维数组 ，然后将其内容打乱
		int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		Random r = new Random();
		for (int i = 0; i < tempArr.length; i++) {
			int index = r.nextInt(tempArr.length);
			int temp = tempArr[i];
			tempArr[i] = tempArr[index];
			tempArr[index] = temp;
		}
//		在将打乱的一维数组，每4位，放到二维数组中  // 方法一:
		int[][] data = new int[4][4];
		for (int i = 0; i < tempArr.length; i++) {
			data[i / 4][i % 4] = tempArr[i];
		}
//		int num = 0;
//		for (int i = 0; i < data.length; i++) {
//			for (int j = 0; j < data.length; j++) {
//				data[i][j] = tempArr[num];
//				num++;
//			}
//		}
//		for (int i = 0; i < data.length; i++) {
//			for (int j = 0; j < data.length; j++) {
//				System.out.print(data[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
}
