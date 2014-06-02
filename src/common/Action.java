package common;

public class Action {

	

	private int recordDate;
	private int brandId;
	private int userId;
	private int recordId;
	
	private Item  user;
	private Brand brand;
	private Record record;

	public Action() {
		super();
	}

	public Action(Record r){

		setRecordId(r.getRecordId());
		setRecordDate(r.getRecordDay());
		setUserId(r.getUserId());
		setBrandId(r.getBrandId());
		Brand b = (Brand) ItemFactory.getItem(
				getBrandId(), "TrainingBrand");
		setBrand(b);
		Item u = (Item) ItemFactory.getItem(
				getUserId(), "TrainingUser");
		setUser(u);
//		Record re = (Record) ItemFactory.getItem(
//				getRecordId(), "TrainingRecord");
		setRecord(r);
		
	}
	
	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public Item getUser() {
		return user;
	}


	public void setUser(Item user) {
		this.user = user;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public Record getRecord() {
		return record;
	}


	public void setRecord(Record record) {
		this.record = record;
	}


	/**
	 * @return the buyTime
	 */
	public int getRecordDate() {
		return recordDate;
	}

	/**
	 * @param buyTime the buyTime to set
	 */
	public void setRecordDate(int buyTime) {
		this.recordDate = buyTime;
	}

	/**
	 * @return the brandId
	 */
	public int getBrandId() {
		return brandId;
	}

	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void addToActionChain(ActionChain chain){
		if(getRecordDate() > chain.getLatestActionDay())
			chain.setLatestActionDay(getRecordDate());
		if(chain.getEarlistActionDay() >getRecordDate()
			|| chain.getEarlistActionDay()	== -1)
			chain.setEarlistActionDay(getRecordDate());
		chain.addToActionList(this);
	}
	
}