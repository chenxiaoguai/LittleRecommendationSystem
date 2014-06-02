package genrecommends;

import java.util.*;

import resultanalysis.ConfigurablePara;
import rsutils.Global;
import common.*;


public class GenerateRecommends {

	public static void generatingRecommends(
			ConfigurablePara para, UserList trainingUsers, BrandList trainingBrand){
//		generatingRecommendsAccordingToAllBuyRecord(para, trainingUsers, trainingBrand);
		generatingRecommendsAccordingToAllClick(para, trainingUsers, trainingBrand);
//		generatingRecommendsAccordingToAllFavorite(para, trainingUsers, trainingBrand);
//		generatingRecommendsAccordingToTopBrandAndTopUser(para, trainingUsers, trainingBrand);
		
	}
	public static void generatingRecommendsAccordingToAllBuyRecord(
			ConfigurablePara para, UserList trainingUsers, BrandList trainingBrand){
		for (User user : trainingUsers.getUserMap().values()) {
			for (Action b : user.getUserBuysActions()) {
				int brandId = b.getBrandId();
				Brand brand = (Brand) ItemFactory.getItem(
						brandId, "TrainingBrand");
				ActionChain c = user.getActionChainMap().get(brandId);
			
								if(
										1!=1
//										condition5(user, brand)
//										condition4(user, brand)
//										||((!condition00(c) && !condition0(c) )
//												&&  c.getViewActionList().size() >= 0
//												&&condition6(user, brand))
										||((!condition00(c) && !condition0(c) )
												&&  c.getViewActionList().size() >= 0
												&&condition7(user, brand))
										||((!condition00(c) && !condition0(c) )
												&&  c.getViewActionList().size() >= 0
												&&condition8(user, brand))
//										||((!condition00(c) && !condition0(c) )
//												&&  c.getViewActionList().size() >= 0
//												&& condition9(user, brand))
										||((!condition00(c) && !condition0(c) )
												&&  c.getViewActionList().size() >= 0
												&&  condition10(para,user, brand))
										||((!condition00(c) && !condition0(c) )
												&&  c.getViewActionList().size() >= 0
												&&  condition12(user, brand))
										 ||condition0(c)
//										|| condition13(user, brand)
										|| condition11(user, brand, c)
										
//										|| condition3(user, brand)
										
//										||condition1(user, brand) ||
//										condition2(user, brand)
						)
					addToRecommendList(para, user, brandId);
				
//				if((user.getReBuyBrandNum() >=5 &&
//						brand.getUserReBuyCount() == 0))
//					addToRecommendList(para, user, brandId);

			}
		}
	}
	public static boolean condition11(User user, Brand brand, ActionChain c) {
		return !condition0(c) && condition00(c)
				
				&& (user.getReBuyInAnotheyCount() >= 1 ||
//						user.getReBuyInSameDayCount() >=2 ||
//						brand.getReBuyInSameDayCount() >=2 &&
						brand.getReBuyInAnotheyCount() >= 1);  //还有可挖掘的潜力 还剩9个
	}
	public static boolean condition6(User user, Brand brand) {
		return user.getReBuyInAnotheyCount() >= 1 &&
//				user.getReBuyInSameDayCount() >= &&
				minBuySize(user,9, brand,8) &&
//				brand.getReBuyInSameDayCount() >=2 &&
				brand.getReBuyInAnotheyCount() < 1;
	}
	public static boolean condition7(User user, Brand brand) {
		return user.getReBuyInAnotheyCount() < 1 &&
//				user.getReBuyInSameDayCount() >=1 ||
				brand.getReBuyInSameDayCount() >=2 &&
				brand.getReBuyInAnotheyCount() >= 2;
	}
	public static boolean condition8(User user, Brand brand) {
		return user.getReBuyInAnotheyCount() >= 1 &&
//				user.getReBuyInSameDayCount() >=1 ||
//				brand.getReBuyInSameDayCount() >=2 &&
				user.getActionChainMap().get(brand.getBrandId()).
				getViewActionList().size() <= 26 &&
				brand.getReBuyInAnotheyCount() >= 1;
	}
	public static boolean condition9(User user, Brand brand) {
		return 
				(user.getReBuyInSameDayCount() >=1 ||
//				minBuySize(user, brand)||
			  // 19个 5个点的准确率 太低了。
				brand.getReBuyInSameDayCount() >=1) &&
				  user.getActionChainMap().get(brand.getBrandId()).
				  getViewActionList().size() >= 1 &&
//				  user.getBrandActionChainMap().get(brand.getBrandId()).
//						getViewActionList().size() <= 6 &&
//				  user.getBrandActionChainMap().get(brand.getBrandId()).
//				getLastBuyAction().getRecordDate() < 80 && 
				  
				  user.getActionChainMap().get(brand.getBrandId()).
				  getLatestViewDay() >= 60 && 
				  
				  
				  user.getActionChainMap().get(brand.getBrandId()).
				  getViewDayCount() >= 0 && 
//				minBuySize(user,2, brand,2)&&

//				minBuySize(user,5, brand,5)&&
				!(user.getReBuyInAnotheyCount() >= 1 ||
				brand.getReBuyInAnotheyCount() >= 1)
				;
//				brand.getReBuyInAnotheyCount() >= 1;
	}
	public static boolean condition10(ConfigurablePara para,User user, Brand brand) {
		return 
				(user.getReBuyInSameDayCount() >=1 ||
//				minBuySize(user, brand)||
				
				brand.getReBuyInSameDayCount() >=1) &&
				user.getActionChainMap().get(brand.getBrandId()).
				getViewActionList().size() >= 2 &&
						user.getActionChainMap().get(brand.getBrandId()).
						getViewActionList().size() <= 5 &&
				user.getActionChainMap().get(brand.getBrandId()).
				getLatestViewDay() < para.getStatisticEndDay() - 60 && 
				
//				user.getBrandActionChainMap().get(brand.getBrandId()).
//				getLatestViewDay() > para.getStatisticEndDay() - 90 && 
				
				
				user.getActionChainMap().get(brand.getBrandId()).
				getViewDayCount() >= 0 && 
				
				minBuySize(user,5, brand,5)&&
				!(user.getReBuyInAnotheyCount() >= 1 ||
				brand.getReBuyInAnotheyCount() >= 1)
				;
//				brand.getReBuyInAnotheyCount() >= 1;
	}
	public static boolean condition12(User user, Brand brand) {
		return 
				(user.getReBuyInSameDayCount() >=1 &&
//				minBuySize(user, brand)||
				
				brand.getReBuyInSameDayCount() >=1) &&
				user.getActionChainMap().get(brand.getBrandId()).
				getViewActionList().size() <=2 &&   //为什么点击次数少，反而容易被重复购买呢。因为点击越多代表越多犹豫。
//				user.getBrandActionChainMap().get(brand.getBrandId()).
//				getLatestViewDay() < 45 && 
				
				user.getActionChainMap().get(brand.getBrandId()).
				getViewDayCount() >= 0 && 
				
//				minBuySize(user,5, brand,5)&&
				!(user.getReBuyInAnotheyCount() >= 1 ||
				brand.getReBuyInAnotheyCount() >= 1)
				;
//				brand.getReBuyInAnotheyCount() >= 1;
	}
	public static boolean condition13(User user, Brand brand) {
		return 
				
//				user.getBrandActionChainMap().get(brand.getBrandId()).
//				getViewActionList().size() <=2 &&   //为什么点击次数少，反而容易被重复购买呢。因为点击越多代表越多犹豫。
////				user.getBrandActionChainMap().get(brand.getBrandId()).
////				getLatestViewDay() < 45 && 
//				
				user.getActionChainMap().get(brand.getBrandId()).
				getViewDayCount() >= 0 && 
				
//				minBuySize(user,5, brand,5)&&
				(user.getReBuyInAnotheyCount() < 1 &&
				brand.getReBuyInAnotheyCount()< 1 &&
				user.getReBuyInSameDayCount() < 1 &&
				brand.getReBuyInSameDayCount()< 1 )
				;
//				brand.getReBuyInAnotheyCount() >= 1;
	}
	
	public static boolean condition5(User user, Brand brand) {
		return user.getReBuyInAnotheyCount() >= 1
		&& brand.getReBuyInSameDayCount() >=1
		&& !condition4(user, brand)
		&& !condition3(user, brand);
	}
	public static boolean condition4(User user, Brand brand) {
		return user.getReBuyInSameDayCount() >=1
		&& !condition3(user, brand)
		&& user.getActionChainMap().get(brand.getBrandId()).getLatestViewDay() > 70
		&& brand.getReBuyInAnotheyCount() <1;
			
	}
	public static boolean condition3(User user, Brand brand) {
		return user.getReBuyInAnotheyCount() >= 1 &&
		brand.getReBuyInAnotheyCount() >= 1;
	}
	public static boolean  condition0(ActionChain c ) {
		return  c.getReBuyInAnotheyCount() >= 1 ;
	}
	public static boolean  condition00(ActionChain c ) {
		return  c.getReBuyInSameDayCount() >= 1 ;
	}
	public static boolean condition2(User user, Brand brand) {
		return user.getReBuyBrandNum() ==0 &&
				brand.getUserReBuyCount() >=4;
	}
	public static boolean condition1(User user, Brand brand) {
		return user.getReBuyBrandNum() >=1 &&
				brand.getUserReBuyCount() >=1;
	}
	public static boolean minBuySize(User user,Integer i, Brand brand,int j) {
		return user.getUserBuysActions().size()>= i
		|| brand.getBrandBuyActions().size() >= j;
	}

	
	public static void generatingRecommendsAccordingToAllClick(
			ConfigurablePara para, UserList trainingUsers, BrandList trainingBrand){
		for (User user : trainingUsers.getUserMap().values()) {
			for(ActionChain c : user.getActionChainMap().values()){
				int brandId = c.getBrandId();
				Brand brand = (Brand) ItemFactory.getItem(
						brandId, "TrainingBrand");
//				addMiddleClickAction(para, user, c, brandId, brand);
				addLast7dayClickAction(para, user, c, brandId, brand);
			}
			
		}
	}
	public static void addMiddleClickAction(ConfigurablePara para, User user,
			ActionChain c, int brandId, Brand brand) {
		if(
//						1 !=1
//						r.getRecordDay() <= para.getStatisticEndDay() - 7
				 c.getLatestViewDay() >= para.getStatisticEndDay() -7
				|| c.getEarlistViewDay() <= para.getStatisticEndDay() - 60
//						|| c.getEarlistViewDay() >= para.getStatisticEndDay() - 30
				//&& c.getLatestViewDay() <= para.getStatisticEndDay() -2
				 
				)
			return;
		if(
				user.getUserBuysActions().size()>= 3
				&& brand.getBrandBuyActions().size() >= 6
				&& (c.getViewActionList().size() >= 4)
//						&& (c.getViewActionList().size() < 5)
				//	||c.getViewDayCount() >= 2)
				&& !user.isUserBoughtBrand(brandId)
				&& !user.isUserAddCartBrand(brandId)
				&& !user.isUserFavoriteBrand(brandId)
				&& c.getViewDayCount() >= 2
//						&& ( !( clickCount <= 1) && c.getViewDayCount() <=2)
				){
		//	if(Math.random() > 0.5)
			
			addToRecommendList(para, user, brandId);
		}
	}
	public static void addLast7dayClickAction(ConfigurablePara para, User user,
			ActionChain c, int brandId, Brand brand) {
		if(
//						1 !=1
//						r.getRecordDay() <= para.getStatisticEndDay() - 7
//				c.getLatestViewDay() <= para.getStatisticEndDay() - 39 ||
				c.getLatestViewDay() >= para.getStatisticEndDay() -50
				
//				|| !(c.getEarlistViewDay() <= para.getStatisticEndDay() - 2)

//				&& c.getEarlistViewDay() <= para.getStatisticEndDay() - 7
//						|| c.getEarlistViewDay() >= para.getStatisticEndDay() - 30
				//&& c.getLatestViewDay() <= para.getStatisticEndDay() -2
				
				)
//			return;
		if(
				1 ==1
				&& user.getUserBuysActions().size() == 0
				&& brand.getBrandBuyActions().size() == 0
				&& (c.getViewActionList().size() >= 2)
				&& (user.getActionChainMap().size() <=20)
//				&& (user.getClickBuyRatio() > 0.03)
//				&&(brand.getActionChainMap().size() > 2)
//				&&(brand.getActionChainMap().size() < 20)
//				&& (user.getClickBuyRatio() > 0.03 && brand.getClickBuyRatio() > 0.04)
//						&& (c.getViewActionList().size() < 5)
				//	||c.getViewDayCount() >= 2)
				&& !user.isUserBoughtBrand(brandId)
				&& !user.isUserAddCartBrand(brandId)
				&& !user.isUserFavoriteBrand(brandId)
			//	&& c.getViewDayCount() >= 0
//						&& ( !( clickCount <= 1) && c.getViewDayCount() <=2)
				){
			//	if(Math.random() > 0.5)
			addToRecommendList(para, user, brandId);
		}
	}
	
	public static void generatingRecommendsAccordingToTopBrandAndTopUser(
			ConfigurablePara para, UserList trainingUsers, BrandList trainingBrand){
		TopUserGroup u = TopUserGroup.getInstance();
		u.setMinBuyCount(22);
		TopBrandGroup b = TopBrandGroup.getInstance();
		b.setMinBrandSaleVolume(18);
		for (User user : trainingUsers.getUserMap().values()) {
			if(u.containsKey(user.getUserId())){
//				if(user.getUserBuyCount() <= 16)
				for (Integer brandId : b.getItemsMap().keySet()) {
				//	if(Math.random() > (float) 0.5)
//					  if(user.getUserBuysActions().c)
						addToRecommendList(para, user, brandId);
				}
			}
		}
	}

	public static void generatingRecommendsAccordingToAllFavorite(
			ConfigurablePara para, UserList trainingUsers, BrandList trainingBrand){
		int testCount = 0;

		for (User user : trainingUsers.getUserMap().values()) {
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			for (Record r : user.getUserRecords()) {
				if(r.getRecordDay() >= para.getPredictStartDay())
					continue;
				if(r.getRecordDay() <= para.getStatisticEndDay() - 8)
					continue;
				int brandId = r.getBrandId();
//				if(r.getUserActionType() == Global.BUY)
//					map.remove(brandId);
				if(r.getUserActionType() == Global.FAVORITE
						|| r.getUserActionType() == Global.ADDCART
						)
				{
					Brand brand = (Brand) ItemFactory.getItem(
							brandId, "TrainingBrand");
//					if( user.getUserBuyCount() >= 0
//							&& brand.getBrandBuyActions().size() >= 1){
						if(!(user.getReBuyBrandNum() <1 &&
						brand.getUserReBuyCount() <1))
						{
						map.put(brandId, brandId);
						testCount++;
					}
				}
				
				}
			for (Integer id : map.values()) {
				addToRecommendList(para, user, id);
			}
		}
		System.out.println("testCOunt "+testCount);
	}
	
	public static void addToRecommendList(ConfigurablePara para, User user,
			int brandId) {
		Brand brand = (Brand) ItemFactory.getItem(
				brandId, "TrainingBrand");
		
		if(!user.getRecommendBrandsMap().containsKey(brandId)
				&&( user.getReBuyNum() >= 0
				&& brand.getUserReBuyCount() >= 0)){
			RecommendBrand rbrand = new RecommendBrand();
			rbrand.setBrandId(brandId);
			user.getRecommendBrandsMap().put(brandId, rbrand);
			user.getRecommendBrandsList().add(rbrand);
			para.addRecommendCount(1);
		}
	}
	
	public static void genALLUserRecommendsAccordingToPreClick(
			ConfigurablePara para, UserList trainingUsers, BrandList trainingBrand) {
		float maxRecommendNum = para.getMaxRecommendNum();
		int recommendCompareType = para.getRecommendCompareType();
		RecommendBrand.setMaxRecommendNum(maxRecommendNum);
		RecommendBrand.setCompareType(recommendCompareType);
		int candicateCount = 0;
		int candicateCountAfterTrim = 0;
		for (User user : trainingUsers.getUserMap().values()) {
			Collections.sort(user.getUserRecords());
			HashMap<Integer, RecommendBrand> candidateBrands = user.getCandicateBrands();
			for (Record record : user.getUserRecords()) {
				int brandId = record.getBrandId();
				assert record.getUserId() == user.getUserId();
//				if(record.getRecordDay() >= para.getStartDay() ||
//						para.getStartDay() - record.getRecordDay() > 150 )
				if(record.getRecordDay() >= para.getPredictStartDay())
					continue;
				if (record.getUserActionType() != Global.BUY) {
					if(candidateBrands.containsKey(brandId))
						candidateBrands.get(brandId).increActionCountAfterLatestBuy(1);
					else {
						RecommendBrand brand = new RecommendBrand();
						brand.increActionCountAfterLatestBuy(1);
						brand.setBrandId(brandId);
						candidateBrands.put(brandId, brand);
					}
				} else if(record.getUserActionType() == Global.BUY){
					if(candidateBrands.containsKey(brandId)){
//						candidateBrands.get(brandId).setActionCountAfterLatestBuy(0);
						int  m = 0;
					//candidateBrands.remove(brandId);
					}
					else{
						RecommendBrand brand = new RecommendBrand();
					brand.increActionCountAfterLatestBuy(1000);
					brand.setBrandId(brandId);
					candidateBrands.put(brandId, brand);
					}
				}
			}
			
//			candicateCount += candidateBrands.size();
//			assert candicateCount < 100000;
//			if( candicateCount >100)
//			System.out.println("candicateCount= "+candicateCount+" "+candidateBrands.size());
//			trimUserRecommendBrand(user, allBrand,para);
//			if( candicateCount >100)
//
//			System.out.println("after trim = "+ user.getRecommendBrandsList().size());
//			candicateCountAfterTrim += user.getRecommendBrandsList().size();
//			if( candicateCount >100)
//
//			System.out.println("after trim = "+ user.getRecommendBrandsList().size() +" "+ candicateCountAfterTrim);
			trimUserRecommendBrand(user, trainingBrand, para);
		}
	}
	
	public static void trimUserRecommendBrand(
			User user, BrandList trainingBrand, ConfigurablePara para) {
		ArrayList<RecommendBrand> brands = user.getRecommendBrandsList();
		Iterator<?> iter = user.getCandicateBrands().values().iterator();
		while(iter.hasNext()){
			RecommendBrand brand = (RecommendBrand) iter.next();
			brands.add(brand);
		}
		Collections.sort(brands);
		//System.out.println(brands.toString());

		Collections.reverse(brands);
	//	System.out.println(brands.toString());
		for (int i = 0; i < brands.size(); i++) {
			if (i+1 <brands.size())
			  assert brands.get(i).compareTo(brands.get(i+1)) 
			  				>= 0;
		}
		int temp =(int)((float)RecommendBrand.getMaxRecommendNum() *
				user.getRecommendRatioBasedOnBuyCountHistory()+0.1);
		int d = 5;
//		if(temp >=d)
//			temp = (temp-d) /2 +d;
//		if(temp > 5)
//			temp -- ;
		if(temp >= 6)
			temp = 5;
		
		int userRecommendNum =(int)((float)RecommendBrand.getMaxRecommendNum() *
				user.getRecommendRatioBasedOnBuyCountHistory() + 0.1);
		
		// userRecommendNum =(int)((float)RecommendBrand.getMaxRecommendNum() );
		//userRecommendNum = (int)(user.getRecommendRatioBasedOnBuyCountHistory() + 0.1);
		//System.out.println(userRecommendNum);
//	userRecommendNum = temp;
		
		Iterator iter1 = brands.iterator();
		while(iter1.hasNext()){
			RecommendBrand rbrand = (RecommendBrand) iter1.next();
			Brand brand = trainingBrand.getBrandMap().get(rbrand.getBrandId());
			if(brand.getBrandBuyActions() == null)
				iter1.remove();
			else if(brand.getBrandBuyActions().size() < para.getMinBuyCountOfBrand())
				iter1.remove();
		}
		
		while (brands.size() > userRecommendNum)
			brands.remove(brands.size() - 1);
		
		user.addRecommendBrandsFromListToMap();
		para.setRecommendCount(para.getRecommendCount()+
				user.getRecommendBrandsList().size());
	}
}
