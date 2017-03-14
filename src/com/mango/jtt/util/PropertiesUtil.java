package com.mango.jtt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class PropertiesUtil {
	static Properties p;
	static {
		p = new Properties();
		InputStreamReader in = null;
		try {
			in = new InputStreamReader(new FileInputStream(new File(UrlUtil
					.getRootUrl()
					+ "config/mango.properties")), "GBK");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			p.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		return p.getProperty(key);
	}

	// /**
	// * @param args
	// */
	// public static void main(String[] args) {
	// PropertiesUtil.class.getClassLoader().getResource("/");
	// File file = new File("config/mango.properties");
	// System.out.println(file.getAbsolutePath());
	// // System.out.println(getValue("airExcelName"));
	// System.out.println(PropertiesUtil.class.getClassLoader()
	// .getResource(""));
	// }

}
