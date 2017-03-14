package com.mango.jtt.util;

import java.text.DecimalFormat;

/**
 * @author HHL
 * @data 2016年8月21日 数据格式化工具类
 * 
 */
public class FormatUtil {

	/**
	 * 格式化保留两位
	 */
	public static DecimalFormat df = new DecimalFormat("#.##");

	/**
	 * @param dou
	 * @return 四舍五入保留两位小数
	 */
	public static double formatDouble(double dou) {
		df.setGroupingUsed(false);
		return Double.valueOf(df.format(dou));
	}

	/**
	 * @param dou
	 * @return 四舍五入保留两位小数
	 */
	public static String formatDoubleT(double dou) {
		df.setGroupingUsed(false);
		return df.format(dou);
	}

}
