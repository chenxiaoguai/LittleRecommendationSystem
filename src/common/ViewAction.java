package common;


public class ViewAction extends Action {
	
	/**
	 * @return the viewTime
	 */
//	public  viewAction(Record r){
//		recordDate = r.getRecordDay();
//		brandId = r.getBrandId();
//		userId = r.getUserId();
//		recordId = r.getRecordId();
//	}
//	
//	/**
//	 * @return the recordDate
//	 */
//	public int getRecordDate() {
//		return recordDate;
//	}
//	/**
//	 * @param recordDate the recordDate to set
//	 */
//	public void setRecordDate(int recordDate) {
//		this.recordDate = recordDate;
//	}
	
	public ViewAction(Record r) {
		// TODO Auto-generated constructor stub
		super(r);
	}
   @Override
public void addToActionChain(ActionChain chain) {
	// TODO Auto-generated method stub
	   if(getRecordDate() > chain.getLatestViewDay())
		   chain.setLatestViewDay(getRecordDate());
	   if( getRecordDate() < chain.getEarlistViewDay()
			   || chain.getEarlistViewDay() == -1)
		   chain.setEarlistViewDay(getRecordDate());
	//   chain.setViewDayCount(viewDayCount);
	   
	   chain.getDayViewNumMap().put(getRecordDate(),
			   1+(chain.getDayViewNumMap().get(getRecordDate())
			   == null ? 0 : chain.getDayViewNumMap().get(getRecordDate()))  );
	  chain.addViewActionList(this);
	  super.addToActionChain(chain);
}
	
	
	
	

}
