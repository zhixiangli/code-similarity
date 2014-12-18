/**
 * 
 */
package com.zhixiangli.codesimilarity.strategy;

import com.zhixiangli.codesimilarity.SimilarityAlg;
import com.zhixiangli.codesimilarity.common.CodeUtils;

/**
 * @author lizhixiang
 *
 */
public class OptimizedLCS implements SimilarityAlg {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zhixiangli.codesimilarity.SimilarityAlg#get(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public double get(String a, String b) {
		a = CodeUtils.removeBlank(CodeUtils.removeComment(a));
		b = CodeUtils.removeBlank(CodeUtils.removeComment(b));
		if (0 == a.length() || 0 == b.length()) {
			return 0;
		}
		return 2.0 * optimizedLCS(a, b) / (a.length() + b.length());
	}

	private int optimizedLCS(String a, String b) {

		int[] stack = new int[Math.min(a.length(), b.length())];
		int top = -1;

		int[] cnt = new int[Byte.MAX_VALUE];
		for (int i = 0; i < b.length(); i++) {
			cnt[b.charAt(i)]++;
		}
		int[][] h = new int[Byte.MAX_VALUE][];
		for (int i = 0; i < Byte.MAX_VALUE; i++) {
			h[i] = new int[cnt[i]];
		}

		int[] cur = new int[Byte.MAX_VALUE];
		for (int i = b.length() - 1; i >= 0; i--) {
			int pos = b.charAt(i);
			h[pos][cur[pos]++] = i;
		}

		for (int i = 0; i < a.length(); i++) {
			int pos = a.charAt(i);
			for (int j = 0; j < cnt[pos]; j++) {
				if (top < 0) {
					stack[++top] = h[pos][j];
				} else {
					if (stack[top] < h[pos][j]) {
						stack[++top] = h[pos][j];
					} else {
						int res = 0;
						int low = 0;
						int high = top + 1;
						while (low < high) {
							int mid = (low + high) >> 1;
							if (stack[mid] >= h[pos][j]) {
								high = res = mid;
							} else {
								low = mid + 1;
							}
						}
						stack[res] = h[pos][j];
					}
				}
			}
		}
		return top + 1;
	}
}
