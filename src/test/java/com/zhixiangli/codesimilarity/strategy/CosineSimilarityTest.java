/**
 * 
 */
package com.zhixiangli.codesimilarity.strategy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zhixiangli.codesimilarity.SimilarityAlg;

/**
 * TODO
 * 
 * @author lizhixiang
 *
 */
public class CosineSimilarityTest {
    
    private SimilarityAlg alg;
    
    @Test
    public void testGet() {
        String a, b;
        
        a = "fdsf";
        b = "";
        assertEquals(0, alg.get(a, b), 1e-8);
        
        a = "";
        b = "fdsfdsfd";
        assertEquals(0, alg.get(a, b), 1e-8);
        
        a = "aaa";
        b = "aab";
        assertEquals(0, alg.get(a, b), 1e-8);
        
        a = "b a b";
        b = "a b a";
        assertEquals(4.0 / 5, alg.get(a, b), 1e-8);
        
        a = "a*=b";
        b = "b*=a";
        assertEquals(1, alg.get(a, b), 1e-8);
    }
    
    /**
     * TODO
     * 
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    /**
     * TODO
     * 
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
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
    
    /**
     * TODO
     * 
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }
    
}
