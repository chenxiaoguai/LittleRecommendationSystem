package analysising;

import java.util.HashMap;

import common.Action;
import common.Brand;
import common.ItemFactory;
import common.User;
import common.UserList;

public class AnalysisUser {

	public static void statisticUserBuyCount(UserList trainingUsers){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (User user : trainingUsers.getUserMap().values()) {
			int key = user.getUserBuysActions().size();
			
			if(map.containsKey(key))
				map.put(key, map.get(key)+1);
			else
				map.put(key, 1);
			 
		}
		System.out.println("user buyCount map :"+map.toString());
		int count =0 ;
		int userNum = 0;
		for (Integer key : map.keySet()) {
			if(key >= 17){
				count += map.get(key)*key;
				userNum += map.get(key);
			}
			
		}
		
		System.out.println("userbuycout = "+count+" "+userNum);
	}
	
	public static void StatisticUserReBuyAction(UserList trainingUsers){
		for (User user : trainingUsers.getUserMap().values()) {
			for (int i = 0; i < user.getUserBuysActions().size(); i++) {
				Action b = user.getUserBuysActions().get(i);
				for (int j = i+1; j <user.getUserBuysActions().size(); j++) {
					Action b1 = user.getUserBuysActions().get(j);
					if(b.getBrandId() == b1.getBrandId()){
						int brandId = b1.getBrandId();
						user.addReBuyNum(1);
						Brand brand = (Brand) ItemFactory.getItem(brandId, "TrainingBrand");
						brand.addUserReBuyCount(1);
						if(user.getReBuyBrandsMap().containsKey(brandId)){
							int preValue = user.getReBuyBrandsMap().get(brandId);
							 user.getReBuyBrandsMap().put(brandId, preValue+1);
						}else{
							 user.getReBuyBrandsMap().put(brandId, 1);
							 user.addReBuyBrandNum(1);
						}
					}
				}
			}
		}
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for (User user : trainingUsers.getUserMap().values()) {
			int key = user.getReBuyNum();
			
			if(map.containsKey(key))
				map.put(key, map.get(key)+1);
			else
				map.put(key, 1);
			 
		}
		System.out.println("user rebuyCount map :"+map.toString());


	}
}
