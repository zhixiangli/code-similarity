/**
 * 
 */
package com.zhixiangli.codesimilarity;

/**
 * 
 * the algorithm to calculate code similarity
 * 
 * @author lizhixiang
 *
 */
public interface SimilarityAlgorithm {

    /**
     * 
     * get code similarity
     * 
     * @param a source code
     * @param b anathor source code
     * @return similarity, which is in [0, 1]
     */
    double get(String a, String b);

}
