package com.mango.jtt.util;

import java.net.URL;

/**
 * Aug 19, 2016
 * 
 * @author HHL 获取url工具类
 */
public class UrlUtil {

	/**
	 * @return 获取根目录 其实是classpath
	 */
	public static String getRootUrl() {
		URL rootUrl = UrlUtil.class.getClassLoader().getResource("");
		// 针对打包成jar包后获取rootUrl为null的问题
		if (null == rootUrl) {
			return "";
		}

		String rootUrlS = rootUrl.getPath();
		if (rootUrlS.contains("/bin/")) {
			return rootUrlS.substring(0, rootUrlS.length() - 4);
		}
		return rootUrlS;
	}

	// /**
	// * @param args
	// */
	// public static void main(String[] args) {
	// System.out.println(UrlUtil.class.getClassLoader().getResource("")
	// .getPath());
	// }
}
