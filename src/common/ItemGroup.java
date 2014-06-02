package common;

import java.util.HashMap;

public class ItemGroup {

	private HashMap<Integer, Item> itemMap;

	/**
	 * @return the brandsMap
	 */
	public HashMap<Integer, Item> getItemsMap() {
		if (itemMap == null) {
			itemMap = new HashMap<Integer,Item>();
			
		}

		return itemMap;
	}

	/**
	 * @param brandsMap the brandsMap to set
	 */
	public void setItemMap(HashMap<Integer, Item> brandsMap) {
		this.itemMap = brandsMap;
	}
	
	public Item get(int key) {
		if(!getItemsMap().containsKey(key))
			return null;
		else 
			return getItemsMap().get(key);
	}
	
	public void put(Integer key, Item value) {
		if (itemMap == null) {
			itemMap = new HashMap<Integer,Item>();
		}
		getItemsMap().put(key, value);
	}

	public boolean containsKey(int key) {
		if(get(key) != null)
			return true;
		else
			return false;
	}

}
