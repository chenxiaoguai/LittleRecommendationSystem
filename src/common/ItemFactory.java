package common;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemFactory{

	
	private static UserList allUsers;
	private static UserList trainingUsers;
	private static UserList testUsers;
	
	private static BrandList allBrands;
	private static BrandList trainingBrands;
	private static BrandList testBrands;

	private static RecordList testRecords;
	private static RecordList TrainingRecords;
	private static RecordList allRecords;

	public  static Item getItem(int itemId,String type) {
		if(type.equals("TrainingUser"))
			return trainingUsers.get(itemId);
		else if(type.equals("TrainingBrand")){
			return trainingBrands.get(itemId);

		}else if(type.equals("TestUser")){
			return testUsers.get(itemId);

		}else if(type.equals("TestBrand")){
			return testBrands.get(itemId);

		}else if(type.equals("AllUser")){
			return allUsers.get(itemId);

		}else if(type.equals("AllBrand")){
			return allBrands.get(itemId);
		}else {
			
			 new Exception("factory error").printStackTrace();
				return null;
		}
	}

	/**
	 * @param allUsers the allUsers to set
	 */
	public static void setAllUsers(UserList allUsers) {
		ItemFactory.allUsers = allUsers;
	}

	/**
	 * @param trainingUsers the trainingUsers to set
	 */
	public static void setTrainingUsers(UserList trainingUsers) {
		ItemFactory.trainingUsers = trainingUsers;
	}

	/**
	 * @param testUsers the testUsers to set
	 */
	public static void setTestUsers(UserList testUsers) {
		ItemFactory.testUsers = testUsers;
	}

	/**
	 * @param allBrands the allBrands to set
	 */
	public static void setAllBrands(BrandList allBrands) {
		ItemFactory.allBrands = allBrands;
	}

	/**
	 * @param trainingBrands the trainingBrands to set
	 */
	public static void setTrainingBrands(BrandList trainingBrands) {
		ItemFactory.trainingBrands = trainingBrands;
	}

	/**
	 * @param testBrands the testBrands to set
	 */
	public static void setTestBrands(BrandList testBrands) {
		ItemFactory.testBrands = testBrands;
	}

	/**
	 * @param testUserRecords the testUserRecords to set
	 */
	public static void setTestUserRecords(RecordList testUserRecords) {
		ItemFactory.testRecords = testUserRecords;
	}

	/**
	 * @param trainingRecords the trainingRecords to set
	 */
	public static void setTrainingRecords(RecordList trainingRecords) {
		TrainingRecords = trainingRecords;
	}

	/**
	 * @param allRecords the allRecords to set
	 */
	public static void setAllRecords(RecordList allRecords) {
		ItemFactory.allRecords = allRecords;
	}

	/**
	 * @return the allRecords
	 */
	public static RecordList getAllRecords() {
		return allRecords;
	}

	/**
	 * @return the allUsers
	 */
	public static UserList getAllUsers() {
		return allUsers;
	}

	/**
	 * @return the trainingUsers
	 */
	public static UserList getTrainingUsers() {
		return trainingUsers;
	}

	/**
	 * @return the testUsers
	 */
	public static UserList getTestUsers() {
		return testUsers;
	}

	/**
	 * @return the allBrands
	 */
	public static BrandList getAllBrands() {
		return allBrands;
	}

	/**
	 * @return the trainingBrands
	 */
	public static BrandList getTrainingBrands() {
		return trainingBrands;
	}

	/**
	 * @return the testBrands
	 */
	public static BrandList getTestBrands() {
		return testBrands;
	}

	/**
	 * @return the testUserRecords
	 */
	public static RecordList getTestUserRecords() {
		return testRecords;
	}

	/**
	 * @return the trainingRecords
	 */
	public static RecordList getTrainingRecords() {
		return TrainingRecords;
	}

	
	/**
	 * @param testUserRecord the testUserRecord to set
	 */
	
	
}