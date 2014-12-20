/**
 * 
 */
package com.zhixiangli.codesimilarity.demo;

import com.zhixiangli.codesimilarity.CodeSimilarity;
import com.zhixiangli.codesimilarity.strategy.CosineSimilarity;

/**
 * 
 * how to use the api of code similarity
 * 
 * @author lizhixiang
 *
 */
public class CodeSimilarityDemo {
    
    public static void main(String[] args) {
        String a = "int main() {\n" + "    return 0;\n" + "}";
        String b = "void main() {\n" + "}";
        System.out.println(a);
        System.out.println(b);
        System.out.println("LCS Similarity:" + CodeSimilarity.get(a, b));
        System.out.println("Cosine Similarity:" + CodeSimilarity.get(a, b, new CosineSimilarity()));
    }
    
}
