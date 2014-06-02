package common;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class ActionChain {

	private int brandId;
	private Brand brand;
	private int userId;
	private Item user;
	private ArrayList<Action> actionList;
	private ArrayList<ViewAction> viewActionList = new ArrayList<ViewAction>();
	private ArrayList<BuyAction> buyActionList;
	private FavoriteAction favoriteAction;
	private AddCartAction addCartAction;
	private HashMap<Integer, Integer> dayViewNumMap = new HashMap<Integer, Integer>() ;
	private int viewDayCount;
	private int earlistViewDay = -1;
	private int earlistActionDay = -1;
	private int latestActionDay;
	private int latestViewDay;
	private int reBuyInSameDayCount;
	private int reBuyInAnotheyCount;

	
	public int getReBuyInSameDayCount() {
		return reBuyInSameDayCount;
	}


	public void setReBuyInSameDayCount(int reBuyInSameDayCount) {
		this.reBuyInSameDayCount = reBuyInSameDayCount;
	}


	public int getReBuyInAnotheyCount() {
		return reBuyInAnotheyCount;
	}


	public void setReBuyInAnotheyCount(int reBuyInAnotheyCount) {
		this.reBuyInAnotheyCount = reBuyInAnotheyCount;
	}


	public ActionChain( Action a) {
		// TODO Auto-generated constructor stub
		setBrandId(a.getBrandId());
		setUserId(a.getUserId());
		setBrand(a.getBrand());
		setUser(a.getUser());
	}
	
	
	public AddCartAction getAddCartAction() {
		return addCartAction;
	}

	public void setAddCartAction(AddCartAction addCartAction) {
		this.addCartAction = addCartAction;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Item getUser() {
		return user;
	}
	public void setUser(Item user) {
		this.user = user;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public HashMap<Integer, Integer> getDayViewNumMap() {
		return dayViewNumMap;
	}
	public void setDayViewNumMap(HashMap<Integer, Integer> dayViewNumMap) {
		this.dayViewNumMap = dayViewNumMap;
	}
	public void addViewActionList(ViewAction value){
		viewActionList.add(value);
	}
	public ArrayList<ViewAction> getViewActionList() {
		return viewActionList;
	}
	public void setViewActionList(ArrayList<ViewAction> viewActionList) {
		this.viewActionList = viewActionList;
	}
	
	public int getEarlistActionDay() {
		return earlistActionDay;
	}
	public void setEarlistActionDay(int earlistActionDay) {
		this.earlistActionDay = earlistActionDay;
	}
	public int getEarlistViewDay() {
		return earlistViewDay;
	}
	public void setEarlistViewDay(int earlistViewDay) {
		this.earlistViewDay = earlistViewDay;
	}
	public int getLatestActionDay() {
		return latestActionDay;
	}
	public void setLatestActionDay(int latestActionDay) {
		this.latestActionDay = latestActionDay;
	}
	public int getLatestViewDay() {
		return latestViewDay;
	}
	public void setLatestViewDay(int latestViewDay) {
		this.latestViewDay = latestViewDay;
	}
	public int getViewDayCount() {
		return dayViewNumMap.size();
	}
	public void setViewDayCount(int viewDayCount) {
		this.viewDayCount = viewDayCount;
	}
	public void addToActionList(Action value){
		if (actionList == null) {
			actionList = new ArrayList<Action>();
		}
		actionList.add(value);
	}
	public ArrayList<Action> getActionList() {
		if (actionList == null) {
			actionList = new ArrayList<Action>();
		}
		return actionList;
	}
	public void setActionList(ArrayList<Action> actionList) {
		this.actionList = actionList;
	}
	public void addToBuyActionList(BuyAction b) throws Exception{
		if (buyActionList == null) {
			buyActionList = new ArrayList<BuyAction>();
		}
		buyActionList.add(b);
		calculateRebuyCount(b);
	}


	public void calculateRebuyCount(BuyAction b) {
		if(getBuyActionList().size() <= 1)
			return;
		BuyAction eb = getBuyActionList().get(getBuyActionList().size() - 2);

		if(eb.getRecordDate() > b.getRecordDate())
			assert 1 == 2;
		else if(eb.getRecordDate() == b.getRecordDate())
			reBuyInSameDayCount ++;
		else if(eb.getRecordDate() < b.getRecordDate())
			reBuyInAnotheyCount ++;
		
		assert reBuyInAnotheyCount+reBuyInSameDayCount == getBuyActionList().size() - 1;
	}
	
	public ArrayList<BuyAction> getBuyActionList() {
		if (buyActionList == null) {
			buyActionList = new ArrayList<BuyAction>();
			
		}
		return buyActionList;
	}
	public BuyAction getLastBuyAction() {
		if (buyActionList == null) {
			return null;
			
		}
		return buyActionList.get(buyActionList.size() -1);
	}
	
	public void setBuyActionList(ArrayList<BuyAction> buyActionList) {
		this.buyActionList = buyActionList;
	}
	public FavoriteAction getFavoriteAction() {
		return favoriteAction;
	}
	public void setFavoriteAction(FavoriteAction favoriteAction) {
		this.favoriteAction = favoriteAction;
	}
	
	
}
