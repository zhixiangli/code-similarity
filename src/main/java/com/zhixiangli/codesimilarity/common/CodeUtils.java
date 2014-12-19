/**
 * 
 */
package com.zhixiangli.codesimilarity.common;

/**
 * utils to process source code
 * 
 * @author lizhixiang
 *
 */
public class CodeUtils {
    
    /**
     * 
     * remove comments
     * 
     * @param before
     *            source code before processing
     * @return source code after processing
     */
    public static String removeComment(String before) {
        StringBuilder after = new StringBuilder();
        
        // remove "//"
        int size = before.length();
        for (int i = 0; i < size; i++) {
            if (i < size - 1 && before.charAt(i) == '/' && before.charAt(i + 1) == '/') {
                for (i++; i < size; i++) {
                    if (before.charAt(i) == '\n') {
                        break;
                    }
                }
            } else {
                after.append(before.charAt(i));
            }
        }
        String tmp = after.toString();
        after.delete(0, after.length());
        
        size = tmp.length();
        int flag = 0;
        for (int i = 0; i < size; i++) {
            if (i < size - 1 && tmp.charAt(i) == '/' && tmp.charAt(i + 1) == '*') {
                ++flag;
            } else if (i > 0 && tmp.charAt(i - 1) == '*' && tmp.charAt(i) == '/') {
                --flag;
            } else if (flag == 0) {
                after.append(tmp.charAt(i));
            }
        }
        
        return after.toString();
    }
    
    /**
     * 
     * remove blank
     * 
     * @param before
     *            source code before processing
     * @return source code after processing
     */
    public static String removeBlank(String before) {
        StringBuilder after = new StringBuilder();
        int size = before.length();
        for (int i = 0; i < size; i++) {
            char ch = before.charAt(i);
            if (' ' < ch && ch < Byte.MAX_VALUE) {
                after.append(ch);
            }
        }
        return after.toString();
    }
}
