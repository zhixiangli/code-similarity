/**
 * 
 */
package com.zhixiangli.codesimilarity.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.zhixiangli.codesimilarity.SimilarityAlgorithm;

/**
 * TODO
 * 
 * @author lizhixiang
 *
 */
public class CosineSimilarityTest {
    
    private SimilarityAlgorithm alg;
    
    @Test
    public void testGet() {
        String a, b;
        
        a = "b a b";
        b = "a b a";
        assertEquals(4.0 / 5, alg.get(a, b), 1e-8);
        
        a = "fdsf";
        b = "";
        assertEquals(0, alg.get(a, b), 1e-8);
        
        a = "";
        b = "fdsfdsfd";
        assertEquals(0, alg.get(a, b), 1e-8);
        
        a = "aaa";
        b = "aab";
        assertEquals(0, alg.get(a, b), 1e-8);
        
        a = "a*=b";
        b = "b*=a";
        assertEquals(1, alg.get(a, b), 1e-8);
    }
    
    /**
     * TODO
     * 
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        alg = new CosineSimilarity();
    }
    
}
