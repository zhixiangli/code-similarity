/**
 * 
 */
package com.zhixiangli.codesimilarity;

import org.apache.commons.lang3.StringUtils;

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
        return get(a, b, SimilarityAlgorithmFactory.getInstance(SimilarityConstants.STRATEGY));
    }
    
    /**
     * 
     * get code similarity
     * 
     * @param a
     *            source code
     * @param b
     *            anathor source code
     * @param similarityAlgorithm
     *            the algorithm to calculate code similarity
     * @return similarity, which is in [0, 1]
     */
    public static double get(String a, String b, SimilarityAlgorithm similarityAlgorithm) {
        if (StringUtils.isEmpty(a) || StringUtils.isEmpty(b)) {
            return 0;
        }
        String aAfter = CodeUtils.removeComments(a);
        String bAfter = CodeUtils.removeComments(b);
        return similarityAlgorithm.get(aAfter, bAfter);
    }
    
}