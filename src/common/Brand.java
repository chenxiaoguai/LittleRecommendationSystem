package common;

import java.util.ArrayList;
import java.util.HashMap;

import rsutils.Global;



public class Brand extends Item {

	private int brandId;
	
	private int[] salesVolumePerMonth;  // 每月销量
	private int allUserClickCount;
	private int allClickedUserCount;
	private int userReBuyCount;
	private float singleUserSaleCountPerMonth ;    //平均每个用户每个月的购买频率（30天1月）
	private float clickCountBeforeBuy ;  //用户购买之前的平均点击数
	private float scoreBaseOnSalesVolume;
	private ArrayList<Record> brandRecords;
	private ArrayList<BuyAction> brandBuyActions;
	private int reBuyInAnotheyCount = -1;
	
	private int reBuyInSameDayCount = -1;
	
	
	public int getReBuyInAnotheyCount() {
		calculateRebuyCount();
		return reBuyInAnotheyCount;
	}

	public void setReBuyInAnotheyCount(int reBuyInAnotheyCount) {
		this.reBuyInAnotheyCount = reBuyInAnotheyCount;
	}

	public int getReBuyInSameDayCount() {
		calculateRebuyCount();
		return reBuyInSameDayCount;
	}

	public void setReBuyInSameDayCount(int reBuyInSameDayCount) {
		this.reBuyInSameDayCount = reBuyInSameDayCount;
	}

	public void calculateRebuyCount() {
		if(reBuyInAnotheyCount == -1 || reBuyInSameDayCount == -1) {
			reBuyInAnotheyCount = 0;
			reBuyInSameDayCount = 0;
		
			for (ActionChain c : getActionChainMap().values()) {
				reBuyInAnotheyCount += c.getReBuyInAnotheyCount();
				reBuyInSameDayCount += c.getReBuyInSameDayCount();
			}
		}
	}
	

	public void setUserActionChainMap(
			HashMap<Integer, ActionChain> userActionChainMap) {
		this.actionChainMap = userActionChainMap;
	}


	public void addActionToChain(Action a){
		if(!actionChainMap.containsKey(a.getUserId())){
			ActionChain c = new ActionChain(a);
			a.addToActionChain(c);
			actionChainMap.put(a.getUserId(), c);
		}
		else{
			ActionChain c = actionChainMap.get(a.getUserId());
			a.addToActionChain(c);
		}
			
			
	}

	
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	
	
	/**
	 * @return the userReBuyCount
	 */
	public int getUserReBuyCount() {
		return userReBuyCount;
	}
	/**
	 * @param userReBuyCount the userReBuyCount to set
	 */
	public void addUserReBuyCount(int userReBuyCount) {
		this.userReBuyCount += userReBuyCount;
	}
	public float getSingleUserSaleCountPerMonth() {
		return singleUserSaleCountPerMonth;
	}
	/**
	 * @return the scoreBaseOnSalesVolume
	 */
	public float getScoreBaseOnSalesVolume() {
		calculateScoreBaseOnSalesVolume();
		//System.out.println("test"+scoreBaseOnSalesVolume);
		return scoreBaseOnSalesVolume;
	}
	public void calculateScoreBaseOnSalesVolume(){
		if(this.getBrandBuyActions() ==  null)
			setScoreBaseOnSalesVolume((float)0.1);
		else{
			int buyCount = getBrandBuyActions().size();
			assert buyCount >= 0;
			assert ((float)Global.buySumInTraining /(float) Global.BrandSumIntraining) > 0;
			float score = (float) ((float)0.01 +
					(Math.sqrt(buyCount / ((float)Global.buySumInTraining /(float) Global.BrandSumIntraining))));
			setScoreBaseOnSalesVolume(score);
			
		}
		
	}
	/**
	 * @param scoreBaseOnSalesVolume the scoreBaseOnSalesVolume to set
	 */
	public void setScoreBaseOnSalesVolume(float scoreBaseOnSalesVolume) {
		this.scoreBaseOnSalesVolume = scoreBaseOnSalesVolume;
	}
	public void setSingleUserSaleCountPerMonth(float singleUserSaleCountPerMonth) {
		this.singleUserSaleCountPerMonth = singleUserSaleCountPerMonth;
	}
	public float getClickCountBeforeBuy() {
		return clickCountBeforeBuy;
	}
	public void setClickCountBeforeBuy(float clickCountBeforeBuy) {
		this.clickCountBeforeBuy = clickCountBeforeBuy;
	}
	public int getAllUserClickCount() {
		return allUserClickCount;
	}
	public void setAllUserClickCount(int allUserClickCount) {
		this.allUserClickCount = allUserClickCount;
	}
	public int getAllClickedUserCount() {
		return allClickedUserCount;
	}
	public void setAllClickedUserCount(int allClickedUserCount) {
		this.allClickedUserCount = allClickedUserCount;
	}
	public int[] getSalesVolumePerMonth() {
		return salesVolumePerMonth;
	}
	public void setSalesVolumePerMonth(int[] salesVolumePerMonth) {
		this.salesVolumePerMonth = salesVolumePerMonth;
	}
	public int getSalesVolume() {
		return getBrandBuyActions().size();
	}
	public ArrayList<Record> getBrandRecords() {
		return brandRecords;
	}
	public void addBrandRecords(Record record) {
		if(this.brandRecords == null)
			   this.brandRecords = new ArrayList<Record>(); 
			this.brandRecords.add(record);
	}
	/**
	 * @return the brandBuyActions
	 */
	public ArrayList<BuyAction> getBrandBuyActions() {
		if(this.brandBuyActions == null)
			this.brandBuyActions = new ArrayList<BuyAction>();
		return brandBuyActions;
	}
	/**
	 * @param brandBuyActions the brandBuyActions to set
	 */
	public void setBrandBuyActions(ArrayList<BuyAction> brandBuyActions) {
		this.brandBuyActions = brandBuyActions;
	}

	public void addToBrandBuyActions(BuyAction e){
		if(this.brandBuyActions == null)
			this.brandBuyActions = new ArrayList<BuyAction>();
		brandBuyActions.add(e);
		addActionToChain(e);

	}
	@Override
	public Item get(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
