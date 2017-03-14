package com.mango.jtt.service;

import com.mango.jtt.container.AirContainer;
import com.mango.jtt.model.AirFreight;
import com.mango.jtt.util.FormatUtil;
import com.mango.jtt.util.FreightConst;

/**
 * @author DELL 计算运费服务类
 */
public class AirFreightService {

	public static AirFreight computeFreight(String str, String takeType,
			String quantity) {
		double quan = Double.valueOf(quantity);
		AirFreight af = AirContainer.airFreightMap.get(str);
		af.setQuantity(quan);
		af.setTakeType(takeType);
		af.setFacToAirCost(quan * FreightConst.FACTOAIRF);
		af.setQuantityT(quan * FreightConst.KGF);
		double kg = af.getQuantityT();
		if (kg < 100) {
			af.setAirFreightCost(kg * af.getUnitPriceF());
		} else {
			af.setAirFreightCost(kg * af.getUnitPriceT());
		}

		af.setInsuranceRate(FreightConst.INSURANCERATE);
		af.setInsuranceCost(quan * FreightConst.INSURANCECOSTF);
		af.setInsurance(af.getInsuranceCost() * af.getInsuranceRate());
		af.setPackingCost(quan * FreightConst.PACKINGCOSTF);
		if ("自提".equals(takeType)) {
			af.setTakeCost(af.getUnitPriceZT() * kg);
			af.setSendCost(0);
		} else {
			if (str.contains(FreightConst.DESTINATION)) {
				af.setSendCost(af.getUnitPriceDH() * kg
						+ FreightConst.DESTINATIONF);
			} else {
				af.setSendCost(af.getUnitPriceDH() * kg);
			}
			af.setTakeCost(0);
		}
		af.setAirTotalCost(FormatUtil.formatDouble(af.getFacToAirCost()
				+ af.getAirFreightCost() + af.getInsurance()
				+ af.getPackingCost() + af.getTakeCost() + af.getSendCost()));

		// 公路数据
		af.setTotalMilage(af.getSubsidyMileage() + af.getLandMileage());

		af.setLandTotalCost(FormatUtil.formatDouble(FreightConst.LANDCOSTF
				/ FreightConst.LANDCOSTT * af.getTotalMilage()
				* af.getLandUnitPrice()));
		af.setMarginCost(FormatUtil.formatDouble(af.getAirTotalCost()
				- af.getLandTotalCost()));

		return af;
	}

}
