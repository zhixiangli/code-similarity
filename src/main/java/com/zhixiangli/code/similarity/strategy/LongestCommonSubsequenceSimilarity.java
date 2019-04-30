/**
 *
 */
package com.zhixiangli.code.similarity.strategy;

import com.zhixiangli.code.similarity.SimilarityAlgorithm;
import com.zhixiangli.code.similarity.common.CodeUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * calculate longest common subsequence of two codes
 *
 * @author lizhixiang
 *
 */
public class LongestCommonSubsequenceSimilarity implements SimilarityAlgorithm {

    /*
     * (non-Javadoc)
     *
     * @see com.zhixiangli.codesimilarity.SimilarityAlg#get(java.lang.String, java.lang.String)
     */
    @Override
    public double get(final String a, final String b) {
        final String aAfter = CodeUtils.removeBlank(a);
        if (StringUtils.isEmpty(aAfter)) {
            return 0;
        }

        final String bAfter = CodeUtils.removeBlank(b);
        if (StringUtils.isEmpty(bAfter)) {
            return 0;
        }

        return (2.0 * getLCS(aAfter, bAfter)) / (aAfter.length() + bAfter.length());
    }

    /**
     *
     * Dynamic programming is used to implement the longest common subsequence
     *
     * @param a source code
     * @param b anather source code
     * @return longest common subsequence
     */
    private int getLCS(final String a, final String b) {
        final int aLength = a.length();
        final int bLength = b.length();
        final int[][] dp = new int[aLength + 1][bLength + 1];
        for (int i = 1; i <= aLength; i++) {
            for (int j = 1; j <= bLength; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[aLength][bLength];
    }
}
