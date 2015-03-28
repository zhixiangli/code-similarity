/**
 * 
 */
package com.zhixiangli.codesimilarity.strategy;

import com.zhixiangli.codesimilarity.SimilarityAlg;
import com.zhixiangli.codesimilarity.common.CodeUtils;

/**
 * calculate longest common subsequence of two codes
 * 
 * @author lizhixiang
 *
 */
public class LCS implements SimilarityAlg {
    
    /*
     * (non-Javadoc)
     * 
     * @see com.zhixiangli.codesimilarity.SimilarityAlg#get(java.lang.String,
     * java.lang.String)
     */
    @Override
    public double get(String a, String b) {
        String s = CodeUtils.removeBlank(a);
        if (0 == s.length()) {
            return 0;
        }
        
        String t = CodeUtils.removeBlank(b);
        if (0 == t.length()) {
            return 0;
        }
        return 2.0 * this.getLCS(s, t) / (s.length() + t.length());
    }
    
    /**
     * 
     * Dynamic programming is used to implement the longest common subsequence
     * 
     * @param a
     *            source code
     * @param b
     *            anather source code
     * @return longest common subsequence
     */
    private int getLCS(String a, String b) {
        int la = a.length();
        int lb = b.length();
        int[][] dp = new int[la + 1][lb + 1];
        for (int i = 1; i <= la; i++) {
            for (int j = 1; j <= lb; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[la][lb];
    }
}
