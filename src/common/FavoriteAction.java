package common;


public class FavoriteAction extends Action {
	
	private int earlistView;
	private int latestView;
	private int viewDuration;
	private int viewCount;
	private int buyTime;
	private int buyActionId;
	private int FavoriteId;
	private int userBuyCount;
	private int timeOfAddToCart;
	private int timeOfFavorite;
	private boolean addToCartBeforeFavorite;
	private boolean FavoriteBeforeAddToCart;
	private boolean BuyBeforeFavorite;
	private boolean FavoriteBeforeBuy;
	
	
	 
	 
	public FavoriteAction(Record r) {
		// TODO Auto-generated constructor stub
		super(r);

	}
	/**
	 * @return the favoriteId
	 */
	public int getFavoriteId() {
		return FavoriteId;
	}
	/**
	 * @param favoriteId the favoriteId to set
	 */
	public void setFavoriteId(int favoriteId) {
		FavoriteId = favoriteId;
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
	 * @return the buyTime
	 */
	public int getBuyTime() {
		return buyTime;
	}
	/**
	 * @param buyTime the buyTime to set
	 */
	public void setBuyTime(int buyTime) {
		this.buyTime = buyTime;
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
	 * @return the addToCartBeforeFavorite
	 */
	public boolean isAddToCartBeforeFavorite() {
		return addToCartBeforeFavorite;
	}
	/**
	 * @param addToCartBeforeFavorite the addToCartBeforeFavorite to set
	 */
	public void setAddToCartBeforeFavorite(boolean addToCartBeforeFavorite) {
		this.addToCartBeforeFavorite = addToCartBeforeFavorite;
	}
	/**
	 * @return the favoriteBeforeAddToCart
	 */
	public boolean isFavoriteBeforeAddToCart() {
		return FavoriteBeforeAddToCart;
	}
	/**
	 * @param favoriteBeforeAddToCart the favoriteBeforeAddToCart to set
	 */
	public void setFavoriteBeforeAddToCart(boolean favoriteBeforeAddToCart) {
		FavoriteBeforeAddToCart = favoriteBeforeAddToCart;
	}
	/**
	 * @return the buyBeforeFavorite
	 */
	public boolean isBuyBeforeFavorite() {
		return BuyBeforeFavorite;
	}
	/**
	 * @param buyBeforeFavorite the buyBeforeFavorite to set
	 */
	public void setBuyBeforeFavorite(boolean buyBeforeFavorite) {
		BuyBeforeFavorite = buyBeforeFavorite;
	}
	/**
	 * @return the favoriteBeforeBuy
	 */
	public boolean isFavoriteBeforeBuy() {
		return FavoriteBeforeBuy;
	}
	/**
	 * @param favoriteBeforeBuy the favoriteBeforeBuy to set
	 */
	public void setFavoriteBeforeBuy(boolean favoriteBeforeBuy) {
		FavoriteBeforeBuy = favoriteBeforeBuy;
	}
	
	@Override
	public void addToActionChain(ActionChain chain) {

		chain.setFavoriteAction(this);
		super.addToActionChain(chain);
	}
	
}
