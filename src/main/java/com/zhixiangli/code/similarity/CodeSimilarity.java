/**
 *
 */
package com.zhixiangli.code.similarity;

import com.zhixiangli.code.similarity.common.CodeUtils;
import com.zhixiangli.code.similarity.strategy.LongestCommonSubsequenceSimilarity;
import org.apache.commons.lang3.StringUtils;

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
        this(new LongestCommonSubsequenceSimilarity());
    }

    /**
     * @param similarityAlgorithm algorithm to be used.
     */
    public CodeSimilarity(final SimilarityAlgorithm similarityAlgorithm) {
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
    public double get(final String a, final String b) {
        if (StringUtils.isEmpty(a) || StringUtils.isEmpty(b)) {
            return 0;
        }
        final String aAfter = CodeUtils.removeComments(a);
        final String bAfter = CodeUtils.removeComments(b);
        return similarityAlgorithm.get(aAfter, bAfter);
    }

    /**
     * @param similarityAlgorithm the similarityAlgorithm to set
     */
    public void setSimilarityAlgorithm(final SimilarityAlgorithm similarityAlgorithm) {
        this.similarityAlgorithm = similarityAlgorithm;
    }

}
