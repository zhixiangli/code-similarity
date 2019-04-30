/**
 *
 */
package com.zhixiangli.code.similarity.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lizhixiang
 *
 */
public class CodeUtilsTest {

    @Test
    public void testRemoveBlank() {
        final String a = "/**\n" + "	 * @throws java.lang.Exception\n" + "	 */\n" + "	@BeforeClass\n"
                + "	public static void setUpBeforeClass() throws Exception {\n" + "	}\n"
                + "//something !@#$%^&*()_+~{}:\"<>?\n" + "	/**\n" + "	 * @throws java.lang.Exception\n" + "	 */\n"
                + "	@AfterClass\n" + "	public static void tearDownAfterClass() throws Exception {\n" + "	}\n";
        final String b =
                "/***@throwsjava.lang.Exception*/@BeforeClasspublicstaticvoidsetUpBeforeClass()throwsException{}//something!@#$%^&*()_+~{}:\"<>?/***@throwsjava.lang.Exception*/@AfterClasspublicstaticvoidtearDownAfterClass()throwsException{}";
        assertEquals(b, CodeUtils.removeBlank(a));
    }

    @Test
    public void testRemoveComment() {
        final String a = "/**\n" + "	 * @throws java.lang.Exception\n" + "	 */\n" + "	@BeforeClass\n"
                + "	public static void setUpBeforeClass() throws Exception {\n" + "	}\n"
                + "//something !@#$%^&*()_+~{}:\"<>?\n" + "	/**\n" + "	 * @throws java.lang.Exception\n" + "	 */\n"
                + "	@AfterClass\n" + "	public static void tearDownAfterClass() throws Exception {\n" + "	}\n";
        final String b = "\n" + "	@BeforeClass\n" + "	public static void setUpBeforeClass() throws Exception {\n" + "	}\n"
                + "	\n" + "	@AfterClass\n" + "	public static void tearDownAfterClass() throws Exception {\n"
                + "	}\n";
        assertEquals(b, CodeUtils.removeComments(a));
    }
}
