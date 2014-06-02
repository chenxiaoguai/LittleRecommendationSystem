package common;

public class TopUserGroup extends ItemGroup {
	
	private	int minBuyCount;
	public static final TopUserGroup single = new TopUserGroup();
	
    private TopUserGroup() {
	}
	
    public static TopUserGroup getInstance(){
    	return single;
    }
	public void init(){
		UserList ul = ItemFactory.getTrainingUsers();
		for (User u : ul.getUserMap().values()) {
			if(u.getUserBuyCount() >= minBuyCount)
				put(u.getUserId(),u);
		}
	}
	
	
	@Override
	public Item get(int key) {
		if(getItemsMap() == null || getItemsMap().size() == 0)
			init();
		return (Item) super.get(key);
	}

	public int getMinBuyCount() {
		return minBuyCount;
	}

	public void setMinBuyCount(int minBuyCount) {
		this.minBuyCount = minBuyCount;
		init();
	}
	
	

}
