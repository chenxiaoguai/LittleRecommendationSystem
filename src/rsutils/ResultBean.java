package rsutils;

public class ResultBean {

	private float R;
	private float P;
	private float F1;
	private int allHitCountFromRecommendBrandToUser;
	private int allCountOfRecommendBrandToUser;
	private int allUserBuyedCount;
	
	
	/**
	 * @return the r
	 */
	public float getR() {
		return R;
	}
	/**
	 * @param r the r to set
	 */
	public void setR(float r) {
		R = r;
	}
	/**
	 * @return the p
	 */
	public float getP() {
		return P;
	}
	/**
	 * @param p the p to set
	 */
	public void setP(float p) {
		P = p;
	}
	/**
	 * @return the f1
	 */
	public float getF1() {
		return F1;
	}
	/**
	 * @param f1 the f1 to set
	 */
	public void setF1(float f1) {
		F1 = f1;
	}
	
	public void calculateF1(){
		setP((float)allHitCountFromRecommendBrandToUser / 
				(float)allCountOfRecommendBrandToUser);
		setR((float)allHitCountFromRecommendBrandToUser /
				(float)allUserBuyedCount);
		setF1(2 * getP() * getR() /(getP() + getR()));
		System.out.println("F1 = "+getF1()+" P = "+ getP()+ " R = "+getR());


	}
	/**
	 * @return the allHitCountFromRecommendBrandToUser
	 */
	public int getAllHitCountFromRecommendBrandToUser() {
		return allHitCountFromRecommendBrandToUser;
	}
	/**
	 * @param increment the allHitCountFromRecommendBrandToUser to set
	 */
	public void addToAllHitCountFromRecommendBrandToUser(
			int increment) {
		this.allHitCountFromRecommendBrandToUser += increment;
	}
	/**
	 * @return the allCountOfRecommendBrandToUser
	 */
	public int getAllCountOfRecommendBrandToUser() {
		return allCountOfRecommendBrandToUser;
	}
	/**
	 * @param allCountOfRecommendBrandToUser the allCountOfRecommendBrandToUser to set
	 */
	public void addToAllCountOfRecommendBrandToUser(int allCountOfRecommendBrandToUser) {
		this.allCountOfRecommendBrandToUser += allCountOfRecommendBrandToUser;
	}
	/**
	 * @return the allUserBuyedCount
	 */
	public int getAllUserBuyedCount() {
		return allUserBuyedCount;
	}
	/**
	 * @param allUserBuyedCount the allUserBuyedCount to set
	 */
	public void addToAllUserBuyedCount(int allUserBuyedCount) {
		this.allUserBuyedCount += allUserBuyedCount;
	}
	

	@Override
	public String toString(){
		String s = "\nresult : \n";
		s += "R = " + R + "\n";
		s += "P = " + P + "\n";
		s += "F1 = " + F1 + "\n";
		s += "allUserBuyedCount = " + allUserBuyedCount + "\n";
		s += "allCountOfRecommendBrandToUser = " + allCountOfRecommendBrandToUser + "\n";
		s += "allHitCountFromRecommendBrandToUser = " + allHitCountFromRecommendBrandToUser + "\n";

		return s;
	}
}
