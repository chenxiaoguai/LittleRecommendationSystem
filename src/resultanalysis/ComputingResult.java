package resultanalysis;

import java.io.*;

import javax.naming.spi.DirStateFactory.Result;

import rsutils.Global;
import rsutils.ResultBean;
import common.*;

public class ComputingResult {

	public static ResultBean computeF1(UserList trainingUsers,
			UserList testUsers, ConfigurablePara para) {
		
		ResultBean result = new ResultBean();
		computeAllUserPrecisionValue(trainingUsers,testUsers, para,result);
		comupteAllUserRecallValue(trainingUsers,testUsers, para,result);
		result.calculateF1();
		return result;
	}
	public static void comupteAllUserRecallValue(UserList trainingUsers,
			UserList testUsers,	ConfigurablePara para, ResultBean result) {
		for (User userInTraining: trainingUsers.getUserMap().values()){
			if(testUsers.getUserMap().containsKey(userInTraining.getUserId())){
				User userInTest = testUsers.getUserMap().get(userInTraining.getUserId());
				computeUserRecallValue(userInTraining,userInTest, para,result);
			}
		}
//		System.out.println("BuyCount = "+result.getAllUserBuyedCount());
	}
	
	public static void computeAllUserPrecisionValue(UserList trainingUsers,
			UserList testUsers,	ConfigurablePara para,ResultBean result) {
		for (User userInTraining: trainingUsers.getUserMap().values()){
			if(testUsers.getUserMap().containsKey(userInTraining.getUserId())){
				User userInTest = testUsers.getUserMap().get(userInTraining.getUserId());
				computerUserPrecisionValue(userInTraining,userInTest, para, result);
			}
		}
//		System.out.println("hitCount = "+result.getAllHitCountFromRecommendBrandToUser());
//		System.out.print("RecommendCount = "+result.getAllCountOfRecommendBrandToUser());
	}
	
	public static void computeUserRecallValue(Item userInTraining, 
			User userInTest, ConfigurablePara para, ResultBean result) {
//		allPreDictBrandsCount += user.getRecommendBrandsList().size();
		int startDay = para.getPredictStartDay();
		int endDay = para.getPredictEndDay();
		for (Record r : userInTest.getUserRecords()) {
			if(r.getRecordDay() <= endDay && r.getRecordDay() >= startDay){
				if(r.getUserActionType() == Global.BUY ){
					result.addToAllUserBuyedCount(1);
				}
			}
		}
	}
	
	public static void computerUserPrecisionValue(User userInTraining, 
			User userInTest, ConfigurablePara para, ResultBean result) {
		int num = userInTraining.getRecommendBrandsList().size();
		result.addToAllCountOfRecommendBrandToUser(num);
		int predictStartDay = para.getPredictStartDay();
		int predictEndDay = para.getPredictEndDay();
		for (Record r : userInTest.getUserRecords()) {
			if(r.getRecordDay() <= predictEndDay && r.getRecordDay() >= predictStartDay){
				if(r.getUserActionType() == Global.BUY && 
						userInTraining.getRecommendBrandsMap().containsKey(r.getBrandId()))
					result.addToAllHitCountFromRecommendBrandToUser(1); 
			}
		}
	}

	public static void outPutRecommendResult(UserList trainingUsers, ResultBean result,
			ConfigurablePara para, String filePath) throws IOException{
		File file = new File(filePath);
		if(file.exists())
			file.delete();
		file.createNewFile();
		int recommendCount = 0;
		@SuppressWarnings("resource")
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")); // 指定编码格式，以免读取时中文字符异常
		
		if(para.isAddResultAndParaToResultFile()){
			writer.append(para.toString());
			writer.append(result.toString());
		}
		int allRecommendCount = 0;
		for (User user : trainingUsers.getUserMap().values()) {
			allRecommendCount += user.getRecommendBrandsList().size();
		}
		float chance = (float) allRecommendCount
				/(float) Global.userSum * para.getLowerPPercentage();
		
		for (User user : trainingUsers.getUserMap().values()) {
			if (Math.random() < chance){
				RecommendBrand b = new RecommendBrand();
				int random = (int) ((float)ItemFactory.getAllRecords().getAllrecord().size() * Math.random()*(float)0.9);
				b.setBrandId(ItemFactory.getAllRecords().getAllrecord().get(random).getBrandId());
				user.addToRecommendBrandsList(b);
			}

			if(user.getRecommendBrandsList().size() > 0){
				writer.append(user.getUserId()+"\t");
								recommendCount += user.getRecommendBrandsList().size();
				for (int i = 0; i < user.getRecommendBrandsList().size(); i++) {
					writer.append(String.valueOf(
							user.getRecommendBrandsList().get(i).getBrandId()));
					if(i != user.getRecommendBrandsList().size() - 1)
						writer.append(",");
					else
					    writer.append("\n");
				}
			}

			writer.flush(); 
		}
		System.out.println("recommendCount = "+recommendCount);
		
	}
	
}
