package com.muxi.ui;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {
	private CodeUtil() {
	}

	public static String getCode() {
		ArrayList<Character> charList = new ArrayList<>();
		// 获取26个字母
		for (int i = 0; i < 26; i++) {
			charList.add((char) ('A' + i));
			charList.add((char) ('a' + i));
		}
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			int index = r.nextInt(charList.size());
			char c = charList.get(index);
			sb.append(c);
		}
		char[] vcArr = sb.append(r.nextInt(10)).toString().toCharArray();
		int index = r.nextInt(vcArr.length);
		char temp = vcArr[index];
		vcArr[index] = vcArr[vcArr.length - 1];
		vcArr[vcArr.length - 1] = temp;
		return new String(vcArr);
	}
}
