/**
 * 
 */
package com.zhixiangli.codesimilarity.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.zhixiangli.codesimilarity.SimilarityAlg;

/**
 * calculate cosine similarity of two codes
 * 
 * @author lizhixiang
 *
 */
public class CosineSimilarity implements SimilarityAlg {
    
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
        List<String> x = getFeature(a);
        if (x.size() == 0) {
            return 0;
        }
        
        List<String> y = getFeature(b);
        if (y.size() == 0) {
            return 0;
        }
        
        return getCosine(getOccurrence(x), getOccurrence(y));
    }
    
    /**
     * 
     * get all variable names
     * 
     * @param a
     *            source code
     * @return list of variable names
     */
    private List<String> getFeature(String a) {
        List<String> list = new ArrayList<>();
        Matcher m = FEATURE_PATTERN.matcher(a);
        while (m.find()) {
            list.add(m.group());
        }
        return list;
    }
    
    /**
     * 
     * calculate the number of occurrences of each strings
     * 
     * @param list
     *            strings
     * @return the number of occurrences of each strings
     */
    private Map<String, Integer> getOccurrence(List<String> list) {
        return list.stream().collect(
            Collectors.groupingBy(str -> str, Collectors.summingInt(str -> 1)));
    }
    
    /**
     * 
     * calculate the cosine of two vectors
     * 
     * @param x
     *            vector
     * @param y
     *            another vector
     * @return cosine value
     */
    private double getCosine(Map<String, Integer> x, Map<String, Integer> y) {
        double up = x.keySet().stream().filter(key -> y.get(key) != null)
            .collect(Collectors.summarizingDouble(key -> 1.0 * x.get(key) * y.get(key))).getSum();
        
        double a = x.keySet().stream()
            .collect(Collectors.summarizingDouble(key -> 1.0 * x.get(key) * x.get(key))).getSum();
        
        double b = y.keySet().stream()
            .collect(Collectors.summarizingDouble(key -> 1.0 * y.get(key) * y.get(key))).getSum();
        
        return up / Math.sqrt(a * b);
    }
    
}
