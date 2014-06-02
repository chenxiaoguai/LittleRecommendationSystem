package common;

import java.util.HashMap;

public class Item {
	
	public  float clickBuyRatio = -1;
	protected HashMap<Integer, ActionChain> actionChainMap = new HashMap<Integer, ActionChain>();

	public Item get(int itemId) {return null;};

	public float getClickBuyRatio() {
		calculateClickBuyRatio();
		return clickBuyRatio;
	}

	public void setClickBuyRatio(float clickBuyRatio) {
		this.clickBuyRatio = clickBuyRatio;
	}

	public HashMap<Integer, ActionChain> getActionChainMap() {
		return actionChainMap;
	}
	public void calculateClickBuyRatio() {
		if(clickBuyRatio != -1)
			return;
		int buyCount = 0;
		for (ActionChain c : getActionChainMap().values()) {
			if(c.getBuyActionList().size() >= 1)
				buyCount ++;
		}
		setClickBuyRatio( (float)buyCount / (float) getActionChainMap().size());
		
	}
	
}