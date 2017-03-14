package com.mango.jtt.model;

/**
 * Aug 17, 2016
 * 
 * @author HHL 空运类
 * 
 */
public class AirFreight {
	/**
	 * 序号
	 */
	private int id;
	/**
	 * 始发站
	 */
	private String originStation;
	/**
	 * 目的站--城市
	 */
	private String destinationStation;
	/**
	 * 目的站所属省份
	 */
	private String province;
	/**
	 * 运费单价 100kg以下（元/kg）
	 */
	private double unitPriceF;
	/**
	 * 运费单价 100kg以上（元/kg）
	 */
	private double unitPriceT;
	/**
	 * 到货单价（元/kg）
	 */
	private double unitPriceDH;
	/**
	 * 自提单价（元/kg）
	 */
	private double unitPriceZT;
	/**
	 * 卷烟数量（万支）
	 */
	private double quantity;
	/**
	 * 数量转化为公斤数 因子36 quantityT = quantity * 36
	 */
	private double quantityT;
	/**
	 * 烟厂到机场费用 因子40 facToAirCost = quantity * 40
	 */
	private double facToAirCost;
	/**
	 * 运费 if(quantityT<100) airFreightCost=quantityT*unitPriceF
	 * if(quantityT>100) airFreightCost=quantityT*unitPriceT
	 */
	private double airFreightCost;
	/**
	 * 保险费率，固定值0.3%
	 */
	private double insuranceRate;
	/**
	 * 投保金额，因子40000 insuranceCost = quantity * 40000
	 */
	private double insuranceCost;
	/**
	 * 保险费 insurance=insuranceRate*insuranceCost
	 */
	private double insurance;
	/**
	 * 包装费 因子100 packingCost=quantity*100
	 */
	private double packingCost;
	/**
	 * 配送方式：派送，自提
	 */
	private String takeType;
	/**
	 * 派送费 sendCost=quantityT*unitPriceDH
	 */
	private double sendCost;
	/**
	 * 自提费 takeCost=quantityT*unitPriceZT
	 */
	private double takeCost;
	/**
	 * 空运运费合计 airTotalCost=facToAirCost+airFreightCost+insurance+packingCost+(
	 * sendCost或者takeCost)
	 */
	private double airTotalCost;
	/**
	 * 补贴里程
	 */
	private double subsidyMileage;
	/**
	 * 公路里程
	 */
	private double landMileage;
	/**
	 * 结算里程 totalMilage=subsidyMileage+landMileage
	 */
	private double totalMilage;
	/**
	 * 单价（元/吨公里）
	 */
	private double landUnitPrice;
	/**
	 * 公路运费(按最小批次700万支) 700/50*landUnitPrice*totalMilage
	 */
	private double landTotalCost;
	/**
	 * 差异额 marginCost=airTotalCost-landTotalCost
	 */
	private double marginCost;

	public AirFreight() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOriginStation() {
		return originStation;
	}

	public void setOriginStation(String originStation) {
		this.originStation = originStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public double getUnitPriceF() {
		return unitPriceF;
	}

	public void setUnitPriceF(double unitPriceF) {
		this.unitPriceF = unitPriceF;
	}

	public double getUnitPriceT() {
		return unitPriceT;
	}

	public void setUnitPriceT(double unitPriceT) {
		this.unitPriceT = unitPriceT;
	}

	public double getUnitPriceDH() {
		return unitPriceDH;
	}

	public void setUnitPriceDH(double unitPriceDH) {
		this.unitPriceDH = unitPriceDH;
	}

	public double getUnitPriceZT() {
		return unitPriceZT;
	}

	public void setUnitPriceZT(double unitPriceZT) {
		this.unitPriceZT = unitPriceZT;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getQuantityT() {
		return quantityT;
	}

	public void setQuantityT(double quantityT) {
		this.quantityT = quantityT;
	}

	public double getFacToAirCost() {
		return facToAirCost;
	}

	public void setFacToAirCost(double facToAirCost) {
		this.facToAirCost = facToAirCost;
	}

	public double getAirFreightCost() {
		return airFreightCost;
	}

	public void setAirFreightCost(double airFreightCost) {
		this.airFreightCost = airFreightCost;
	}

	public double getInsuranceRate() {
		return insuranceRate;
	}

	public void setInsuranceRate(double insuranceRate) {
		this.insuranceRate = insuranceRate;
	}

	public double getInsuranceCost() {
		return insuranceCost;
	}

	public void setInsuranceCost(double insuranceCost) {
		this.insuranceCost = insuranceCost;
	}

	public double getInsurance() {
		return insurance;
	}

	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}

	public double getPackingCost() {
		return packingCost;
	}

	public void setPackingCost(double packingCost) {
		this.packingCost = packingCost;
	}

	public double getSendCost() {
		return sendCost;
	}

	public void setSendCost(double sendCost) {
		this.sendCost = sendCost;
	}

	public double getTakeCost() {
		return takeCost;
	}

	public void setTakeCost(double takeCost) {
		this.takeCost = takeCost;
	}

	public double getAirTotalCost() {
		return airTotalCost;
	}

	public void setAirTotalCost(double airTotalCost) {
		this.airTotalCost = airTotalCost;
	}

	public String getTakeType() {
		return takeType;
	}

	public void setTakeType(String takeType) {
		this.takeType = takeType;
	}

	public double getSubsidyMileage() {
		return subsidyMileage;
	}

	public void setSubsidyMileage(double subsidyMileage) {
		this.subsidyMileage = subsidyMileage;
	}

	public double getLandMileage() {
		return landMileage;
	}

	public void setLandMileage(double landMileage) {
		this.landMileage = landMileage;
	}

	public double getTotalMilage() {
		return totalMilage;
	}

	public void setTotalMilage(double totalMilage) {
		this.totalMilage = totalMilage;
	}

	public double getLandUnitPrice() {
		return landUnitPrice;
	}

	public void setLandUnitPrice(double landUnitPrice) {
		this.landUnitPrice = landUnitPrice;
	}

	public double getLandTotalCost() {
		return landTotalCost;
	}

	public void setLandTotalCost(double landTotalCost) {
		this.landTotalCost = landTotalCost;
	}

	public double getMarginCost() {
		return marginCost;
	}

	public void setMarginCost(double marginCost) {
		this.marginCost = marginCost;
	}

}
