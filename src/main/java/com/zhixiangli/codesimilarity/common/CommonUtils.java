/**
 * 
 */
package com.zhixiangli.codesimilarity.common;

import java.util.Collection;

/**
 * @author lizhixiang
 *
 */
public class CommonUtils {

	public static final String LF = "\n";

	public static final String CR = "\r";

	public static final boolean isEmpty(CharSequence charSequence) {
		return null == charSequence || 0 == charSequence.length();
	}

	public static final boolean isEmpty(Collection<?> collection) {
		return null == collection || 0 == collection.size();
	}

}
