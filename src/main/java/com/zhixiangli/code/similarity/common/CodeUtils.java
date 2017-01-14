/**
 * 
 */
package com.zhixiangli.code.similarity.common;

import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

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
     * @param before source code before processing
     * @return source code after processing
     */
    public static String removeComments(String before) {
        return CodeUtils.removeSingleLineComments(CodeUtils.removeBlockComments(before));
    }

    public static String removeBlockComments(String before) {
        StringBuilder after = new StringBuilder();
        int size = before.length();
        int flag = 0;
        for (int i = 0; i < size; ++i) {
            if (i < size - 1 && before.charAt(i) == '/' && before.charAt(i + 1) == '*') {
                ++flag;
            } else if (i > 0 && before.charAt(i - 1) == '*' && before.charAt(i) == '/') {
                --flag;
            } else if (flag == 0) {
                after.append(before.charAt(i));
            }
        }
        return after.toString();
    }

    public static String removeSingleLineComments(String before) {
        StringBuilder after = new StringBuilder();
        int size = before.length();
        for (int i = 0; i < size; ++i) {
            if (i < size - 1 && before.charAt(i) == '/' && before.charAt(i + 1) == '/') {
                for (++i; i < size; ++i) {
                    String charString = String.valueOf(before.charAt(i));
                    if (StringUtils.LF.equals(charString) || StringUtils.CR.equals(charString)) {
                        break;
                    }
                }
            } else {
                after.append(before.charAt(i));
            }
        }
        return after.toString();
    }

    /**
     * 
     * remove blank
     * 
     * @param before source code before processing
     * @return source code after processing
     */
    public static String removeBlank(String before) {
        if (StringUtils.isEmpty(before)) {
            return before;
        }
        return before.codePoints().filter(x -> !Character.isWhitespace(x)).mapToObj(x -> String.valueOf((char) x))
                .collect(Collectors.joining());
    }
}
