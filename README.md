code-similarity
===============


Provides a implementation code similarity detection.


##Environmental Requirements

JDK 1.8+


##Instructions

###Add Dependency
	<dependency>
		<groupId>com.zhixiangli</groupId>
		<artifactId>code-similarity</artifactId>
		<version>0.0.2</version>
	</dependency>

###Example
    String a = "public static void main(String[] args) {System.out.println(1);}";
    String b = "public static void main(String[] args) {System.out.println(2);}";

    // default algorithm is Longest Common Subsequence.
    CodeSimilarity codeSimilarity = new CodeSimilarity();
    System.out.println(codeSimilarity.get(a, b));

    // change similarity algorithm to Cosine Distance.
    CodeSimilarity cosineSimilarity = new CodeSimilarity(new CosineSimilarity());
    System.out.println(cosineSimilarity.get(a, b));