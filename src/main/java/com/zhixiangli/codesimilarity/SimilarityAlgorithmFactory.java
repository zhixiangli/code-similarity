/**
 * 
 */
package com.zhixiangli.codesimilarity;

/**
 * 
 * the factory to get algorithm
 * 
 * @author lizhixiang
 *
 */
public class SimilarityAlgorithmFactory {
    
    /**
     * 
     * get instance of algorithm
     * 
     * @param className
     *            class name
     * @return the algorithm of similarity
     */
    public static SimilarityAlgorithm getInstance(String className) {
        if (null == className) {
            throw new IllegalArgumentException("className is null.");
        }
        try {
            Class<?> smililarityAlg = Class.forName(className);
            if (SimilarityAlgorithm.class.isAssignableFrom(smililarityAlg)) {
                return (SimilarityAlgorithm) smililarityAlg.newInstance();
            } else {
                throw new IllegalArgumentException("className = " + className);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("className = " + className, e);
        }
        
    }
    
}
