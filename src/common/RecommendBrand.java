package common;

import rsutils.Global;


public class RecommendBrand implements Comparable<RecommendBrand>{

	private static int compareType;
	private static float maxRecommendNum;

	private int BrandId;
	private int preClickFactor;
	private int ActionCountAfterLastestBuy;
	private float recommendFactor;
	private float brandBuySumFactor;   // the buy sum is big, and this factor is big.

	/**
	 * @return the brandId
	 */
	public int getBrandId() {
		return BrandId;
	}
	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(int brandId) {
		BrandId = brandId;
	}
	/**
	 * @return the preClickFactor
	 */
	public int getPreClickFactor() {
		return preClickFactor;
	}
	/**
	 * @param preClickFactor the preClickFactor to set
	 */
	public void setPreClickFactor(int preClickFactor) {
		this.preClickFactor = preClickFactor;
	}
	
	/**
	 * @return the compareType
	 */
	public static synchronized int getCompareType() {
		return compareType;
	}
	/**
	 * @param compareType the compareType to set
	 */
	public static synchronized void setCompareType(int compareType) {
		RecommendBrand.compareType = compareType;
	}
	
	/**
	 * @return the maxRecommendNum
	 */
	public static synchronized float getMaxRecommendNum() {
		return maxRecommendNum;
	}
	/**
	 * @param maxRecommendNum the maxRecommendNum to set
	 */
	public static synchronized void setMaxRecommendNum(float maxRecommendNum) {
		RecommendBrand.maxRecommendNum = maxRecommendNum;
	}
	/**
	 * @return the actionCountAfterLastestBuy
	 */
	public int getActionCountAfterLastestBuy() {
		return ActionCountAfterLastestBuy;
	}
	/**
	 * @param actionCountAfterLastestBuy the actionCountAfterLastestBuy to set
	 */
	public void setActionCountAfterLatestBuy(int actionCountAfterLastestBuy) {
		ActionCountAfterLastestBuy = actionCountAfterLastestBuy;
	}
	public void  increActionCountAfterLatestBuy(int increment) {
		this.ActionCountAfterLastestBuy += increment;
	}
	
	
	/**
	 * @return the recommendFactor
	 */
	public float getRecommendFactor() {
		 Brand brand = (Brand) ItemFactory.getItem(BrandId, "TrainingBrand");
		 this.recommendFactor = brand.getScoreBaseOnSalesVolume() *
				  (float)this.ActionCountAfterLastestBuy;
		// System.out.println(this.recommendFactor+" "+ this.ActionCountAfterLastestBuy);

		return recommendFactor;
	}
	/**
	 * @param recommendFactor the recommendFactor to set
	 */
	public void setRecommendFactor(float recommendFactor) {
		this.recommendFactor = recommendFactor;
	}
	
//	public void updateRecommendFactor(){
//		 Brand brand = (Brand) ItemFactory.get(this.BrandId,"Brand");
//		 this.recommendFactor = brand.getScoreBaseOnSalesVolume() *
//				 (float)this.ActionCountAfterLastestBuy;
//	}
	/**
	 * @return the brandBuySumFactor
	 */
	public float getBrandBuySumFactor() {
		return brandBuySumFactor;
	}
	/**
	 * @param brandBuySumFactor the brandBuySumFactor to set
	 */
	public void setBrandBuySumFactor(float brandBuySumFactor) {
		this.brandBuySumFactor = brandBuySumFactor;
	}
	@Override
	public int compareTo(RecommendBrand o) {
		// TODO Auto-generated method stub
		int result = 0;
		switch (this.compareType) {
			case Global.PurePreClick: {
				if(this.getRecommendFactor()  < o.getRecommendFactor() )
					result = -1;
				else if(getRecommendFactor()  == o.getRecommendFactor() ){
					result = 0;
				}else if(getRecommendFactor()  > o.getRecommendFactor() )
					result = 1;
			}
				break;
			default:
				break;
			}
		return result;
	}
	
	public String toString(){
		return " "+this.ActionCountAfterLastestBuy;
	}
}
