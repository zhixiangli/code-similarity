/**
 * 
 */
package com.zhixiangli.codesimilarity;

import com.zhixiangli.codesimilarity.common.SimilarityConstants;

/**
 * @author lizhixiang
 *
 */
public class CodeSimilarity {

	public static double get(String a, String b) {
		return get(a, b,
				SimilarityAlgFactory.getInstance(SimilarityConstants.STRATEGY));
	}

	public static double get(String a, String b, SimilarityAlg smililarityAlg) {
		if (null == a || null == b) {
			return 0;
		}
		return smililarityAlg.get(a, b);
	}

}