/**
 * 
 */
package com.zhixiangli.codesimilarity.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import com.zhixiangli.codesimilarity.SimilarityAlgorithm;

/**
 * calculate cosine similarity of two codes
 * 
 * @author lizhixiang
 *
 */
public class CosineSimilarity implements SimilarityAlgorithm {
    
    /**
     * to match variable
     */
    private static final Pattern FEATURE_PATTERN = Pattern.compile("[a-zA-Z0-9$_]+");
    
    /*
     * (non-Javadoc)
     * 
     * @see com.zhixiangli.codesimilarity.SimilarityAlg#get(java.lang.String,
     * java.lang.String)
     */
    @Override
    public double get(String a, String b) {
        List<String> aList = getTerms(a);
        if (CollectionUtils.isEmpty(aList)) {
            return 0;
        }
        
        List<String> bList = getTerms(b);
        if (CollectionUtils.isEmpty(bList)) {
            return 0;
        }
        
        return this.getCosine(this.getFrequency(aList), this.getFrequency(bList));
    }
    
    /**
     * 
     * get all variable names
     * 
     * @param a
     *            source code
     * @return list of variable names
     */
    private List<String> getTerms(String a) {
        List<String> termsList = new ArrayList<>();
        Matcher m = FEATURE_PATTERN.matcher(a);
        while (m.find()) {
            termsList.add(m.group());
        }
        return termsList;
    }
    
    /**
     * 
     * calculate the number of occurrences of each strings
     * 
     * @param termsList
     *            strings
     * @return the number of occurrences of each strings
     */
    private Map<String, Integer> getFrequency(List<String> termsList) {
        return termsList.parallelStream().collect(
            Collectors.groupingBy(str -> str, Collectors.summingInt(str -> 1)));
    }
    
    /**
     * 
     * calculate the cosine of two vectors
     * 
     * @param aFrequency
     *            vector
     * @param bFrequency
     *            another vector
     * @return cosine value
     */
    private double getCosine(Map<String, Integer> aFrequency, Map<String, Integer> bFrequency) {
        double up = aFrequency
            .keySet()
            .parallelStream()
            .filter(key -> null != bFrequency.get(key))
            .collect(Collectors.summarizingDouble(key -> aFrequency.get(key) * bFrequency.get(key)))
            .getSum();
        double a = this.getQuadraticSum(aFrequency.values());
        double b = this.getQuadraticSum(bFrequency.values());
        return up / Math.sqrt(a * b);
    }
    
    private double getQuadraticSum(Collection<Integer> collection) {
        return collection.parallelStream().collect(Collectors.summarizingDouble(x -> x * x))
            .getSum();
    }
}
