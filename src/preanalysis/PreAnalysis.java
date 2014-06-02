package preanalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import rsutils.Global;
import common.*;


public class PreAnalysis {

	
	
	public static void PreAnalysising(UserList trainingUsers, BrandList trainingBrand){
//		PreAnalysisUser(trainingUsers, trainingBrand);
		preAnalysisUserRecord(trainingUsers);
		preAnalysisClickBuyRatio(trainingUsers, trainingBrand);
	}
	public static void PreAnalysisUser(UserList trainingUsers, BrandList trainingBrand){
		for(User user:trainingUsers.getUserMap().values()){
//			System.out.println("userId:"+user.getUserId());
			ExtractUserBuyActions(user, trainingBrand);
//			System.out.println("userId:"+user.getUserId());
		}
	}
	public static void preAnalysisClickBuyRatio(UserList trainingUsers, BrandList trainin) {
		HashMap<Float, Integer> map = new HashMap<Float, Integer>();
		for(User user:trainingUsers.getUserMap().values()){
			if (user.getClickBuyRatio() > 0) {
				map.put(user.getClickBuyRatio(), user.getActionChainMap().size());
				System.out.println(user.getClickBuyRatio() + " "+ user.getActionChainMap().size()+",");
			}
		}
//		System.out.println("clickratio map = "+map.size()+" "+map.toString());
	}
	
	public static void preAnalysisUserRecord(UserList userList){
		for (User user : userList.getUserMap().values()) {
			Collections.sort(user.getUserRecords());
			for(Record r : user.getUserRecords()){
				Brand brand = (Brand) ItemFactory.getItem(
						r.getBrandId(), "TrainingBrand");
				if(r.getUserActionType() == Global.VIEW){
					ViewAction v = (ViewAction) new ViewAction(r);
					user.addActionToChain(v);
					brand.addActionToChain(v);
				}else if(r.getUserActionType() == Global.BUY){
					BuyAction b = (BuyAction) new BuyAction(r);
					user.addToUserBuyActions(b);
					brand.addToBrandBuyActions(b);

				}else if(r.getUserActionType() == Global.ADDCART){
					AddCartAction a = new AddCartAction(r);
					user.addActionToChain(a);
					brand.addActionToChain(a);
				
				}else if(r.getUserActionType() == Global.FAVORITE){
					FavoriteAction f = (FavoriteAction) new FavoriteAction(r);
					user.addActionToChain(f);
					brand.addActionToChain(f);

				}
			}
		}
	}
	
	public static void ExtractUserBuyActions(User user,BrandList trainingBrand){
		Collections.sort(user.getUserRecords());
		ArrayList<Record> recordList = user.getUserRecords();
		ArrayList<Record> buyRecord  = extractAllBuyRecordsFromList(recordList);
		for(Record r: buyRecord){
			BuyAction buyAction = new BuyAction();
			Brand brand = trainingBrand.getBrandMap().get(r.getBrandId());
			brand.addToBrandBuyActions(buyAction);
			user.addToUserBuyActions(buyAction);

			buyAction.setUserId(r.getUserId());
			buyAction.setBrandId(r.getBrandId());
			buyAction.setRecordDate(r.getRecordDay());
			buyAction.setEarlistView(-1);
			buyAction.setLatestView(-1);    // 表示还没有开始查找，若为0，表示最近查看时间即为购买时间。
			int rIndex = r.getListIndex();
			for(int i = rIndex-1; i>= 0; i--){
//				System.out.print(i+" ");
				Record rIter = recordList.get(i);
				assert rIter.getRecordDay() <= r.getRecordDay();
				int temp = buyAction.getRecordDate() - rIter.getRecordDay();
				assert temp >= 0;
				int count =0;
				
				if(rIter.getBrandId() == buyAction.getBrandId() && rIter.getUserId() == buyAction.getUserId()){
					 if(rIter.getUserActionType() == Global.VIEW){
						buyAction.setViewCount(buyAction.getViewCount()+1);
						if(buyAction.getLatestView() == -1){
							buyAction.setLatestView(temp);
							buyAction.setLastestViewRecordId(rIter.getRecordId());
						}

						buyAction.setEarlistView(temp);
						buyAction.setEarlistViewRecordId(rIter.getRecordId());

						count ++;
						
					}
					else if(rIter.getUserActionType() == Global.BUY){
							buyAction.setViewDuration(
									buyAction.getEarlistView() - buyAction.getLatestView());
							break;
					}
					else if(rIter.getUserActionType() == Global.ADDCART){
						buyAction.setAddToCartBeforeBuy(true);
						buyAction.setTimeOfAddToCart(r.getRecordDay());

					}
					else if(rIter.getUserActionType() == Global.FAVORITE){
						buyAction.setFavoriteBeforeBuy(true);
						buyAction.setTimeOfFavorite(r.getRecordDay());
					}
					
				}
					
				else 
					continue;
//				assert count >0;
			}
			assert buyAction.getEarlistView() < 1000000;
			// assert buyAction.getLatestView() >= 0;
		}
		
	}
	
	public static void RearrangeUserBuyActions(User user){
		Collections.sort(user.getUserBuysActions());
		int i = 1;
		for(Action action: user.getUserBuysActions()){
			action.setRecordDate(i++);
		}
	}
	
	public static ArrayList<Record>  extractAllBuyRecordsFromList(ArrayList<Record> recordList){
		
		ArrayList<Record> buyRecord = new ArrayList<Record>();
		for(int i = recordList.size()-1; i>=0 ;i--){
			Record r = recordList.get(i);
			if(r.getUserActionType() == 1){
					buyRecord.add(r);
					r.setListIndex(i);
			}
		}
		return buyRecord;
	}
}
