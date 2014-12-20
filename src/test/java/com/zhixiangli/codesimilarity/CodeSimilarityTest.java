/**
 * 
 */
package com.zhixiangli.codesimilarity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author lizhixiang
 *
 */
public class CodeSimilarityTest {
    
    @Test
    public void testGetLCS() {
        String a, b;
        
        a = "";
        b = null;
        assertEquals(0, CodeSimilarity.get(a, b), 1e-8);
        
        a = "fdsa";
        b = "";
        assertEquals(0, CodeSimilarity.get(a, b), 1e-8);
        
        a = null;
        b = "fdsfdsa";
        assertEquals(0, CodeSimilarity.get(a, b), 1e-8);
        
        a = "aaaaaaaaaaaa";
        b = "aaaaaaaa";
        assertEquals((2.0 * b.length()) / (a.length() + b.length()), CodeSimilarity.get(a, b), 1e-8);
        
        a = "abcdefg";
        b = "gfedcba";
        assertEquals(2.0 / (a.length() + b.length()), CodeSimilarity.get(a, b), 1e-8);
        
        a = "abaababacccccc";
        b = "abaaababaaaccacccc";
        assertEquals((2.0 * a.length()) / (a.length() + b.length()), CodeSimilarity.get(a, b), 1e-8);
        
        a = "A,.x?:{}_@$#";
        b = "%^&(()_&^%$#@";
        assertEquals(2.0 * 3 / (a.length() + b.length()), CodeSimilarity.get(a, b), 1e-8);
        
    }
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }
    
    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }
    
}
