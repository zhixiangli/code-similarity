/**
 * 
 */
package com.zhixiangli.codesimilarity.common;

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
public class CodeUtilsTest {
    
    @Test
    public void testRemoveBlank() {
        String a = "/**\n" + "	 * @throws java.lang.Exception\n" + "	 */\n" + "	@BeforeClass\n"
            + "	public static void setUpBeforeClass() throws Exception {\n" + "	}\n"
            + "//something !@#$%^&*()_+~{}:\"<>?\n" + "	/**\n"
            + "	 * @throws java.lang.Exception\n" + "	 */\n" + "	@AfterClass\n"
            + "	public static void tearDownAfterClass() throws Exception {\n" + "	}\n";
        String b = "/***@throwsjava.lang.Exception*/@BeforeClasspublicstaticvoidsetUpBeforeClass()throwsException{}//something!@#$%^&*()_+~{}:\"<>?/***@throwsjava.lang.Exception*/@AfterClasspublicstaticvoidtearDownAfterClass()throwsException{}";
        assertTrue(CodeUtils.removeBlank(a).equals(b));
    }
    
    @Test
    public void testRemoveComment() {
        String a = "/**\n" + "	 * @throws java.lang.Exception\n" + "	 */\n" + "	@BeforeClass\n"
            + "	public static void setUpBeforeClass() throws Exception {\n" + "	}\n"
            + "//something !@#$%^&*()_+~{}:\"<>?\n" + "	/**\n"
            + "	 * @throws java.lang.Exception\n" + "	 */\n" + "	@AfterClass\n"
            + "	public static void tearDownAfterClass() throws Exception {\n" + "	}\n";
        String b = "\n" + "	@BeforeClass\n"
            + "	public static void setUpBeforeClass() throws Exception {\n" + "	}\n" + "	\n"
            + "	@AfterClass\n" + "	public static void tearDownAfterClass() throws Exception {\n"
            + "	}\n";
        assertTrue(CodeUtils.removeComment(a).equals(b));
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
