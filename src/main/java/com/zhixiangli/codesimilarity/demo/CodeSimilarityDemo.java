/**
 * 
 */
package com.zhixiangli.codesimilarity.demo;

import com.zhixiangli.codesimilarity.CodeSimilarity;
import com.zhixiangli.codesimilarity.strategy.CosineSimilarity;

/**
 * 
 * how to use the api of code similarity
 * 
 * @author lizhixiang
 *
 */
public class CodeSimilarityDemo {

	public static void main(String[] args) {
		String a = "";
		String b = "";

		if (args.length > 1) {
			a = args[1];
		}
		if (args.length > 2) {
			b = args[2];
		}

		System.out.println(CodeSimilarity.get(a, b, new CosineSimilarity()));
	}

}
