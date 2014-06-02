package common;


public class BuyAction extends Action implements Comparable<BuyAction>{

	
	
	public final static int User = 0x01;
	public final static int buyDate = 0x01;
	public final static int defaultComparaType = buyDate;
	public static  int compareType;

// bug fixed.
	private int earlistView;
	private int latestView;
	private int earlistViewRecordId;
	private int lastestViewRecordId;
	private int viewDuration;
	private int viewCount;
	private int buyActionId;
	private int favoriteId;
	private int userBuyCount;
	private int timeOfAddToCart;
	private int timeOfFavorite;
	private boolean addToCartBeforeBuy;
	private boolean favoriteBeforeBuy;
	
	
	
	public BuyAction(Record r) {
		super(r);

		
		// TODO Auto-generated constructor stub
	}
	public BuyAction() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the compareType
	 */
	public static int getCompareType() {
		return compareType;
	}
	/**
	 * @param compareType the compareType to set
	 */
	public static void setCompareType(int compareType) {
		BuyAction.compareType = compareType;
	}
	/**
	 * @return the buyActionId
	 */
	public int getBuyActionId() {
		return buyActionId;
	}
	/**
	 * @param buyActionId the buyActionId to set
	 */
	public void setBuyActionId(int buyActionId) {
		this.buyActionId = buyActionId;
	}
	
	/**
	 * @return the favoriteId
	 */
	public int getFavoriteId() {
		return favoriteId;
	}
	/**
	 * @param favoriteId the favoriteId to set
	 */
	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}
	/**
	 * @return the earlistView
	 */
	public int getEarlistView() {
		return earlistView;
	}
	/**
	 * @param earlistView the earlistView to set
	 */
	public void setEarlistView(int earlistView) {
		this.earlistView = earlistView;
	}
	/**
	 * @return the latestView
	 */
	public int getLatestView() {
		return latestView;
	}
	/**
	 * @param latestView the latestView to set
	 */
	public void setLatestView(int latestView) {
		this.latestView = latestView;
	}
	
	/**
	 * @return the earlistViewRecordId
	 */
	public int getEarlistViewRecordId() {
		return earlistViewRecordId;
	}
	/**
	 * @param earlistViewRecordId the earlistViewRecordId to set
	 */
	public void setEarlistViewRecordId(int earlistViewRecordId) {
		this.earlistViewRecordId = earlistViewRecordId;
	}
	/**
	 * @return the lastestViewRecordId
	 */
	public int getLastestViewRecordId() {
		return lastestViewRecordId;
	}
	/**
	 * @param lastestViewRecordId the lastestViewRecordId to set
	 */
	public void setLastestViewRecordId(int lastestViewRecordId) {
		this.lastestViewRecordId = lastestViewRecordId;
	}
	/**
	 * @return the viewDuration
	 */
	public int getViewDuration() {
		return viewDuration;
	}
	/**
	 * @param viewDuration the viewDuration to set
	 */
	public void setViewDuration(int viewDuration) {
		this.viewDuration = viewDuration;
	}
	/**
	 * @return the viewCount
	 */
	public int getViewCount() {
		return viewCount;
	}
	/**
	 * @param viewCount the viewCount to set
	 */
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	/**
	 * @return the userBuyCount
	 */
	public int getUserBuyCount() {
		return userBuyCount;
	}
	/**
	 * @param userBuyCount the userBuyCount to set
	 */
	public void setUserBuyCount(int userBuyCount) {
		this.userBuyCount = userBuyCount;
	}
	/**
	 * @return the addToCartBeforeBuy
	 */
	public boolean isAddToCartBeforeBuy() {
		return addToCartBeforeBuy;
	}
	/**
	 * @param addToCartBeforeBuy the addToCartBeforeBuy to set
	 */
	public void setAddToCartBeforeBuy(boolean addToCartBeforeBuy) {
		this.addToCartBeforeBuy = addToCartBeforeBuy;
	}
	
	
	/**
	 * @return the timeOfAddToCart
	 */
	public int getTimeOfAddToCart() {
		return timeOfAddToCart;
	}
	/**
	 * @param timeOfAddToCart the timeOfAddToCart to set
	 */
	public void setTimeOfAddToCart(int timeOfAddToCart) {
		this.timeOfAddToCart = timeOfAddToCart;
	}
	/**
	 * @return the timeOfFavorite
	 */
	public int getTimeOfFavorite() {
		return timeOfFavorite;
	}
	/**
	 * @param timeOfFavorite the timeOfFavorite to set
	 */
	public void setTimeOfFavorite(int timeOfFavorite) {
		this.timeOfFavorite = timeOfFavorite;
	}
	/**
	 * @return the favoriteBeforeBuy
	 */
	public boolean isFavoriteBeforeBuy() {
		return favoriteBeforeBuy;
	}
	/**
	 * @param favoriteBeforeBuy the favoriteBeforeBuy to set
	 */
	public void setFavoriteBeforeBuy(boolean favoriteBeforeBuy) {
		this.favoriteBeforeBuy = favoriteBeforeBuy;
	}
	@Override
	public void addToActionChain(ActionChain chain) {
		// TODO Auto-generated method stub
		try {
			chain.addToBuyActionList(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.addToActionChain(chain);
	}
	
	@Override
	public int compareTo(BuyAction e){
		
		int result = 0;
		if(compareType == BuyAction.buyDate){
			if(this.getRecordDate() < e.getRecordDate())
				result = -1;
			if(this.getRecordDate() == e.getRecordDate())
				result = 0;
			if(this.getRecordDate() > e.getRecordDate())
				result = 1;
		}else if(getCompareType() ==  BuyAction.User){
			if(this.getUserId() < e.getUserId())
				result = -1;
			if(this.getUserId() == e.getUserId())
				result = 0;
			if(this.getUserId() > e.getUserId())
				result = 1;
		}
		return result;
		
	}

}
