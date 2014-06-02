package common;

import java.util.ArrayList;
import java.util.HashMap;


public class User extends Item{

	
	private int userId;
	private int userBuyCount;
	private int recommendBrandNum;
	private int candidateBrandNum;
	private int reBuyNum;
	private int reBuyBrandNum;
	private int reBuyInSameDayCount = -1;
	private int reBuyInAnotheyCount = -1;
	private long purchasePower;
	private float recommendRatioBasedOnBuyCountHistory;
	private HashMap<Integer,RecommendBrand> candicateBrands;
	private HashMap<Integer,RecommendBrand> recommendBrandsMap;
	private ArrayList<RecommendBrand> recommendBrandsList;
	private ArrayList<Record> userRecords;
	private ArrayList<BuyAction> userBuysActions;
	private HashMap<Integer, Integer> reBuyBrandsMap;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getReBuyInSameDayCount() {
		calculateRebuyCount();
		return reBuyInSameDayCount;
	}
	public void setReBuyInSameDayCount(int reBuyInSameDayCount) {
		this.reBuyInSameDayCount = reBuyInSameDayCount;
	}
	public int getReBuyInAnotheyCount() {
		calculateRebuyCount();

		return reBuyInAnotheyCount;
	}
	public void setReBuyInAnotheyCount(int reBuyInAnotheyCount) {
		this.reBuyInAnotheyCount = reBuyInAnotheyCount;
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
	
	
	public boolean isUserFavoriteBrand(int brandId){
		ActionChain c = actionChainMap.get(brandId);
		return c.getFavoriteAction() == null ? false: true;
	}
	
	public boolean isUserAddCartBrand(int brandId){
		ActionChain c = actionChainMap.get(brandId);
		return c.getFavoriteAction() == null ? false: true;
	}
	public void addActionToChain(Action a){
		if(!actionChainMap.containsKey(a.getBrandId())){
			ActionChain c = new ActionChain(a);
			a.addToActionChain(c);
			actionChainMap.put(a.getBrandId(), c);
		}
		else{
			ActionChain c = actionChainMap.get(a.getBrandId());
			a.addToActionChain(c);
		}
			
			
	}
	
	public void setBrandActionChainMap(
			HashMap<Integer, ActionChain> brandActionChainMap) {
		this.actionChainMap = brandActionChainMap;
	}
	/**
	 * @return the reBuyNum
	 */
	public int getReBuyNum() {
		return reBuyNum;
	}
	/**
	 * @param reBuyNum the reBuyNum to set
	 */
	public void addReBuyNum(int reBuyNum) {
		this.reBuyNum += reBuyNum;
	}
	
	public boolean isUserBoughtBrand(int brandId){
		for (BuyAction b : getUserBuysActions()) {
			if(b.getBrandId() == brandId)
				return true;
		}
		return false;
	}
	
	/**
	 * @return the userViewActions
	 */

	/**
	 * @return the reBuyBrandsMap
	 */
	public HashMap<Integer, Integer> getReBuyBrandsMap() {
		if(reBuyBrandsMap == null)
			reBuyBrandsMap = new HashMap<Integer,Integer>();
		return reBuyBrandsMap;
	}
	/**
	 * @param reBuyBrandsMap the reBuyBrandsMap to set
	 */
	public void setReBuyBrandsMap(HashMap<Integer, Integer> reBuyBrandsMap) {
		this.reBuyBrandsMap = reBuyBrandsMap;
	}
	/**
	 * @return the reBuyBrandNum
	 */
	public int getReBuyBrandNum() {
		return reBuyBrandNum;
	}
	/**
	 * @param reBuyBrandNum the reBuyBrandNum to set
	 */
	public void addReBuyBrandNum(int reBuyBrandNum) {
		this.reBuyBrandNum += reBuyBrandNum;
	}
	public long getPurchasePower() {
		return purchasePower;
	}
	public void setPurchasePower(long purchasePower) {
		this.purchasePower = purchasePower;
	}
	/**
	 * @return the recommendRatioBasedOnBuyCountHistory
	 */
	public float getRecommendRatioBasedOnBuyCountHistory() {
		return recommendRatioBasedOnBuyCountHistory;
	}
	/**
	 * @param recommendRatioBasedOnBuyCountHistory the recommendRatioBasedOnBuyCountHistory to set
	 */
	public void setRecommendRatioBasedOnBuyCountHistory(
			float recommendRatioBasedOnBuyCountHistory) {
		this.recommendRatioBasedOnBuyCountHistory = recommendRatioBasedOnBuyCountHistory;
	}
	
	/**
	 * @return the userBuyCount
	 */
	public int getUserBuyCount() {
		return getUserBuysActions().size();
	}
	/**
	 * @param userBuyCount the userBuyCount to set
	 */
	public void setUserBuyCount(int userBuyCount) {
		this.userBuyCount = userBuyCount;
	}
	public void addToUserBuyCount(int add) {
		this.userBuyCount += add;
	}
	/**
	
	/**
	 * @param userRecords the userRecords to set
	 */
	public void setUserRecords(ArrayList<Record> userRecords) {
		this.userRecords = userRecords;
	}
	public ArrayList<Record> getUserRecords() {
		if(this.userRecords == null)
			   this.userRecords = new ArrayList<Record>(); 
		return userRecords;
	}
	public void addUserRecords(Record record) {
		if(this.userRecords == null)
		   this.userRecords = new ArrayList<Record>(); 
		this.userRecords.add(record);
	}
	
	/**
	 * @return the userBuysActions
	 */
	public ArrayList<BuyAction> getUserBuysActions() {
		if(this.userBuysActions == null)
			this.userBuysActions = new ArrayList<BuyAction>();
		return userBuysActions;
	}
	/**
	 * @param userBuysActions the userBuysActions to set
	 */
	public void setUserBuysActions(ArrayList<BuyAction> userBuysActions) {
		this.userBuysActions = userBuysActions;
	}
	
	public void addToUserBuyActions(BuyAction e){
		if(this.userBuysActions == null)
			this.userBuysActions = new ArrayList<BuyAction>();
		userBuysActions.add(e);
		addActionToChain(e);
	}
	
	/**
	 * @return the recommendBrandNum
	 */
	public int getRecommendBrandNum() {
		return recommendBrandNum;
	}
	/**
	 * @param recommendBrandNum the recommendBrandNum to set
	 */
	public void setRecommendBrandNum(int recommendBrandNum) {
		this.recommendBrandNum = recommendBrandNum;
	}
	/**
	 * @return the candidateBrandNum
	 */
	public int getCandidateBrandNum() {
		return candidateBrandNum;
	}
	/**
	 * @param candidateBrandNum the candidateBrandNum to set
	 */
	public void setCandidateBrandNum(int candidateBrandNum) {
		this.candidateBrandNum = candidateBrandNum;
	}
	/**
	 * @return the recommendBrands
	 */
	public ArrayList<RecommendBrand> getRecommendBrandsList() {
		if (recommendBrandsList == null) {
			recommendBrandsList = new ArrayList<RecommendBrand>();
		}
		return recommendBrandsList;
	}
	/**
	 * @param recommendBrands the recommendBrands to set
	 */
	public void setRecommendBrandsList(ArrayList<RecommendBrand> recommendBrands) {
		this.recommendBrandsList = recommendBrands;
	}
	
	public void addToRecommendBrandsList(RecommendBrand brand) {
		if (recommendBrandsList == null) {
			recommendBrandsList = new ArrayList<RecommendBrand>();
		}
		recommendBrandsList.add(brand);
	}
	/**
	 * @return the recommendBrandsMap
	 */
	public HashMap<Integer, RecommendBrand> getRecommendBrandsMap() {
		if (this.recommendBrandsMap == null) {
			this.recommendBrandsMap = new HashMap<Integer, RecommendBrand>();
		}
		return recommendBrandsMap;
	}
	/**
	 * @param recommendBrandsMap the recommendBrandsMap to set
	 */
	public void setRecommendBrandsMap(
			HashMap<Integer, RecommendBrand> recommendBrandsMap) {
		if (recommendBrandsMap != null)
			this.recommendBrandsMap = recommendBrandsMap;
	}
	
	public void addToRecommendBrandsMap( RecommendBrand brand){
		if (this.recommendBrandsMap == null) {
			this.recommendBrandsMap = new HashMap<Integer, RecommendBrand>();
		}
		recommendBrandsMap.put(brand.getBrandId(), brand);
	}
	/**
	 * @return the recommendBrandList
	 */
	public HashMap<Integer, RecommendBrand> getCandicateBrands() {
		if(this.candicateBrands == null)
			this.candicateBrands = new HashMap<Integer, RecommendBrand>();
		return candicateBrands;
	}
	/**
	 * @param recommendBrandList the recommendBrandList to set
	 */
	public void setCandicateBrands(HashMap<Integer, RecommendBrand> recommendBrandList) {
		this.candicateBrands = recommendBrandList;
	}
	
	public void addToCandicateBrands(RecommendBrand rb) {
		int brandId = rb.getBrandId();
		if(this.candicateBrands == null)
			this.candicateBrands = new HashMap<Integer, RecommendBrand>();
		this.candicateBrands.put(brandId, rb);
	}

	public void addRecommendBrandsFromListToMap() {
		setRecommendBrandsMap(new HashMap<Integer, RecommendBrand>());
		if(recommendBrandsList != null)
			for (RecommendBrand r : this.recommendBrandsList) {
				if(!recommendBrandsMap.containsKey(r.getBrandId()))
					addToRecommendBrandsMap(r);
			}
	}
	
	
	/**
	 * @return the reBuyBrandsList
	 */

	/**
	 * @param reBuyNum the reBuyNum to set
	 */
	public void setReBuyNum(int reBuyNum) {
		this.reBuyNum = reBuyNum;
	}
	@Override
	public Item get(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}
}
