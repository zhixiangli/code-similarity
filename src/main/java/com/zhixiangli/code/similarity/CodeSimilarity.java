/**
 * 
 */
package com.zhixiangli.code.similarity;

import org.apache.commons.lang3.StringUtils;

import com.zhixiangli.code.similarity.common.CodeUtils;
import com.zhixiangli.code.similarity.strategy.LongestCommonSubsequence;

/**
 * 
 * api of code similarity
 * 
 * @author lizhixiang
 *
 */
public class CodeSimilarity {

    /**
     * algorithm implement
     */
    private SimilarityAlgorithm similarityAlgorithm;

    public CodeSimilarity() {
        this(new LongestCommonSubsequence());
    }

    /**
     * @param similarityAlgorithm algorithm to be used.
     */
    public CodeSimilarity(SimilarityAlgorithm similarityAlgorithm) {
        this.similarityAlgorithm = similarityAlgorithm;
    }

    /**
     * 
     * get code similarity
     * 
     * @param a source code
     * @param b anathor source code
     * @return similarity, which is in [0, 1]
     */
    public double get(String a, String b) {
        if (StringUtils.isEmpty(a) || StringUtils.isEmpty(b)) {
            return 0;
        }
        String aAfter = CodeUtils.removeComments(a);
        String bAfter = CodeUtils.removeComments(b);
        return similarityAlgorithm.get(aAfter, bAfter);
    }

    /**
     * @param similarityAlgorithm the similarityAlgorithm to set
     */
    public void setSimilarityAlgorithm(SimilarityAlgorithm similarityAlgorithm) {
        this.similarityAlgorithm = similarityAlgorithm;
    }

}
