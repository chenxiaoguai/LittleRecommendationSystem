package resultanalysis;

public class ConfigurablePara {

	private int minRecommendNum;
	private int recommendCompareType;
	private int buyCountInTrainingData;
	private int favoriteCountInTrainingData;
	private int addCartCountInTrainingData;
	private int buyCountInTestData;
	private int favoriteCountInTestData;
	private int addCartCountInTestData;
	private int predictStartDay;
	private int predictEndDay;
	private int statisticStartDay;
	private int statisticEndDay;
	private int minBuyCountOfBrand;
	private int recommendCount;
	private int buyedBrandInTestDataHasActionInTrainingData;
	
	private float lowerPPercentage;
	private float maxRecommendNum;
	private boolean addResultAndParaToResultFile;

	
	/**
	 * @return the buyedBrandInTestDataHasActionInTrainingData
	 */
	public int getBuyedBrandInTestDataHasActionInTrainingData() {
		return buyedBrandInTestDataHasActionInTrainingData;
	}
	/**
	 * @param buyedBrandInTestDataHasActionInTrainingData the buyedBrandInTestDataHasActionInTrainingData to set
	 */
	public void setBuyedBrandInTestDataHasActionInTrainingData(
			int buyedBrandInTestDataHasActionInTrainingData) {
		this.buyedBrandInTestDataHasActionInTrainingData = buyedBrandInTestDataHasActionInTrainingData;
	}
	/**
	 * @return the recommendCount
	 */
	public int getRecommendCount() {
		return recommendCount;
	}
	/**
	 * @param recommendCount the recommendCount to set
	 */
	public void setRecommendCount(int recommendCount) {
		this.recommendCount = recommendCount;
	}
	public void addRecommendCount(int recommendCount) {
		this.recommendCount += recommendCount;
	}
	/**
	 * @return the buyCountInTestData
	 */
	public int getBuyCountInTestData() {
		return buyCountInTestData;
	}
	/**
	 * @param buyCountInTestData the buyCountInTestData to set
	 */
	public void setBuyCountInTestData(int buyCountInTestData) {
		this.buyCountInTestData = buyCountInTestData;
	}
	/**
	 * @return the favoriteCountInTestData
	 */
	public int getFavoriteCountInTestData() {
		return favoriteCountInTestData;
	}
	/**
	 * @param favoriteCountInTestData the favoriteCountInTestData to set
	 */
	public void setFavoriteCountInTestData(int favoriteCountInTestData) {
		this.favoriteCountInTestData = favoriteCountInTestData;
	}
	/**
	 * @return the addCartCountInTestData
	 */
	public int getAddCartCountInTestData() {
		return addCartCountInTestData;
	}
	/**
	 * @param addCartCountInTestData the addCartCountInTestData to set
	 */
	public void setAddCartCountInTestData(int addCartCountInTestData) {
		this.addCartCountInTestData = addCartCountInTestData;
	}
	/**
	 * @return the buyCountInTrainingData
	 */
	public int getBuyCountInTrainingData() {
		return buyCountInTrainingData;
	}
	/**
	 * @param buyCountInTrainingData the buyCountInTrainingData to set
	 */
	public void setBuyCountInTrainingData(int buyCountInTrainingData) {
		this.buyCountInTrainingData = buyCountInTrainingData;
	}
	/**
	 * @return the favoriteCountInTrainingData
	 */
	public int getFavoriteCountInTrainingData() {
		return favoriteCountInTrainingData;
	}
	/**
	 * @param favoriteCountInTrainingData the favoriteCountInTrainingData to set
	 */
	public void setFavoriteCountInTrainingData(int favoriteCountInTrainingData) {
		this.favoriteCountInTrainingData = favoriteCountInTrainingData;
	}
	/**
	 * @return the addCartCountInTrainingData
	 */
	public int getAddCartCountInTrainingData() {
		return addCartCountInTrainingData;
	}
	/**
	 * @param addCartCountInTrainingData the addCartCountInTrainingData to set
	 */
	public void setAddCartCountInTrainingData(int addCartCountInTrainingData) {
		this.addCartCountInTrainingData = addCartCountInTrainingData;
	}
	/**
	 * @return the addResultAndParaToResultFile
	 */
	public boolean isAddResultAndParaToResultFile() {
		return addResultAndParaToResultFile;
	}
	/**
	 * @param addResultAndParaToResultFile the addResultAndParaToResultFile to set
	 */
	public void setAddResultAndParaToResultFile(boolean addResultAndParaToResultFile) {
		this.addResultAndParaToResultFile = addResultAndParaToResultFile;
	}
	/**
	 * @return the statisticStartDay
	 */
	public int getStatisticStartDay() {
		return statisticStartDay;
	}
	/**
	 * @param statisticStartDay the statisticStartDay to set
	 */
	public void setStatisticStartDay(int statisticStartDay) {
		this.statisticStartDay = statisticStartDay;
	}
	/**
	 * @return the statisticEndDay
	 */
	public int getStatisticEndDay() {
		return statisticEndDay;
	}
	/**
	 * @param statisticEndDay the statisticEndDay to set
	 */
	public void setStatisticEndDay(int statisticEndDay) {
		this.statisticEndDay = statisticEndDay;
	}
	/**
	 * @return the lowerPPercentage
	 */
	public float getLowerPPercentage() {
		return lowerPPercentage;
	}
	/**
	 * @param lowerPPercentage the lowerPPercentage to set
	 */
	public void setLowerPPercentage(float lowerPPercentage) {
		this.lowerPPercentage = lowerPPercentage;
	}
	/**
	 * @return the minBuyCountOfBrand
	 */
	public synchronized final int getMinBuyCountOfBrand() {
		return minBuyCountOfBrand;
	}
	/**
	 * @param minBuyCountOfBrand the minBuyCountOfBrand to set
	 */
	public synchronized final void setMinBuyCountOfBrand(int minBuyCountOfBrand) {
		this.minBuyCountOfBrand = minBuyCountOfBrand;
	}
	/**
	 * @return the maxRecommendNum
	 */
	public float getMaxRecommendNum() {
		return maxRecommendNum;
	}
	/**
	 * @param maxRecommendNum the maxRecommendNum to set
	 */
	public void setMaxRecommendNum(float maxRecommendNum) {
		this.maxRecommendNum = maxRecommendNum;
	}
	/**
	 * @return the minRecommendNum
	 */
	public int getMinRecommendNum() {
		return minRecommendNum;
	}
	
	/**
	 * @param minRecommendNum the minRecommendNum to set
	 */
	public void setMinRecommendNum(int minRecommendNum) {
		this.minRecommendNum = minRecommendNum;
	}
	/**
	 * @return the recommendCompareType
	 */
	public int getRecommendCompareType() {
		return recommendCompareType;
	}
	/**
	 * @param recommendCompareType the recommendCompareType to set
	 */
	public void setRecommendCompareType(int recommendCompareType) {
		this.recommendCompareType = recommendCompareType;
	}
	/**
	 * @return the startDay
	 */
	public int getPredictStartDay() {
		return predictStartDay;
	}
	/**
	 * @param startDay the startDay to set
	 */
	public void setPredictStartDay(int startDay) {
		this.predictStartDay = startDay;
	}
	/**
	 * @return the endDay
	 */
	public int getPredictEndDay() {
		return predictEndDay;
	}
	/**
	 * @param endDay the endDay to set
	 */
	public void setPredictEndDay(int endDay) {
		this.predictEndDay = endDay;
	}
	
	@Override
	public String toString(){
		String s = "\nPara : \n";
		s += "buyCountInTrainingData = " + buyCountInTrainingData + "\n";
		s += "favoriteCountInTrainingData = " + favoriteCountInTrainingData + "\n";
		s += "addCartCountInTrainingData = " + addCartCountInTrainingData + "\n";

		s += "buyCountInTestData = " +buyCountInTestData+ "\n";
		s += "favoriteCountInTestData = " + favoriteCountInTestData + "\n";
		s += "addCartCountInTestData = " + addCartCountInTestData + "\n";
		
		s += "\nbuyCountInAllData = " + ( buyCountInTestData +buyCountInTrainingData)  + "\n";
		s += "favoriteCountInAllData = " + (favoriteCountInTrainingData+favoriteCountInTestData) + "\n";
		s += "addCartCountInAllData = " + (addCartCountInTrainingData+addCartCountInTestData) + "\n\n";
			
		s += "buyedBrandInTestDataHasActionInTrainingData = "+buyedBrandInTestDataHasActionInTrainingData + "\n";
	
		s += "recommendCompareType = "+recommendCompareType + "\n";
		s += "statisticStartDay = " + statisticStartDay + "\n";
		s += "statisticEndDay = " + statisticEndDay + "\n";
		s += "predictStartDay = "+predictStartDay + "\n";
		s += "predictEndDay = " + predictEndDay + "\n";
		s += "minBuyCountOfBrand = " + minBuyCountOfBrand + "\n";
		s += "lowerPPercentage = " + lowerPPercentage + "\n";
		s += "minRecommendNum = " + minRecommendNum + "\n";
		s += "recommendCount = " + recommendCount + "\n";
		
		return s;
		
	}
}
