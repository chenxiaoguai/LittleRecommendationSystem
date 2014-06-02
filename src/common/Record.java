package common;


public class Record implements Comparable<Record>{


	public final static int CLICK = 0;
	public final static int BUY = 1;
	public final static int ADDTOCART = 2;
	public final static int FAVORITE = 3;
	
	private int recordId;
	private int userId;
	private int brandId;
	private int userActionType;
	private int recordDay;
	private int listIndex;
	
	
	public int getRecordDay() {
		return recordDay;
	}
	public void setRecordDay(int recordDay) {
		this.recordDay = recordDay;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public int getUserActionType() {
		return userActionType;
	}
	public void setUserActionType(int userActionType) {
		this.userActionType = userActionType;
	}
	
	/**
	 * @return the listIndex
	 */
	public int getListIndex() {
		return listIndex;
	}
	/**
	 * @param listIndex the listIndex to set
	 */
	public void setListIndex(int listIndex) {
		this.listIndex = listIndex;
	}
	@Override
	public int compareTo(Record o) {
		// TODO Auto-generated method stub
		int result = 0;
		if(this.recordDay < o.recordDay)
			result = -1;
		else if(this.recordDay == o.recordDay){

			if (this.recordId < o.recordId) {
				result = -1;
			} else if(this.recordId > o.recordId){
				result = 1;
			}
		}
			
		else if(this.recordDay > o.recordDay)
			result = 1;
		return result;
	}
	
	@Override
	public String toString(){
		String s = ""+recordId+","+userId+","+brandId+","+userActionType+","+recordDay+"\n";
		return s;
		
		
	}

}
