/**
 * 
 */
package com.zhixiangli.codesimilarity;

import com.zhixiangli.codesimilarity.common.CodeUtils;
import com.zhixiangli.codesimilarity.common.SimilarityConstants;

/**
 * 
 * api of code similarity
 * 
 * @author lizhixiang
 *
 */
public class CodeSimilarity {
    
    /**
     * 
     * get code similarity
     * 
     * @param a
     *            source code
     * @param b
     *            anathor source code
     * @return similarity, which is in [0, 1]
     */
    public static double get(String a, String b) {
        return get(a, b, SimilarityAlgFactory.getInstance(SimilarityConstants.STRATEGY));
    }
    
    /**
     * 
     * get code similarity
     * 
     * @param a
     *            source code
     * @param b
     *            anathor source code
     * @param smililarityAlg
     *            the algorithm to calculate code similarity
     * @return similarity, which is in [0, 1]
     */
    public static double get(String a, String b, SimilarityAlg smililarityAlg) {
        if (null == a || null == b) {
            return 0;
        }
        return smililarityAlg.get(CodeUtils.removeComment(a), CodeUtils.removeComment(b));
    }
    
}