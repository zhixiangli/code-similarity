/**
 * 
 */
package com.zhixiangli.codesimilarity.common;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author lizhixiang
 *
 */
public class CodeUtilsTest {
    
    @Test
    public void testRemoveBlank() {
        String a = "/**\n" + "	 * @throws java.lang.Exception\n" + "	 */\n"
            + "	@BeforeClass\n" + "	public static void setUpBeforeClass() throws Exception {\n"
            + "	}\n" + "//something !@#$%^&*()_+~{}:\"<>?\n" + "	/**\n"
            + "	 * @throws java.lang.Exception\n" + "	 */\n" + "	@AfterClass\n"
            + "	public static void tearDownAfterClass() throws Exception {\n" + "	}\n";
        String b = "/***@throwsjava.lang.Exception*/@BeforeClasspublicstaticvoidsetUpBeforeClass()throwsException{}//something!@#$%^&*()_+~{}:\"<>?/***@throwsjava.lang.Exception*/@AfterClasspublicstaticvoidtearDownAfterClass()throwsException{}";
        assertTrue(b.equals(CodeUtils.removeBlank(a)));
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
        assertTrue(CodeUtils.removeComments(a).equals(b));
    }
}
