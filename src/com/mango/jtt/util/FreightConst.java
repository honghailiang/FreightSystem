package com.mango.jtt.util;

/**
 * @author DELL 运费常量因子
 */
/**
 * @author HHL
 * @data 2016年8月21日
 * 
 */
public class FreightConst {
	/**
	 * 空运表格名称
	 */
	public static String AIREXCELNAME = PropertiesUtil.getValue("airExcelName");

	/**
	 * 空运数据sheet名称
	 */
	public static String AIRSHEETNAME = PropertiesUtil.getValue("airSheetName");
	/**
	 * 烟厂到机场费用因子
	 */
	public static double FACTOAIRF = Double.valueOf(PropertiesUtil
			.getValue("facToAirF"));
	/**
	 * 卷烟数量转化为公斤数因子
	 */
	public static double KGF = Double.valueOf(PropertiesUtil.getValue("kgF"));
	/**
	 * 保险费率
	 */
	public static double INSURANCERATE = Double.valueOf(PropertiesUtil
			.getValue("insuranceRateF").replace('%', ' ')) / 100.00;
	/**
	 * 投保金额因子
	 */
	public static double INSURANCECOSTF = Double.valueOf(PropertiesUtil
			.getValue("insuranceCostF"));
	/**
	 * 包装费因子
	 */
	public static double PACKINGCOSTF = Double.valueOf(PropertiesUtil
			.getValue("packingCostF"));
	/**
	 * 到货费特殊的目的地
	 */
	public static String DESTINATION = PropertiesUtil.getValue("destination");
	/**
	 * 到货费特殊的目的地因子
	 */
	public static double DESTINATIONF = Double.valueOf(PropertiesUtil
			.getValue("destinationF"));
	/**
	 * 公路运费(按最小批次700万支)因子
	 */
	public static double LANDCOSTF = Double.valueOf(PropertiesUtil
			.getValue("landCostF"));
	/**
	 * 公路运费(按最小批次700万支)因子
	 */
	public static double LANDCOSTT = Double.valueOf(PropertiesUtil
			.getValue("landCostT"));

	// EXCEL 列号 从0开始 0代表第A列，0代表第1行
	/**
	 * 
	 */
	public static int ROWNUMBER = Integer.valueOf(PropertiesUtil
			.getValue("rowNumber"));
	public static int ID = Integer.valueOf(PropertiesUtil.getValue("id"));
	public static int ORIGINSTATION = Integer.valueOf(PropertiesUtil
			.getValue("originStation"));
	public static int DESTINATIONSTATION = Integer.valueOf(PropertiesUtil
			.getValue("destinationStation"));
	public static int PROVINCE = Integer.valueOf(PropertiesUtil
			.getValue("province"));
	public static int UNITPRICEF = Integer.valueOf(PropertiesUtil
			.getValue("unitPriceF"));
	public static int UNITPRICET = Integer.valueOf(PropertiesUtil
			.getValue("unitPriceT"));
	public static int UNITPRICEDH = Integer.valueOf(PropertiesUtil
			.getValue("unitPriceDH"));
	public static int UNITPRICEZT = Integer.valueOf(PropertiesUtil
			.getValue("unitPriceZT"));
	public static int SUBSIDYMILEAGE = Integer.valueOf(PropertiesUtil
			.getValue("subsidyMileage"));
	public static int LANDMILEAGE = Integer.valueOf(PropertiesUtil
			.getValue("landMileage"));
	public static int LANDUNITPRICE = Integer.valueOf(PropertiesUtil
			.getValue("landUnitPrice"));

	/**
	 * @param args
	 */
	// public static void main(String[] args) {
	//
	// System.out.println(FACTOAIRF);
	// System.out.println(KGF);
	// System.out.println(INSURANCERATE);
	// System.out.println(INSURANCECOSTF);
	// System.out.println(PACKINGCOSTF);
	// }
}
