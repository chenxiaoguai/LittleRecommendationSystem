package analysising;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import resultanalysis.ConfigurablePara;
import rsutils.Global;
import common.*;

public class AnalysisBuyAction {

	public static void statisticAllUserEarlistClickTimeBeforeBuy(UserList trainingUsers){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(User user: trainingUsers.getUserMap().values())
			if(user.getUserBuysActions() != null)
				statisticEarlistClickTimeBeforeBuy(map,user.getUserBuysActions());
		System.out.println("statisticAllUserEarlistClickTimeBeforeBuy :");
		System.out.println(map.toString());
		
	}
	public static void statisticEarlistClickTimeBeforeBuy(
			HashMap<Integer, Integer> map,ArrayList<BuyAction> buyActions){
	
		for(int i = buyActions.size()-1; i>=0 ;i--){
			int key = buyActions.get(i).getEarlistView();
			if(map.containsKey(key))
				map.put(key, map.get(key)+1);
			else 
				map.put(key, 1);
		}
	}
	
	public static void statisticEveryBrandBuyCount(BrandList trainingBrand){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Brand brand : trainingBrand.getBrandMap().values()) {
			if(brand.getBrandBuyActions() != null){
				int key = brand.getBrandBuyActions().size();
				if(map.containsKey(key))
					map.put(key, map.get(key)+1);
				else
					map.put(key, 1);
			} 
			else {
				if(map.containsKey(0))
					map.put(0, map.get(0)+1);
				else
					map.put(0, 1);
			}
		}
		System.out.println("brand buy count distribution = "+map.entrySet().toString());
		int count =0 ;
		int brandNum = 0;
		for (Integer key : map.keySet()) {
			if(key >= 28){
				count += map.get(key)*key;
				brandNum += map.get(key);
			}
			
		}
		
		System.out.println("buycout = "+count+" "+brandNum);
		
		HashMap<Integer, Integer> reBuyUserMap = new HashMap<Integer, Integer>();

		int reBuyCount = 0;
		for (Brand brand : trainingBrand.getBrandMap().values()) {
			BuyAction.setCompareType(BuyAction.User);
			Collections.sort(brand.getBrandBuyActions());
			BuyAction.setCompareType(BuyAction.defaultComparaType);
			if(brand.getBrandBuyActions().size() >=2) {
				for (int i = 0; i < brand.getBrandBuyActions().size()-1; i++) {
					if(yyyyy(brand, i)){
						brand.addUserReBuyCount(1);	
						reBuyCount ++;
						int key = brand.getBrandBuyActions().get(i).getUserId();
						if(reBuyUserMap.containsKey(key))
							reBuyUserMap.put(key, reBuyUserMap.get(key)+1);
						else
							reBuyUserMap.put(key, 1);
					}
				}
			}
		}
		HashMap<Integer, Integer> reBuyMap = new HashMap<Integer, Integer>();
		for (Brand brand : trainingBrand.getBrandMap().values()) {
				int key = brand.getUserReBuyCount();
				if(reBuyMap.containsKey(key))
					reBuyMap.put(key, reBuyMap.get(key)+1);
				else
					reBuyMap.put(key, 1);
		
		}
		System.out.println("brandNum in trainingData:" + trainingBrand.getBrandMap().size());
		
		System.out.println("brand rebuy times distribution :"+reBuyMap.toString());
		System.out.println("rebuyUserNum = " +reBuyUserMap.size());
		System.out.println("rebuyCount = "+ reBuyCount);
		System.out.println("rebuy map = "+ reBuyUserMap.toString());

		
	}
	public static boolean yyyyy(Brand brand, int i) {
		return (brand.getBrandBuyActions().get(i).getUserId() 
				== brand.getBrandBuyActions().get(i+1).getUserId())
				;
	}

	
	public static void statisticBrandsSalesVolume(BrandList trainingBrand){
		for (Brand brand : trainingBrand.getBrandMap().values()) {
			brand.calculateScoreBaseOnSalesVolume();
		}
	}
	
	public static void statisticUsersBuyCount(UserList trainingUsers){
		for (User user : trainingUsers.getUserMap().values()) {
			int buyActionSize = 0;
			if(user.getUserBuysActions() != null)
				buyActionSize = user.getUserBuysActions().size();
			user.setUserBuyCount(buyActionSize);
			float average = (float) Global.BrandSumIntraining /
					(float) Global.userSumInTraining;
			user.setRecommendRatioBasedOnBuyCountHistory(
					(float)user.getUserBuyCount() / average );
			
		}
	}
	
	public static void statisticBuyActionInTestDataHasActionInTrainingData(
			UserList trainingUsers, UserList testUsers, ConfigurablePara para){
		int validBuyCount = 0;
		for(User userInTestData: testUsers.getUserMap().values()){
			if(userInTestData.getUserRecords()!= null)
				for(Record r: userInTestData.getUserRecords())	{
					if(r.getUserActionType() == Global.BUY &&
							trainingUsers.getUserMap().containsKey(r.getUserId())){
						User userInTrainingData =
								trainingUsers.getUserMap().get(r.getUserId());
						for(Record r2: userInTrainingData.getUserRecords()){
							if(r2.getBrandId() == r.getBrandId()){
								validBuyCount ++;
								break;
							}
						}
					}
				}
		}
		para.setBuyedBrandInTestDataHasActionInTrainingData(validBuyCount);
		
	}
	
	public static void statisticBuyCountOfPreClickedBrand(int startDay, int endDay,UserList trainingUsers){
	int buyCount = 0;
	int test = 0;
	for(User user: trainingUsers.getUserMap().values()){
	if(user.getUserBuysActions() != null)
		for(BuyAction b: user.getUserBuysActions())	{
			if(b.getRecordDate() >= startDay && b.getRecordDate() <= endDay){
				assert b.getEarlistView() < 120;
				assert b.getRecordDate() >= startDay 
						&& b.getRecordDate() <= endDay;
			//	System.out.println(b.getBuyTime());
			//	assert b.getEarlistViewRecordId()
//				if(b.getEarlistView() > b.getBuyTime() - startDay)
//					buyCount++;
				test ++;
				for (Record r : user.getUserRecords()) {
					 if( r.getBrandId() == b.getBrandId() &&
							 r.getUserId() == b.getUserId() &&
							 r.getRecordDay() < startDay)
					 {
						 buyCount++;
						 break;
					 }
				}
			}
		}
	}
	System.out.println(test+"statisticBuyCountOfPreClickedBrand count ="+ buyCount+ " startDay = "+startDay+ " endDay = "+endDay);

	}
	
	public static void statisticUserBuyHistory(){
		
	}
	

}
