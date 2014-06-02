package rsutils;

public class Global {

	public final static int PurePreClick = 0X11;
	public final static int ParaMeter = 0X12;
	public final static int BrandSum = 9531;
	public final static int userSum = 884;
	public final static int recordSum = 182880;
	public final static int buySum = 6984;
	public final static int FavoriteSum = 1204;
	public final static int addCartSum = 153;
	
	public final static int VIEW     = 0;
	public final static int BUY      = 1;
	public final static int FAVORITE  = 2;
	public final static int ADDCART = 3;
	
	public  static int BrandSumIntraining ;
	public  static int buySumInTraining ;
	public  static int userSumInTraining ;
	
	public static String statisticInfos;
	
	/**
	 * @return the statisticInfos
	 */
	public static String getStatisticInfos() {
		return statisticInfos;
	}
	/**
	 * @param statisticInfos the statisticInfos to set
	 */
	public static void appendStatisticInfos(String statisticInfos) {
		Global.statisticInfos = Global.statisticInfos+statisticInfos;
	}
	/**
	 * @return the userSumInTraining
	 */
	public static int getUserSumInTraining() {
		return userSumInTraining;
	}
	/**
	 * @param userSumInTraining the userSumInTraining to set
	 */
	public static void setUserSumInTraining(int userSumInTraining) {
		Global.userSumInTraining = userSumInTraining;
	}
	/**
	 * @return the brandSumIntraining
	 */
	public static int getBrandSumIntraining() {
		return BrandSumIntraining;
	}
	/**
	 * @param brandSumIntraining the brandSumIntraining to set
	 */
	public static void setBrandSumIntraining(int brandSumIntraining) {
		BrandSumIntraining = brandSumIntraining;
	}
	/**
	 * @return the buySumInTraining
	 */
	public static int getBuySumInTraining() {
		return buySumInTraining;
	}
	/**
	 * @param buySumInTraining the buySumInTraining to set
	 */
	public static void setBuySumInTraining(int buySumInTraining) {
		Global.buySumInTraining = buySumInTraining;
	}

}
