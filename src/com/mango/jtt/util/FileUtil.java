package com.mango.jtt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mango.jtt.container.AirContainer;
import com.mango.jtt.model.AirFreight;

/**
 * Aug 17, 2016
 * 
 * @author HHL 文件工具类
 * 
 */
public class FileUtil {

	/**
	 * 从excel中读取数据，转化成对象，并保存到map中
	 */
	public static void initData() {
		readAirExcel(FreightConst.AIREXCELNAME);

	}

	/**
	 * 读取空运数据
	 */
	private static void readAirExcel(String fileName) {
		boolean isE2007 = false; // 判断是否是excel2007格式
		if (fileName.endsWith("xlsx")) {
			isE2007 = true;
		}

		Workbook wb = null;
		try {
			InputStream input = new FileInputStream(new File(UrlUtil
					.getRootUrl()
					+ "data/" + fileName)); // 建立输入流
			// 根据文件格式(2003或者2007)来初始化
			if (isE2007) {
				wb = new XSSFWorkbook(input);
			} else {
				wb = new HSSFWorkbook(input);
			}
			Sheet sheet = wb.getSheet(FreightConst.AIRSHEETNAME); // 获得指定名称的表单
			// testSheet(sheet);
			// 从第三行开始取值（从0开始）
			for (int j = FreightConst.ROWNUMBER; j < sheet
					.getPhysicalNumberOfRows(); j++) {
				Row row = sheet.getRow(j);
				AirFreight af = new AirFreight();
				af.setId((int) row.getCell(FreightConst.ID)
						.getNumericCellValue());
				af.setOriginStation(row.getCell(FreightConst.ORIGINSTATION)
						.getStringCellValue());
				af.setDestinationStation(row.getCell(
						FreightConst.DESTINATIONSTATION).getStringCellValue());
				af.setProvince(row.getCell(FreightConst.PROVINCE)
						.getStringCellValue());
				af.setUnitPriceF(row.getCell(FreightConst.UNITPRICEF)
						.getNumericCellValue());
				af.setUnitPriceT(row.getCell(FreightConst.UNITPRICET)
						.getNumericCellValue());
				af.setUnitPriceDH(row.getCell(FreightConst.UNITPRICEDH)
						.getNumericCellValue());
				af.setUnitPriceZT(row.getCell(FreightConst.UNITPRICEZT)
						.getNumericCellValue());
				af.setSubsidyMileage(row.getCell(FreightConst.SUBSIDYMILEAGE)
						.getNumericCellValue());
				af.setLandMileage(row.getCell(FreightConst.LANDMILEAGE)
						.getNumericCellValue());
				af.setLandUnitPrice(row.getCell(FreightConst.LANDUNITPRICE)
						.getNumericCellValue());

				// 将相关信息存入container中， 运费信息
				AirContainer.airFreightMap.put(af.getOriginStation() + "-"
						+ af.getDestinationStation() + "-" + af.getProvince(),
						af);
				// 目的地
				// AirContainer.airCityList.add(af.getDestinationStation());
				// 目的地省份
				// AirContainer.airProvinceList.add(af.getProvince());
				// 目的地和省份
				AirContainer.cityProvinceList.add(af.getDestinationStation()
						+ "-" + af.getProvince());
			}
			// 将目的地和对应的省份对应起来
			// AirContainer.citySelector();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (wb != null) {
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// private static void testSheet(Sheet sheet) {
	// Iterator<Row> rows = sheet.rowIterator(); // 获得第一个表单的迭代器
	// while (rows.hasNext()) {
	// Row row = rows.next(); // 获得行数据
	// System.out.println("Row #" + row.getRowNum()); // 获得行号从0开始
	// Iterator<Cell> cells = row.cellIterator(); // 获得第一行的迭代器
	// while (cells.hasNext()) {
	// Cell cell = cells.next();
	// System.out.println("Cell #" + cell.getColumnIndex());
	// switch (cell.getCellType()) { // 根据cell中的类型来输出数据
	// case HSSFCell.CELL_TYPE_NUMERIC:
	// System.out.println(cell.getNumericCellValue());
	// break;
	// case HSSFCell.CELL_TYPE_STRING:
	// System.out.println(cell.getStringCellValue());
	// break;
	// case HSSFCell.CELL_TYPE_BOOLEAN:
	// System.out.println(cell.getBooleanCellValue());
	// break;
	// case HSSFCell.CELL_TYPE_FORMULA:
	// System.out.println(cell.getCellFormula());
	// break;
	// default:
	// System.out.println("unsuported sell type");
	// break;
	// }
	// }
	// }
	// }

	// /**
	// * @param args
	// */
	// public static void main(String[] args) {
	// readAirExcel(AIREXCELNAME);
	// }

}
