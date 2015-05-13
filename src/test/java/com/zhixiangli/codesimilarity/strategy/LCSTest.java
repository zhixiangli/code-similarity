/**
 * 
 */
package com.zhixiangli.codesimilarity.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.zhixiangli.codesimilarity.SimilarityAlgorithm;

/**
 * @author lizhixiang
 *
 */
public class LCSTest {
    
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
        assertEquals(2.0 * 3 / (a.length() + b.length()), alg.get(a, b), 1e-8);
    }
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        alg = new LCS();
    }
    
}
