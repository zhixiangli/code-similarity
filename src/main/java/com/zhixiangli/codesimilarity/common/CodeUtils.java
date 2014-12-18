/**
 * 
 */
package com.zhixiangli.codesimilarity.common;

/**
 * @author lizhixiang
 *
 */
public class CodeUtils {

	public static String removeComment(String before) {
		StringBuilder after = new StringBuilder();

		int size = before.length();
		for (int i = 0; i < size; i++) {
			if (i < size - 1 && before.charAt(i) == '/'
					&& before.charAt(i + 1) == '/') {
				for (i++; i < size; i++) {
					if (before.charAt(i) == '\n') {
						break;
					}
				}
			} else {
				after.append(before.charAt(i));
			}
		}
		before = after.toString();
		after.delete(0, after.length());

		size = before.length();
		int flag = 0;
		for (int i = 0; i < size; i++) {
			if (i < size - 1 && before.charAt(i) == '/'
					&& before.charAt(i + 1) == '*') {
				++flag;
			} else if (i > 0 && before.charAt(i - 1) == '*'
					&& before.charAt(i) == '/') {
				--flag;
			} else if (flag == 0) {
				after.append(before.charAt(i));
			}
		}

		return after.toString();
	}

	public static String removeBlank(String before) {
		StringBuilder after = new StringBuilder();
		int size = before.length();
		for (int i = 0; i < size; i++) {
			char ch = before.charAt(i);
			if (' ' < ch && ch < Byte.MAX_VALUE) {
				after.append(ch);
			}
		}
		return after.toString();
	}
}
