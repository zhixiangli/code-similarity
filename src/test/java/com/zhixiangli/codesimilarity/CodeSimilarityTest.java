/**
 * 
 */
package com.zhixiangli.codesimilarity;

import static org.junit.Assert.*;

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
}
