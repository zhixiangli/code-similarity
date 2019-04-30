/**
 *
 */
package com.zhixiangli.code.similarity.strategy;

import com.zhixiangli.code.similarity.SimilarityAlgorithm;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
     * @see com.zhixiangli.codesimilarity.SimilarityAlg#get(java.lang.String, java.lang.String)
     */
    @Override
    public double get(final String a, final String b) {
        final List<String> aList = getTerms(a);
        if (CollectionUtils.isEmpty(aList)) {
            return 0;
        }

        final List<String> bList = getTerms(b);
        if (CollectionUtils.isEmpty(bList)) {
            return 0;
        }

        return getCosine(getFrequency(aList), getFrequency(bList));
    }

    /**
     *
     * get all variable names
     *
     * @param a source code
     * @return list of variable names
     */
    private List<String> getTerms(final String a) {
        final List<String> termsList = new ArrayList<>();
        final Matcher m = FEATURE_PATTERN.matcher(a);
        while (m.find()) {
            termsList.add(m.group());
        }
        return termsList;
    }

    /**
     *
     * calculate the number of occurrences of each strings
     *
     * @param termsList strings
     * @return the number of occurrences of each strings
     */
    private Map<String, Integer> getFrequency(final List<String> termsList) {
        return termsList.parallelStream().collect(Collectors.groupingBy(str -> str, Collectors.summingInt(str -> 1)));
    }

    /**
     *
     * calculate the cosine of two vectors
     *
     * @param aFrequency vector
     * @param bFrequency another vector
     * @return cosine value
     */
    private double getCosine(final Map<String, Integer> aFrequency, final Map<String, Integer> bFrequency) {
        final double up = aFrequency.keySet().parallelStream().filter(bFrequency::containsKey)
                .collect(Collectors.summarizingDouble(key -> aFrequency.get(key) * bFrequency.get(key))).getSum();
        final double a = getQuadraticSum(aFrequency.values());
        final double b = getQuadraticSum(bFrequency.values());
        return up / Math.sqrt(a * b);
    }

    private double getQuadraticSum(final Collection<Integer> collection) {
        return collection.stream().reduce(0, (result, x) -> result + (x * x));
    }
}
