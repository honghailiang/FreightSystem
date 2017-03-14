package com.mango.jtt.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author DELL 字符串工具类
 */
public class StringUtil {
	/**
	 * @param str
	 * @return 字符串是否为空
	 */
	public static boolean isEmpty(String str) {
		return (str == null) || str.trim().equals("")
				|| str.trim().equals("null");
	}

	/**
	 * 检验是否是非零的正整数,不包括+号
	 * 
	 * @return
	 */
	public static boolean isNumeric(String str) {
		String regex = "^[1-9][0-9]*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
}
