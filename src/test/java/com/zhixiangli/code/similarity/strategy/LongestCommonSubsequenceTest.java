/**
 *
 */
package com.zhixiangli.code.similarity.strategy;

import com.zhixiangli.code.similarity.SimilarityAlgorithm;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lizhixiang
 *
 */
public class LongestCommonSubsequenceTest {

    private SimilarityAlgorithm alg;

    @Test
    public void testGet() {
        String a, b;

        a = "";
        b = "";
        assertEquals(0, alg.get(a, b), 1e-8);

        a = "fdsa";
        b = "";
        assertEquals(0, alg.get(a, b), 1e-8);

        a = "";
        b = "fdsfdsa";
        assertEquals(0, alg.get(a, b), 1e-8);

        a = "aaaaaaaaaaaa";
        b = "aaaaaaaa";
        assertEquals((2.0 * b.length()) / (a.length() + b.length()), alg.get(a, b), 1e-8);

        a = "abcdefg";
        b = "gfedcba";
        assertEquals(2.0 / (a.length() + b.length()), alg.get(a, b), 1e-8);

        a = "abaababacccccc";
        b = "abaaababaaaccacccc";
        assertEquals((2.0 * a.length()) / (a.length() + b.length()), alg.get(a, b), 1e-8);

        a = "A,.x?:{}_@$#";
        b = "%^&(()_&^%$#@";
        assertEquals((2.0 * 3) / (a.length() + b.length()), alg.get(a, b), 1e-8);
    }

    @Before
    public void setUp() {
        alg = new LongestCommonSubsequenceSimilarity();
    }

}
