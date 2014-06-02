package preanalysis;

import genrecommends.GenerateRecommends;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import resultanalysis.ComputingResult;
import resultanalysis.ConfigurablePara;
import rsutils.Global;
import rsutils.ResultBean;
import analysising.AnalysisBuyAction;
import analysising.AnalysisUser;
import common.*;


public class FileLoader {

	public static int transferDate(int month,int day){
		int transferedDay = 0;
		if(month == 4)
			transferedDay = day-15;
		if(month == 5)
			transferedDay = day+15;
		if(month == 6)	
			transferedDay = day+15+31;
		if(month == 7)
			transferedDay = day+15+31+30;
		if(month == 8)	
			transferedDay = day+15+31+30+31;
		Action action =  new Action();
		

		return transferedDay;	
	}
	
	
	public static void loadFile(UserList trainingUsers, UserList testUsers, 
			BrandList trainingBrands, RecordList trainingRecords, ConfigurablePara para) throws IOException
	{
		System.out.println("loading File");
		String fileName = "/Users/zhengjun/Documents/rs/2.csv";
		File file = new File(fileName);
		BufferedReader read = new BufferedReader(new FileReader(file));
		String line = null;
		String[] result = null;
		
		line=read.readLine();
		line=read.readLine();
		InputStream in = null;
		int recordId = 0;
		int buyCount = 0;
		int addToFavoriteCount = 0;
		int addToCartCount = 0;
		int buyCountTest = 0;
		int addToFavoriteCountTest = 0;
		int addToCartCountTest = 0;
		int maxRecordDay = 0;
		while(line != null){
//			System.out.println(line);
			result = line.split(",");
			Record record = new Record();
			record.setRecordId(recordId);
			record.setUserId(Integer.parseInt(result[0]));
			record.setBrandId(Integer.parseInt(result[1]));
			record.setUserActionType(Integer.parseInt(result[2]));
			record.setRecordDay(transferDate(Integer.parseInt(result[3]), Integer.parseInt(result[4])));
			if(record.getRecordDay() >= para.getStatisticStartDay()
					&& record.getRecordDay() <= para.getStatisticEndDay()){
				if(record.getRecordDay() > maxRecordDay)
					maxRecordDay = record.getRecordDay();
				trainingUsers.addRecordToAllUser(record);
				trainingBrands.addRecordToAllBrand(record);
				trainingRecords.addRecordToAllRecord(record);
				ItemFactory.getAllBrands().addRecordToAllBrand(record);
				ItemFactory.getAllRecords().addRecordToAllRecord(record);
				ItemFactory.getAllUsers().addRecordToAllUser(record);
				
				if(record.getUserActionType() == 1)
					buyCount ++;
				else if(record.getUserActionType() == 2)
					addToFavoriteCount ++;
				else if(record.getUserActionType() == 3)
					addToCartCount ++;
				
				recordId ++;
				assert recordId  == trainingRecords.getAllrecord().size();

			}else if(record.getRecordDay() >= para.getPredictStartDay()
					&& record.getRecordDay() <= para.getPredictEndDay()){
				testUsers.addRecordToAllUser(record);
				ItemFactory.getTestBrands().addRecordToAllBrand(record);
				ItemFactory.getTestUserRecords().addRecordToAllRecord(record);
				ItemFactory.getAllBrands().addRecordToAllBrand(record);
				ItemFactory.getAllRecords().addRecordToAllRecord(record);
				ItemFactory.getAllUsers().addRecordToAllUser(record);

				if(record.getUserActionType() == 1)
					buyCountTest ++;
				else if(record.getUserActionType() == 2)
					addToFavoriteCountTest ++;
				else if(record.getUserActionType() == 3)
					addToCartCountTest ++;
			}
			line = read.readLine();
		}
		
		System.out.println("maxrecordDay = "+maxRecordDay);
		para.setBuyCountInTrainingData(buyCount);
		para.setFavoriteCountInTrainingData(addToFavoriteCount);
		para.setAddCartCountInTrainingData(addToCartCount);
		
		Global.setUserSumInTraining(trainingUsers.getUserMap().size());
		Global.setBrandSumIntraining(trainingBrands.getBrandMap().size());
		Global.setBuySumInTraining(para.getBuyCountInTrainingData());
		
		para.setBuyCountInTestData(buyCountTest);
		para.setFavoriteCountInTestData(addToFavoriteCountTest);
		para.setAddCartCountInTestData(addToCartCountTest);

		read.close();
	}
	
	public static void analysising(UserList trainingUsers, UserList testUsers, 
			BrandList trainingBrand, ConfigurablePara para) throws IOException{
		System.out.println("pre analysis start.");
		
		PreAnalysis.PreAnalysising(trainingUsers, trainingBrand);
		System.out.println("pre analysis done.");
		System.out.println("analysising...");

		AnalysisBuyAction.statisticAllUserEarlistClickTimeBeforeBuy(trainingUsers);
		AnalysisBuyAction.statisticEveryBrandBuyCount(trainingBrand);
		AnalysisBuyAction.statisticBuyCountOfPreClickedBrand(31, 60, trainingUsers);
		AnalysisBuyAction.statisticUsersBuyCount(trainingUsers);
		AnalysisBuyAction.statisticBrandsSalesVolume(trainingBrand);
		AnalysisBuyAction.statisticBuyActionInTestDataHasActionInTrainingData(
				trainingUsers, testUsers, para);
		AnalysisUser.statisticUserBuyCount(trainingUsers);
		AnalysisUser.StatisticUserReBuyAction(trainingUsers);
		System.out.println("analysis done.");

		GenerateRecommends.generatingRecommends(para, trainingUsers,trainingBrand);
		ResultBean result = ComputingResult.computeF1(trainingUsers, testUsers, para);
		para.setAddResultAndParaToResultFile(false);
		ComputingResult.outPutRecommendResult(trainingUsers,result,para,"/Users/zhengjun/Desktop/demo.txt");
		para.setAddResultAndParaToResultFile(true);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		
		ComputingResult.outPutRecommendResult(trainingUsers,result,para,
				"/Users/zhengjun/Desktop/result/"+time+".txt");
		
		System.out.println(para.toString());
		System.out.println(result.toString());
		}
	
	public static void setParaMeter(ConfigurablePara para){
		int x = -10;
		para.setStatisticStartDay(0);
		para.setStatisticEndDay(x+91);
		para.setPredictStartDay(x+92);
		para.setPredictEndDay(x+122);
		para.setRecommendCompareType(Global.PurePreClick);
		para.setMaxRecommendNum( (float) 4.29);
		para.setMinBuyCountOfBrand(1);

	}
	public static void main(String[] args) throws IOException, UnsupportedFlavorException{
	
		UserList trainingUsers = new UserList();
		BrandList trainingBrands = new BrandList();
		RecordList trainingRecords = new RecordList();

		UserList testUsers = new UserList();
		BrandList testBrands = new BrandList();
		RecordList testRecords = new RecordList();

		UserList allUsers = new UserList();
		BrandList allBrands = new BrandList();
		RecordList allRecords = new RecordList();
		
		ItemFactory.setTrainingBrands(trainingBrands);
		ItemFactory.setTrainingUsers(trainingUsers);
		ItemFactory.setTrainingRecords(trainingRecords);
		
		ItemFactory.setTestBrands(testBrands);
		ItemFactory.setTestUsers(testUsers);
		ItemFactory.setTestUserRecords(testRecords);
		
		ItemFactory.setAllRecords(allRecords);
		ItemFactory.setAllBrands(allBrands);
		ItemFactory.setAllUsers(allUsers);
		ConfigurablePara para = new ConfigurablePara();
		setParaMeter(para);
		loadFile(trainingUsers, testUsers, trainingBrands, trainingRecords, para);
		
		analysising(trainingUsers, testUsers, trainingBrands,para);
		System.out.println("loading file done"+"recordSum="+
				allRecords.getAllrecord().size()+
				" userSum="+trainingUsers.getUserMap().size()+
				" brandSum= "+trainingBrands.getBrandMap().size());
		System.out.println(System.getenv().toString());
		String string = "s";
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		DataFlavor flavor[] = clipboard.getAvailableDataFlavors();
		flavor[1].toString();
//		flavor[1].getDefaultRepresentationClassAsString()
//		Object object = string;
		System.out.println(flavor[0].getDefaultRepresentationClassAsString());
		System.gc();

		//AnylasisBuyAction.earlistClickTimeBeforeBuy(allRecord.getAllrecord());
	}
}
