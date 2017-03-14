package com.mango.jtt.container;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.mango.jtt.model.AirFreight;

/**
 * @author DELL 空运容器类
 */
public class AirContainer {
	/**
	 * 存空运运费对象的map， key为“originStation-destinationStation-province”
	 * value为AireFreight
	 */
	public static Map<String, AirFreight> airFreightMap = new HashMap<String, AirFreight>();

	/**
	 * 空运目的地省份list 对应 province
	 */
	public static List<String> airProvinceList = new LinkedList<String>();
	/**
	 * 空运目的地城市list 对应destinationStation
	 */
	public static List<String> airCityList = new LinkedList<String>();
	/**
	 * 存入按省份排序后的目的地
	 */
	public static Map<String, List<String>> airCitySelectorMap = new HashMap<String, List<String>>();

	/**
	 * 目的地和省份表格
	 */
	public static List<String> cityProvinceList = new LinkedList<String>();;

	/**
	 * 将目的地和省份对应起来，存入map中
	 */
	public static void citySelector() {
		if (airProvinceList.size() > 0 && airCityList.size() > 0) {
			for (int i = 0; i < airProvinceList.size(); i++) {
				String key = airProvinceList.get(i);
				String city = airCityList.get(i);
				if (airCitySelectorMap.containsKey(key)) {
					List<String> cityList = airCitySelectorMap.get(key);
					cityList.add(city);
					airCitySelectorMap.put(key, cityList);
				} else {
					List<String> cityList = new LinkedList<String>();
					cityList.add(city);
					airCitySelectorMap.put(key, cityList);
				}
			}
		}

	}
}
